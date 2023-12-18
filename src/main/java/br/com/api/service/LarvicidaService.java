package br.com.api.service;

import br.com.api.model.Larvicida;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;


@Service
public interface LarvicidaService {

    ResponseEntity<Response<Larvicida>> salvar(@Valid Larvicida larvicida, BindingResult result);

    List<Larvicida> getAll();

    ResponseEntity<Response<Larvicida>> getById(Long id);

    ResponseEntity<Response<Larvicida>> deleteById(Long id);
}