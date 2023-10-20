package br.com.api.controller;

import br.com.api.model.TipoImovel;
import br.com.api.responses.Response;
import br.com.api.service.impl.TipoImovelServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
    private ResponseEntity<Response<TipoImovel>> post(@Valid @RequestBody TipoImovel tipoImovel, BindingResult result) {
        return service.salvar(tipoImovel, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<TipoImovel> getAll() {
        return service.getlAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Response<TipoImovel>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<TipoImovel>> put(@Valid @RequestBody TipoImovel tipoImovel, BindingResult result) {
        return service.salvar(tipoImovel, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<TipoImovel>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

}
