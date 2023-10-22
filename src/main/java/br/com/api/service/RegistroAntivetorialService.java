package br.com.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.api.model.RegistroAntivetorial;
import br.com.api.responses.Response;
import jakarta.validation.Valid;

import java.util.List;

@Service
public interface RegistroAntivetorialService {
    
    ResponseEntity<Response<RegistroAntivetorial>> salvar(@RequestBody @Valid RegistroAntivetorial registroAntivetorial, BindingResult result);
    List<RegistroAntivetorial> getAll();
    ResponseEntity<Response<RegistroAntivetorial>> getById(Integer id);
    ResponseEntity<Response<RegistroAntivetorial>> deleteById(Integer id);
}
