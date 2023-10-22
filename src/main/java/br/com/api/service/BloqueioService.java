package br.com.api.service;

import br.com.api.model.Bloqueio;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface BloqueioService {

    ResponseEntity<Response<Bloqueio>> salvar(@Valid @RequestBody Bloqueio bloqueio, BindingResult result);

    List<Bloqueio> getlAll();

    ResponseEntity<Response<Bloqueio>> getById(Integer id);

    ResponseEntity<Response<Bloqueio>> deleteById(Integer id);

}
