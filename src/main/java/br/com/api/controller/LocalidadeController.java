package br.com.api.controller;

import java.util.List;
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

import br.com.api.model.LocalidadeModel;
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
    private ResponseEntity<Response<LocalidadeModel>> inserir(@RequestBody @Valid LocalidadeModel localidade, BindingResult result)
    {
        Response<LocalidadeModel> response = new Response<LocalidadeModel>();
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
    private ResponseEntity<Response<LocalidadeModel>> alterar(@RequestBody @Valid LocalidadeModel localidade, BindingResult result)
    {
        Response<LocalidadeModel> response = new Response<LocalidadeModel>();
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
    public LocalidadeModel getById(@PathVariable Integer id)
    {
        return service.getById(id);
    }

    @GetMapping
    public List<LocalidadeModel> getAll()
    {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {   
        LocalidadeModel obj = service.getById(id);
        service.delete(obj);
    }
}