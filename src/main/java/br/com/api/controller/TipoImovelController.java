package br.com.api.controller;

import br.com.api.model.TipoImovel;

import br.com.api.responses.Response;
import br.com.api.services.impl.TipoImovelServiceImpl;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo_imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TipoImovelController {

    @Autowired
    private TipoImovelServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<TipoImovel>> post(
            @Valid @RequestBody TipoImovel logradouro, BindingResult result) {

        Response<TipoImovel> response = new Response<>();
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(logradouro);
        service.save(logradouro);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<TipoImovel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<TipoImovel>> getById(@PathVariable Integer id) {
        TipoImovel obj = service.getById(id);
        Response<TipoImovel> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Tipo imovel não encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<TipoImovel>> put(
            @PathVariable Integer id,
            @Valid @RequestBody TipoImovel tipoImovel) {
        TipoImovel obj = service.getById(id);
        Response<TipoImovel> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Tipo imovel nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        tipoImovel.setId(obj.getId());
        response.setData(tipoImovel);
        service.save(tipoImovel);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<TipoImovel>> delete(@PathVariable Integer id) {
        TipoImovel obj = service.getById(id);
        Response<TipoImovel> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Tipo imovel nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        service.delete(obj);
        return ResponseEntity.ok(response);
    }

}
