package br.com.api.services;

import br.com.api.model.Bairro;
import br.com.api.model.Logradouro;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface LogradouroService {
    ResponseEntity<Response<Logradouro>> salvar(@Valid @RequestBody Logradouro logradouro, BindingResult result);
    List<Logradouro> getAll();
    ResponseEntity<Response<Logradouro>> getById(Integer id);
    ResponseEntity<Response<Logradouro>> deleteById(Integer id);
}
