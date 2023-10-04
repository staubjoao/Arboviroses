package br.com.api.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Localidade;

import br.com.api.responses.Response;
import br.com.api.services.impl.LocalidadeServiceImpl;


@RestController
@RequestMapping("/api/localidade")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LocalidadeController {

    @Autowired
    private LocalidadeServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Localidade>> post(
            @Valid @RequestBody Localidade localidade, BindingResult result) {

        Response<Localidade> response = new Response<>();
        response.setData(localidade);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }

        service.save(localidade);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Localidade> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Localidade>> getById(@PathVariable Integer id) {
        Localidade obj = service.getById(id);
        Response<Localidade> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Localidade não encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Localidade>> put(
            @PathVariable Integer id,
            @Valid @RequestBody Localidade localidade) {
        Localidade obj = service.getById(id);
        Response<Localidade> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Quarteirao nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        localidade.setId(obj.getId());
        response.setData(localidade);
        service.save(localidade);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Localidade>> delete(@PathVariable Integer id) {
        Localidade obj = service.getById(id);
        Response<Localidade> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Quarteirao nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        service.delete(obj);
        return ResponseEntity.ok(response);
    }
}