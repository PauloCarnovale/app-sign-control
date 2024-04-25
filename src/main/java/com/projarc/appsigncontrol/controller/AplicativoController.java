package gr.hcg.controllers;

import com.projarc.appsigncontrol.dto.AplicativoDto;
import com.projarc.appsigncontrol.model.AplicativoModel;
import com.projarc.appsigncontrol.service.AplicativoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.InvalidNameException;
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

    @Autowired
    private AplicativoService aplicativoService;

    public AplicativoController(AplicativoService aplicativoService){
        this.aplicativoService = aplicativoService;
    }

    @GetMapping("/")
    public List<AplicativoModel> getAll() {
        return this.aplicativoService.getAll();
    }

    @GetMapping("/{id}")
    public AplicativoModel getById(@PathVariable Long id) {
        return this.aplicativoService.getById(id);
    }
}