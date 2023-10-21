package br.com.api.service;

import br.com.api.model.DadosLaboratoriais;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public interface DadosLaboratoriaisService {
    ResponseEntity<Response<DadosLaboratoriais>> salvar(@RequestBody @Valid DadosLaboratoriais dadosLaboratoriais, BindingResult result);
    List<DadosLaboratoriais> getAll();
    ResponseEntity<Response<DadosLaboratoriais>> getById(Integer id);
    ResponseEntity<Response<DadosLaboratoriais>> deleteById(Integer id);
}
