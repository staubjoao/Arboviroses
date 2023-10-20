package br.com.api.service;

import br.com.api.model.Imovel;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ImovelService {

    ResponseEntity<Response<Imovel>> salvar(@Valid @RequestBody Imovel imovel, BindingResult result);

    List<Imovel> getlAll();

    ResponseEntity<Response<Imovel>> getById(Integer id);

    ResponseEntity<Response<Imovel>> deleteById(Integer id);

}
