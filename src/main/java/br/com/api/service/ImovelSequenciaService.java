package br.com.api.service;

import br.com.api.model.Imovel;
import br.com.api.model.ImovelSequencia;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ImovelSequenciaService {

    ResponseEntity<Response<ImovelSequencia>> salvar(@Valid @RequestBody ImovelSequencia imovelSequencia, BindingResult result);

    List<ImovelSequencia> getlAll();

    ResponseEntity<Response<ImovelSequencia>> getById(Integer id);

    ResponseEntity<Response<ImovelSequencia>> deleteById(Integer id);

    List<ImovelSequencia> getByImovel(Imovel imovel);
}
