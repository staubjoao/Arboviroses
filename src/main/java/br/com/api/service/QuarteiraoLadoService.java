package br.com.api.service;

import br.com.api.model.Quarteirao;
import br.com.api.model.QuarteiraoLado;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface QuarteiraoLadoService {

    ResponseEntity<Response<QuarteiraoLado>> salvar(@Valid @RequestBody QuarteiraoLado quarteiraoLado, BindingResult result);
    List<QuarteiraoLado> getAll();
    ResponseEntity<Response<QuarteiraoLado>> getById(Integer id);
    ResponseEntity<Response<QuarteiraoLado>> deleteById(Integer id);

    List<QuarteiraoLado> getByQuarteirao(Quarteirao quarteirao);
}
