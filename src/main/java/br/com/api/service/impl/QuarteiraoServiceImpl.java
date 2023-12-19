package br.com.api.service.impl;

import br.com.api.model.Quarteirao;
import br.com.api.repository.QuarteiraoRepository;
import br.com.api.responses.Response;
import br.com.api.service.QuarteiraoService;
import jakarta.validation.Valid;
import org.geolatte.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.awt.*;
import java.util.List;

@Component
public class QuarteiraoServiceImpl implements QuarteiraoService {
    @Autowired
    QuarteiraoRepository repository;

    @Override
    public ResponseEntity<Response<Quarteirao>> salvar(@Valid Quarteirao quarteirao, BindingResult result) {
        Response<Quarteirao> response = new Response<Quarteirao>();

        response.setData(quarteirao);

        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(quarteirao);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Quarteirao> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Quarteirao>> getById(Integer id) {
        Response<Quarteirao> response = new Response<Quarteirao>();
        Quarteirao obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Quarteirão inválido");
        } catch (Exception ex) {
            response.getErrors().add("Quarteirão inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Quarteirao>> deleteById(Integer id) {
        Response<Quarteirao> response = new Response<Quarteirao>();
        Quarteirao obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Quarteirão inválido");
        } catch (Exception ex) {
            response.getErrors().add("Quarteirão inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Quarteirao> getByUsuario(Long id) {
        return repository.findQuarteiroesByUsuarioId(id);
    }
}