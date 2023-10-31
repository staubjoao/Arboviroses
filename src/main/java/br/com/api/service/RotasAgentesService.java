package br.com.api.service;

import java.util.List;

import br.com.api.model.Quarteirao;
import br.com.api.model.Usuario;
import io.swagger.models.auth.In;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.api.model.RotasAgentes;
import br.com.api.responses.Response;
import jakarta.validation.Valid;

@Service
public interface RotasAgentesService {
	
    ResponseEntity<Response<RotasAgentes>> salvar(@Valid @RequestBody RotasAgentes rotasAgentes, BindingResult result);
    List<RotasAgentes> getAll();
    ResponseEntity<Response<RotasAgentes>> getById(Integer id);
    ResponseEntity<Response<RotasAgentes>> deleteById(Integer id);
    public List<Quarteirao> getQuarteiroesByAgenteId(Long id);

}
