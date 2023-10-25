package br.com.api.service;

import br.com.api.model.Cidade;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface CidadeService {

    ResponseEntity<Response<Cidade>> salvar(@Valid @RequestBody Cidade cidade, BindingResult result);

    List<Cidade> getlAll();

    ResponseEntity<Response<Cidade>> getById(Integer id);

    ResponseEntity<Response<Cidade>> deleteById(Integer id);

}