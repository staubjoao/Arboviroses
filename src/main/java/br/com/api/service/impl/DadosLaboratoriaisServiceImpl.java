package br.com.api.service.impl;

import br.com.api.model.DadosLaboratoriais;
import br.com.api.repository.DadosLaboratoriaisRepository;
import br.com.api.responses.Response;
import br.com.api.service.DadosLaboratoriaisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class DadosLaboratoriaisServiceImpl implements DadosLaboratoriaisService {
    @Autowired
    DadosLaboratoriaisRepository repository;
    @Override
    public ResponseEntity<Response<DadosLaboratoriais>> salvar(@Valid DadosLaboratoriais dadosLaboratoriais, BindingResult result) {
        Response<DadosLaboratoriais> response = new Response<DadosLaboratoriais>();
        response.setData(dadosLaboratoriais);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(dadosLaboratoriais);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<DadosLaboratoriais> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<DadosLaboratoriais>> getById(Integer id) {
        Response<DadosLaboratoriais> response = new Response<DadosLaboratoriais>();
        DadosLaboratoriais obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Dados Laboratoriais inválido");
        } catch (Exception ex) {
            response.getErrors().add("Dados Laboratoriais inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<DadosLaboratoriais>> deleteById(Integer id) {
        Response<DadosLaboratoriais> response = new Response<DadosLaboratoriais>();
        DadosLaboratoriais obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Dados Laboratoriais inválido");
        } catch (Exception ex) {
            response.getErrors().add("Dados Laboratoriais inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}
