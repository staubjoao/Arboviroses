package br.com.api.service.impl;

import br.com.api.model.Quarteirao;
import br.com.api.model.QuarteiraoLado;
import br.com.api.repository.QuarteiraoLadoRepository;
import br.com.api.responses.Response;
import br.com.api.service.QuarteiraoLadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class QuarteiraoLadoServiceImpl implements QuarteiraoLadoService {

    @Autowired
    QuarteiraoLadoRepository repository;

    @Override
    public ResponseEntity<Response<QuarteiraoLado>> salvar(QuarteiraoLado quarteiraoLado, BindingResult result) {
        Response<QuarteiraoLado> response = new Response<QuarteiraoLado>();
        response.setData(quarteiraoLado);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(quarteiraoLado);
        return ResponseEntity.ok(response);
    }
    @Override
    public List<QuarteiraoLado> getAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<QuarteiraoLado>> getById(Integer id) {
        Response<QuarteiraoLado> response = new Response<QuarteiraoLado>();
        QuarteiraoLado obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Lado quarteirão inválido");
        } catch (Exception ex) {
            response.getErrors().add("Lado quarteirão inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<QuarteiraoLado> getByQuarteirao(Quarteirao quarteirao) {
        return  repository.findByQuarteirao(quarteirao);
    }

    @Override
    public ResponseEntity<Response<QuarteiraoLado>> deleteById(Integer id) {
        Response<QuarteiraoLado> response = new Response<QuarteiraoLado>();
        QuarteiraoLado obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Lado quarteirão inválido");
        } catch (Exception ex) {
            response.getErrors().add("Lado quarteirão inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }
}
