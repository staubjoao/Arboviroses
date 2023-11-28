package br.com.api.service;

import br.com.api.model.Municipio;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface MunicipioService {

    ResponseEntity<Response<Municipio>> salvar(@Valid @RequestBody Municipio municipio, BindingResult result);

    List<Municipio> getlAll();

    ResponseEntity<Response<Municipio>> getById(Integer id);

    ResponseEntity<Response<Municipio>> deleteById(Integer id);

}