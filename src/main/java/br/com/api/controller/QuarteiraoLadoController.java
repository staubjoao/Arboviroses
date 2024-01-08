package br.com.api.controller;

import br.com.api.model.Quarteirao;
import br.com.api.model.QuarteiraoLado;
import br.com.api.responses.Response;
import br.com.api.service.impl.QuarteiraoLadoServiceImpl;
import br.com.api.service.impl.QuarteiraoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quarteirao_lado")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuarteiraoLadoController {

    @Autowired
    private QuarteiraoLadoServiceImpl service;

    @Autowired
    private QuarteiraoServiceImpl serviceQuarteirao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<QuarteiraoLado>> post(@Valid @RequestBody QuarteiraoLado quarteirao, BindingResult result) {
        return service.salvar(quarteirao, result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<QuarteiraoLado> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<QuarteiraoLado>> getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/quarteirao/{quarteiraoId}")
    @ResponseStatus(HttpStatus.CREATED)
    private List<QuarteiraoLado> getByQuarteirao(@PathVariable Integer quarteiraoId) {
        Quarteirao quarteirao = serviceQuarteirao.getById(quarteiraoId).getBody().getData();
        return service.getByQuarteirao(quarteirao);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<QuarteiraoLado>> put(@Valid @RequestBody QuarteiraoLado quarteirao, BindingResult result) {
        return service.salvar(quarteirao, result);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<QuarteiraoLado>> delete(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}
