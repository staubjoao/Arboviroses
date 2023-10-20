package br.com.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.api.model.AmostraLaboratorial;
import br.com.api.responses.Response;
import jakarta.validation.Valid;

import java.util.List;

@Service

public interface AmostraLaboratorialService {
    
    ResponseEntity<Response<AmostraLaboratorial>> salvar(@RequestBody @Valid AmostraLaboratorial amostraLaboratorial, BindingResult result);
    List<AmostraLaboratorial> getlAll();
    ResponseEntity<Response<AmostraLaboratorial>> getById(Integer id);
    ResponseEntity<Response<AmostraLaboratorial>> deleteById(Integer id);
}
