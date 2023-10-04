package br.com.api.controller;

import br.com.api.model.Logradouro;
import br.com.api.responses.Response;
import br.com.api.services.impl.LogradouroServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/logradouro")
public class LogradouroController {

    @Autowired
    private LogradouroServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Logradouro>> post(
            @Valid @RequestBody Logradouro logradouro, BindingResult result) {

        Response<Logradouro> response = new Response<>();
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
    private List<Logradouro> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Logradouro>> getById(@PathVariable Integer id) {
        Logradouro obj = service.getById(id);
        Response<Logradouro> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Logradouro não encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Logradouro>> put(
            @PathVariable Integer id,
            @Valid @RequestBody Logradouro logradouro) {
        Logradouro obj = service.getById(id);
        Response<Logradouro> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Logradouro nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        logradouro.setId(obj.getId());
        response.setData(logradouro);
        service.save(logradouro);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Logradouro>> delete(@PathVariable Integer id) {
        Logradouro obj = service.getById(id);
        Response<Logradouro> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Logradouro nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        service.delete(obj);
        return ResponseEntity.ok(response);
    }
}
