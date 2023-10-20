package br.com.api.service.impl;

import br.com.api.model.Rota;
import br.com.api.repository.RotaRepository;
import br.com.api.responses.Response;
import br.com.api.service.RotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class RotaServiceImpl implements RotaService {

    @Autowired
    private RotaRepository repository;

    @Override
    public ResponseEntity<Response<Rota>> salvar(@Valid Rota rota, BindingResult result) {
        Response<Rota> response = new Response<Rota>();
        response.setData(rota);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(rota);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Rota> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Rota>> getById(Integer id) {
        Response<Rota> response = new Response<Rota>();
        Rota obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Rota inválida");
        } catch (Exception ex) {
            response.getErrors().add("Rota inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Rota>> deleteById(Integer id) {
        Response<Rota> response = new Response<Rota>();
        Rota obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Rota inválida");
        } catch (Exception ex) {
            response.getErrors().add("Rota inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

}
