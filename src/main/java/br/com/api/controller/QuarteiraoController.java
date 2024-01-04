package br.com.api.controller;

import br.com.api.dtos.CentroLocalidadeDTO;
import br.com.api.model.Quarteirao;
import br.com.api.responses.Response;
import br.com.api.service.impl.QuarteiraoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/quarteirao")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuarteiraoController {
    @Autowired
    private QuarteiraoServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Quarteirao>> post(@Valid @RequestBody Quarteirao quarteirao, BindingResult result) {
        return service.salvar(quarteirao, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Quarteirao> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Quarteirao>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Quarteirao>> put(@Valid @RequestBody Quarteirao quarteirao, BindingResult result) {
        return service.alterar(quarteirao, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Quarteirao>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @GetMapping("/agente/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    private List<Quarteirao> getQuarteiraoByAgente(@PathVariable Long usuarioId) {
        return service.getByUsuario(usuarioId);
    }

    @GetMapping("/localidade/{localidadeId}")
    @ResponseStatus(HttpStatus.OK)
    private List<Quarteirao> getQuarteiraoByLocalidade(@PathVariable Long localidadeId) {
        return service.getByLocalidade(localidadeId);
    }

    @GetMapping("/localidade/{localidadeId}/centro")
    @ResponseStatus(HttpStatus.OK)
    private CentroLocalidadeDTO getCentroLocalidade(@PathVariable Long localidadeId) {
        return service.getCentroLocalidade(localidadeId);
    }
}
