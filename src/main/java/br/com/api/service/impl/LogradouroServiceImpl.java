package br.com.api.service.impl;

import br.com.api.model.Logradouro;
import br.com.api.repository.LogradouroRepository;
import br.com.api.responses.Response;
import br.com.api.service.LogradouroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class LogradouroServiceImpl implements LogradouroService {
    @Autowired
    LogradouroRepository repository;

    @Override
    public ResponseEntity<Response<Logradouro>> salvar(@Valid Logradouro logradouro, BindingResult result) {
        Response<Logradouro> response = new Response<Logradouro>();
        response.setData(logradouro);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(logradouro);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Logradouro> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Logradouro>> getById(Integer id) {
        Response<Logradouro> response = new Response<Logradouro>();
        Logradouro obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Logradouro inválido");
        } catch (Exception ex) {
            response.getErrors().add("Logradouro inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Logradouro>> deleteById(Integer id) {
        Response<Logradouro> response = new Response<Logradouro>();
        Logradouro obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Logradouro inválido");
        } catch (Exception ex) {
            response.getErrors().add("Logradouro inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}