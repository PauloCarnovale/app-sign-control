package gr.hcg.controllers;

import com.google.gson.JsonObject;
import com.projarc.appsigncontrol.dto.AplicativoDto;
import com.projarc.appsigncontrol.model.AplicativoModel;
import com.projarc.appsigncontrol.service.AplicativoService;

import gr.hcg.check.PDFSignatureInfo;
import gr.hcg.check.PDFSignatureInfoParser;
import gr.hcg.services.UploadDocumentService;
import gr.hcg.sign.Signer;
import gr.hcg.views.JsonView;
import org.bouncycastle.tsp.TSPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.InvalidNameException;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Controller
public class AplicativoController {

    private AplicativoService aplicativoService;

    @Autowired
    public AplicativoController(AplicativoService aplicativoService){
        this.aplicativoService = aplicativoService;
    }

    @GetMapping("/")
    public List<AplicativoModel> getAll() {
        return this.aplicativoService.getAll();
    }
}