package br.com.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import br.com.api.model.Localidade;
import br.com.api.repository.LocalidadeRepository;
import br.com.api.responses.Response;
import br.com.api.services.LocalidadeService;
import jakarta.validation.Valid;

import java.util.List;

@Component
public class LocalidadeServiceImpl implements LocalidadeService {

    @Autowired
    private LocalidadeRepository repository;

    @Override
    public ResponseEntity<Response<Localidade>> salvar(@Valid Localidade localidade, BindingResult result) {
        Response<Localidade> response = new Response<Localidade>();
        response.setData(localidade);

        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(response);
        }

        repository.save(localidade);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Localidade> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Localidade>> getById(Integer id) {
        Response<Localidade> response = new Response<Localidade>();
        Localidade obj = null;

        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Localidade inválida.");
        } catch (Exception ex) {
            response.getErrors().add("Localidade inválida.");
        }

        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Localidade>> deleteById(Integer id) {
        Response<Localidade> response = new Response<Localidade>();
        Localidade obj = null;

        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Localidade invalida.");
        } catch (Exception ex) {
            response.getErrors().add("Localidade invalida.");
        }

        response.setData(obj);
        return ResponseEntity.ok(response);
    }

}