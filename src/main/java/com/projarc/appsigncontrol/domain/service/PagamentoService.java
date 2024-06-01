package com.projarc.appsigncontrol.domain.service;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projarc.appsigncontrol.application.dto.PagamentoDto;
import com.projarc.appsigncontrol.domain.model.PagamentoModel;
import com.projarc.appsigncontrol.enums.Promocoes;
import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;
import com.projarc.appsigncontrol.persistence.entity.PagamentoEntity;
import com.projarc.appsigncontrol.persistence.repository.PagamentoRepository;

import com.projarc.appsigncontrol.enums.PagamentoStatus;

import java.time.LocalDate;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;
    private AssinaturaService assinaturaService;

    public PagamentoService(PagamentoRepository pagamentoRepository, AssinaturaService assinaturaService) {
        this.pagamentoRepository = pagamentoRepository;
        this.assinaturaService = assinaturaService;
    }

    public PagamentoModel create(PagamentoDto payload) {
        AssinaturaEntity assinatura = this.assinaturaService.getById(payload.getAssinaturaId());
        if (assinatura == null)
            throw new InvalidParameterException();

        if (AssinaturaEntity.isAssinaturaAtiva(assinatura.getFimVigencia())) {
            // Adiciona-se 30 dias ao fim da vigencia
            assinatura.setDataFim(assinatura.getFimVigencia().plusMonths(1));
        } else {
            // Renovada a assinatura com a data atual
            assinatura.setInicioVigencia(LocalDate.now());
            assinatura.setDataFim(LocalDate.now().plusDays(30));
        }
        System.out.println(assinatura.toString());
        Promocoes promo = Promocoes.valueOf(payload.getPromocao());
        double valorPago = payload.getValorPago() * (1 - promo.getDiscount());

        double valorEstornado = Math.abs(valorPago - assinatura.getAplicativo().getCustoMensal());
        PagamentoStatus status = PagamentoStatus.PAGAMENTO_OK;
        if (valorPago - assinatura.getAplicativo().getCustoMensal() * (1 - promo.getDiscount()) < 0) {
            status = PagamentoStatus.VALOR_INCORRETO;
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format(
                    "Valor de pagamento menor que da assinatura (R$ %f)", assinatura.getAplicativo().getCustoMensal()));
        }

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setAssinatura(assinatura);
        pagamentoEntity.setDataPagamento(LocalDate.now());
        pagamentoEntity.setValorPago(valorPago);
        pagamentoEntity.setPromocao(payload.getPromocao());

        PagamentoEntity newPayment = this.pagamentoRepository.saveAndFlush(pagamentoEntity);
        this.assinaturaService.renew(assinatura);

        return PagamentoEntity.toPagamentoModel(newPayment, status, valorEstornado);
    }
}
