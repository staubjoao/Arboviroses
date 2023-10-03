package br.com.api.controller;

import java.util.List;

import br.com.api.services.LocalidadeService;

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
import br.com.api.serviceimpl.LocalidadeServiceImpl;


import javax.validation.Valid;


@RestController
@RequestMapping("/api/localidade")
@CrossOrigin(origins = "*", maxAge = 3600)

public class LocalidadeController {

    @Autowired
    private LocalidadeServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Localidade>> inserir(@RequestBody @Valid Localidade localidade, BindingResult result)
    {
        Response<Localidade> response = new Response<Localidade>();
        response.setData(localidade);

        if(result.hasErrors())
        {
            for(ObjectError errors: result.getAllErrors())
            {
                response.getErrors().add(errors.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(response);
        }

        service.save(localidade);

        return ResponseEntity.ok(response);


    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Localidade>> alterar(@RequestBody @Valid Localidade localidade, BindingResult result)
    {
        Response<Localidade> response = new Response<Localidade>();
        response.setData(localidade);

        if(result.hasErrors())
        {
            for(ObjectError errors: result.getAllErrors())
            {
                response.getErrors().add(errors.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(response);
        }

        service.save(localidade);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Localidade>> getById(@PathVariable Integer id)
    {
        Response<Localidade> response = new Response<Localidade>();
        Localidade localidade = service.getById(id);
        response.setData(localidade);

        if(localidade == null)
        {
            response.getErrors().add("{campo.localidade.invalido}");
            return ResponseEntity.badRequest().body(response);
    
        }

        service.getById(id);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)    
    public ResponseEntity<List<Localidade>> getAll()
    {
        List<Localidade> localidade = service.getAll();
        return ResponseEntity.ok(localidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable Integer id, BindingResult result)
    {   
        Response<Localidade> response = new Response<Localidade>();

        if(result.hasErrors())
        {
            for(ObjectError errors: result.getAllErrors())
            {
                response.getErrors().add(errors.getDefaultMessage());
            }

            ResponseEntity.badRequest().body(response);
        }

        Localidade obj = service.getById(id);
        service.delete(obj);

    }
}