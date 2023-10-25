package br.com.api.service.impl;

import br.com.api.model.Cidade;
import br.com.api.repository.BairroRepository;
import br.com.api.repository.CidadeRepository;
import br.com.api.responses.Response;
import br.com.api.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    private CidadeRepository repository;

    @Override
    public ResponseEntity<Response<Cidade>> salvar(@Valid Cidade cidade, BindingResult result) {
        Response<Cidade> response = new Response<Cidade>();
        response.setData(cidade);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(cidade);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Cidade> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Cidade>> getById(Integer id) {
        Response<Cidade> response = new Response<Cidade>();
        Cidade obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Cidade inválida");
        } catch (Exception ex) {
            response.getErrors().add("Cidade inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Cidade>> deleteById(Integer id) {
        Response<Cidade> response = new Response<Cidade>();
        Cidade obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Cidade inválida");
        } catch (Exception ex) {
            response.getErrors().add("Cidade inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}
