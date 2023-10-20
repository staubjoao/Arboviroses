package br.com.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import br.com.api.model.AmostraLaboratorial;
import br.com.api.repository.AmostraLaboratorialRepository;
import br.com.api.responses.Response;
import br.com.api.service.AmostraLaboratorialService;
import jakarta.validation.Valid;

import java.util.List;

@Component


public class AmostraLaboratorialServiceImpl implements AmostraLaboratorialService {
    
    @Autowired
    private AmostraLaboratorialRepository repository;

    @Override
    public ResponseEntity<Response<AmostraLaboratorial>> salvar(@Valid AmostraLaboratorial amostraLaboratorial, BindingResult result) {
        Response<AmostraLaboratorial> response = new Response<AmostraLaboratorial>();
        response.setData(amostraLaboratorial);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(amostraLaboratorial);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<AmostraLaboratorial> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<AmostraLaboratorial>> getById(Integer id) {
        Response<AmostraLaboratorial> response = new Response<AmostraLaboratorial>();
        AmostraLaboratorial obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Amostra Laboratorial inválida");
        } catch (Exception ex) {
            response.getErrors().add("Amostra Laboratorial inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<AmostraLaboratorial>> deleteById(Integer id) {
        Response<AmostraLaboratorial> response = new Response<AmostraLaboratorial>();
        AmostraLaboratorial obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Amostra Laboratorial inválida");
        } catch (Exception ex) {
            response.getErrors().add("Amostra Laboratorial inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}
