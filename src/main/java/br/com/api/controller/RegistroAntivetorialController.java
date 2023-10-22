package br.com.api.controller;

import br.com.api.model.RegistroAntivetorial;
import br.com.api.responses.Response;
import br.com.api.service.impl.RegistroAntivetorialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/registro_antivetorial")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RegistroAntivetorialController {
    
    @Autowired
    private RegistroAntivetorialServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<RegistroAntivetorial>> post(@Valid @RequestBody RegistroAntivetorial registroAntivetorial, BindingResult result) {
        return service.salvar(registroAntivetorial, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<RegistroAntivetorial> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<RegistroAntivetorial>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<RegistroAntivetorial>> put(@Valid @RequestBody RegistroAntivetorial registroAntivetorial, BindingResult result) {
        return service.salvar(registroAntivetorial, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<RegistroAntivetorial>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
