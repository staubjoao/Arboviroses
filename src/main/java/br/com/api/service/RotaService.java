package br.com.api.service;

import br.com.api.model.Rota;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface RotaService {

    ResponseEntity<Response<Rota>> salvar(@Valid @RequestBody Rota rota, BindingResult result);

    List<Rota> getlAll();

    ResponseEntity<Response<Rota>> getById(Integer id);

    ResponseEntity<Response<Rota>> deleteById(Integer id);

}
