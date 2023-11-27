package br.com.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.api.model.Bairro;
import br.com.api.responses.Response;
import jakarta.validation.Valid;

import java.util.List;

@Service
public interface BairroService {

    ResponseEntity<Response<Bairro>> salvar(@Valid @RequestBody Bairro bairro, BindingResult result);

    List<Bairro> getlAll();

    ResponseEntity<Response<Bairro>> getById(Integer id);

    ResponseEntity<Response<Bairro>> deleteById(Integer id);

    boolean isNomeValido(String nome);

}