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

import br.com.api.model.BairroModel;
import br.com.api.responses.Response;
import br.com.api.serviceimpl.BairroServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bairro")
@CrossOrigin(origins = "*", maxAge = 3600)

public class BairroController {

    @Autowired
    private BairroServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<BairroModel>> inserir(@RequestBody @Valid BairroModel bairro, BindingResult result)
    {
        Response<BairroModel> response = new Response<BairroModel>();
        response.setData(bairro);
        if(result.hasErrors())
        {
            for(ObjectError errors: result.getAllErrors())
            {
                response.getErrors().add(errors.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(response);
        }

        service.save(bairro);

        return ResponseEntity.ok(response);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<BairroModel>> alterar(@RequestBody @Valid BairroModel bairro, BindingResult result)
    {
        Response<BairroModel> response = new Response<BairroModel>();
        response.setData(bairro);

        if(result.hasErrors())
        {
            for(ObjectError errors: result.getAllErrors())
            {
                response.getErrors().add(errors.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(response);
        }

        service.save(bairro);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public BairroModel getById(@PathVariable Integer id)
    {
        return service.getById(id);
    }

    @GetMapping
    public List<BairroModel> getAll()
    {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id)
    {
        BairroModel bairro = service.getById(id);
        service.delete(bairro);
    }
}