package br.com.api.service.impl;

import br.com.api.model.Municipio;
import br.com.api.repository.MunicipioRepository;
import br.com.api.responses.Response;
import br.com.api.service.MunicipioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class MunicipioServiceImpl implements MunicipioService {

    @Autowired
    private MunicipioRepository repository;

    @Override
    public ResponseEntity<Response<Municipio>> salvar(@Valid Municipio municipio, BindingResult result) {
        Response<Municipio> response = new Response<Municipio>();
        response.setData(municipio);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(municipio);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Municipio> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Municipio>> getById(Integer id) {
        Response<Municipio> response = new Response<Municipio>();
        Municipio obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Município inválido");
        } catch (Exception ex) {
            response.getErrors().add("Município inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Municipio>> deleteById(Integer id) {
        Response<Municipio> response = new Response<Municipio>();
        Municipio obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Município inválido");
        } catch (Exception ex) {
            response.getErrors().add("Município inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}
