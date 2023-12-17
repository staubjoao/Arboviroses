package br.com.api.service;

import br.com.api.model.larvicida;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;


@Service
public interface LarvicidaService {

    ResponseEntity<Response<larvicida>> salvar(@Valid larvicida larvicida, BindingResult result);

    List<larvicida> getAll();

    ResponseEntity<Response<larvicida>> getById(Long id);

    ResponseEntity<Response<larvicida>> deleteById(Long id);
}