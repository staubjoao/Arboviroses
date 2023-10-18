package br.com.api.services.impl;

import br.com.api.model.TipoImovel;
import br.com.api.repository.TipoImovelRepository;
import br.com.api.responses.Response;
import br.com.api.services.TipoImovelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class TipoImovelServiceImpl implements TipoImovelService {
    @Autowired
    private TipoImovelRepository repository;

    @Override
    public ResponseEntity<Response<TipoImovel>> salvar(@Valid TipoImovel tipoImovel, BindingResult result) {
        Response<TipoImovel> response = new Response<TipoImovel>();
        response.setData(tipoImovel);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(tipoImovel);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<TipoImovel> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<TipoImovel>> getById(Integer id) {
        Response<TipoImovel> response = new Response<TipoImovel>();
        TipoImovel obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Tipo imóvel inválido");
        } catch (Exception ex) {
            response.getErrors().add("Tipo imóvel inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<TipoImovel>> deleteById(Integer id) {
        Response<TipoImovel> response = new Response<TipoImovel>();
        TipoImovel obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Tipo imóvel inválido");
        } catch (Exception ex) {
            response.getErrors().add("Tipo imóvel inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}
