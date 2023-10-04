package br.com.api.controller;

import br.com.api.model.Bairro;
import br.com.api.model.Quarteirao;
import br.com.api.responses.Response;
import br.com.api.services.impl.QuarteiraoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/quarteirao")
public class QuarteiraoController {

    @Autowired
    private QuarteiraoServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Quarteirao>> post(
            @Valid @RequestBody Quarteirao quarteirao, BindingResult result) {

        Response<Quarteirao> response = new Response<>();
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(quarteirao);
        service.save(quarteirao);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Quarteirao> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Quarteirao>> getById(@PathVariable Integer id) {
        Quarteirao obj = service.getById(id);
        Response<Quarteirao> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Quarteirao não encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Quarteirao>> put(
            @PathVariable Integer id,
            @Valid @RequestBody Quarteirao quarteirao) {
        Quarteirao obj = service.getById(id);
        Response<Quarteirao> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Quarteirao nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        quarteirao.setId(obj.getId());
        response.setData(quarteirao);
        service.save(quarteirao);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Quarteirao>> delete(@PathVariable Integer id) {
        Quarteirao obj = service.getById(id);
        Response<Quarteirao> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Quarteirao nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        service.delete(obj);
        return ResponseEntity.ok(response);
    }
}
