package br.com.api.service;

import br.com.api.model.Localidade;
import br.com.api.responses.Response;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface LocalidadeService {

    ResponseEntity<Response<Localidade>> salvar(@Valid @RequestBody Localidade localidade, BindingResult result);

    List<Localidade> getAll();

    ResponseEntity<Response<Localidade>> getById(Integer id);

    ResponseEntity<Response<Localidade>> deleteById(Integer id);
}