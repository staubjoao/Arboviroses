package br.com.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.com.api.model.Bairro;
import br.com.api.repository.BairroRepository;
import br.com.api.responses.Response;
import br.com.api.service.BairroService;
import jakarta.validation.Valid;

import java.util.List;

@Component
public class BairroServiceImpl implements BairroService {

    @Autowired
    private BairroRepository repository;

    @Override
    public ResponseEntity<Response<Bairro>> salvar(@Valid Bairro bairro, BindingResult result) {
        Response<Bairro> response = new Response<Bairro>();
        response.setData(bairro);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(bairro);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Bairro> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Bairro>> getById(Integer id) {
        Response<Bairro> response = new Response<Bairro>();
        Bairro obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Bairro inválido");
        } catch (Exception ex) {
            response.getErrors().add("Bairro inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Bairro>> deleteById(Integer id) {
        Response<Bairro> response = new Response<Bairro>();
        Bairro obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Bairro inválido");
        } catch (Exception ex) {
            response.getErrors().add("Bairro inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }


}
