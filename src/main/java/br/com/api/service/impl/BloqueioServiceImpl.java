package br.com.api.service.impl;

import br.com.api.model.Bloqueio;
import br.com.api.repository.BloqueioRepository;
import br.com.api.responses.Response;
import br.com.api.service.BloqueioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class BloqueioServiceImpl implements BloqueioService {

    @Autowired
    private BloqueioRepository repository;

    @Override
    public ResponseEntity<Response<Bloqueio>> salvar(@Valid Bloqueio bloqueio, BindingResult result) {
        Response<Bloqueio> response = new Response<Bloqueio>();
        response.setData(bloqueio);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(bloqueio);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Bloqueio> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Bloqueio>> getById(Integer id) {
        Response<Bloqueio> response = new Response<Bloqueio>();
        Bloqueio obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Bloqueio inválido");
        } catch (Exception ex) {
            response.getErrors().add("Bloqueio inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Bloqueio>> deleteById(Integer id) {
        Response<Bloqueio> response = new Response<Bloqueio>();
        Bloqueio obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Bloqueio inválido");
        } catch (Exception ex) {
            response.getErrors().add("Bloqueio inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

}
