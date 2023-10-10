package br.com.api.services;

import br.com.api.model.TipoImovel;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface TipoImovelService {

    ResponseEntity<Response<TipoImovel>> salvar(@Valid @RequestBody TipoImovel tipoImovel, BindingResult result);

    List<TipoImovel> getlAll();

    ResponseEntity<Response<TipoImovel>> getById(Integer id);

    ResponseEntity<Response<TipoImovel>> deleteById(Integer id);
}
