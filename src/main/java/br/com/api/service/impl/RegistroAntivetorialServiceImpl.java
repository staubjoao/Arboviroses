package br.com.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;


import br.com.api.model.RegistroAntivetorial;
import br.com.api.repository.RegistroAntivetorialRepository;
import br.com.api.responses.Response;
import br.com.api.service.RegistroAntivetorialService;
import jakarta.validation.Valid;

import java.util.List;

@Component
public class RegistroAntivetorialServiceImpl implements RegistroAntivetorialService{
    
    @Autowired
    private RegistroAntivetorialRepository repository;

    @Override
    public ResponseEntity<Response<RegistroAntivetorial>> salvar(@Valid RegistroAntivetorial registroAntivetorial, BindingResult result) {
        Response<RegistroAntivetorial> response = new Response<RegistroAntivetorial>();
        response.setData(registroAntivetorial);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(registroAntivetorial);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<RegistroAntivetorial> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<RegistroAntivetorial>> getById(Integer id) {
        Response<RegistroAntivetorial> response = new Response<RegistroAntivetorial>();
        RegistroAntivetorial obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Registro Antivetorial inválida");
        } catch (Exception ex) {
            response.getErrors().add("Registro Antivetorial inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<RegistroAntivetorial>> deleteById(Integer id) {
        Response<RegistroAntivetorial> response = new Response<RegistroAntivetorial>();
        RegistroAntivetorial obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Registro Antivetorial inválida");
        } catch (Exception ex) {
            response.getErrors().add("Registro Antivetorial inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}
