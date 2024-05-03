package com.projarc.appsigncontrol.domain.service;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarc.appsigncontrol.application.dto.PagamentoDto;
import com.projarc.appsigncontrol.domain.model.PagamentoModel;
import com.projarc.appsigncontrol.persistence.entity.AssinaturaEntity;
import com.projarc.appsigncontrol.persistence.entity.PagamentoEntity;
import com.projarc.appsigncontrol.persistence.repository.AssinaturaRepository;
import com.projarc.appsigncontrol.persistence.repository.PagamentoRepository;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;
    private AssinaturaRepository assinaturaRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public List<PagamentoDto> getAll() {
        List<PagamentoEntity> pagamentos = this.pagamentoRepository.findAll();
        if (pagamentos.size() == 0) {
            return new LinkedList<PagamentoDto>();
        } else {
            return pagamentos.stream()
                    .map(pagamento -> PagamentoEntity.toPagamentoDto(pagamento))
                    .toList();
        }
    }

    public PagamentoModel getById(long id) {
        PagamentoEntity pagamento = pagamentoRepository.getReferenceById(id);
        if (pagamento == null) {
            return null;
        } else {
            return PagamentoEntity.toPagamentoModel(pagamento);
        }
    }

    public PagamentoEntity create(PagamentoDto payload) {
        AssinaturaEntity assinatura = this.assinaturaRepository.getReferenceById(payload.getId());
        if (assinatura == null)
            throw new InvalidParameterException();

        PagamentoEntity pagamentoEntity = new PagamentoEntity(payload.getId(), assinatura, payload.getValorPago(),
                payload.getDataPagamento(), payload.getPromocao());
        return this.pagamentoRepository.saveAndFlush(pagamentoEntity);
    }
}
