package br.com.api.controller;

import java.util.List;

import br.com.api.model.Bairro;
import br.com.api.services.impl.BairroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import br.com.api.responses.Response;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/bairro")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BairroController {

    @Autowired
    private BairroServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Bairro>> post(
            @Valid @RequestBody Bairro bairro, BindingResult result) {

        Response<Bairro> response = new Response<>();
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(bairro);
        service.save(bairro);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Bairro> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Bairro>> getById(@PathVariable Integer id) {
        Bairro obj = service.getById(id);
        Response<Bairro> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Bairro não encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Bairro>> put(
            @PathVariable Integer id,
            @Valid @RequestBody Bairro bairro) {
        Bairro obj = service.getById(id);
        Response<Bairro> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Bairro nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        bairro.setId(obj.getId());
        response.setData(bairro);
        service.save(bairro);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Bairro>> delete(@PathVariable Integer id) {
        Bairro obj = service.getById(id);
        Response<Bairro> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Bairro nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        service.delete(obj);
        return ResponseEntity.ok(response);
    }
}