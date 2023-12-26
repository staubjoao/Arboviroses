package br.com.api.service;

import br.com.api.dtos.CentroLocalidadeDTO;
import br.com.api.model.Quarteirao;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface QuarteiraoService {
    ResponseEntity<Response<Quarteirao>> salvar(@Valid @RequestBody Quarteirao quarteirao, BindingResult result);
    ResponseEntity<Response<Quarteirao>> alterar(@Valid @RequestBody Quarteirao quarteirao, BindingResult result);
    List<Quarteirao> getAll();
    ResponseEntity<Response<Quarteirao>> getById(Integer id);
    ResponseEntity<Response<Quarteirao>> deleteById(Integer id);
    List<Quarteirao> getByUsuario(Long id);
    List<Quarteirao> getByLocalidade(Long id);
    CentroLocalidadeDTO getCentroLocalidade(Long id);

}
