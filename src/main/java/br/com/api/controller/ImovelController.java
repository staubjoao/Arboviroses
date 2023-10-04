package br.com.api.controller;

import br.com.api.model.Imovel;
import br.com.api.responses.Response;
import br.com.api.services.impl.ImovelServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imovel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImovelController {

    @Autowired
    private ImovelServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Imovel>> post(
            @Valid @RequestBody Imovel imovel, BindingResult result) {

        Response<Imovel> response = new Response<>();
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(imovel);
        service.save(imovel);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    private List<Imovel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<Response<Imovel>> getById(@PathVariable Integer id) {
        Imovel obj = service.getById(id);
        Response<Imovel> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Imovel não encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Imovel>> put(
            @PathVariable Integer id,
            @Valid @RequestBody Imovel imovel) {
        Imovel obj = service.getById(id);
        Response<Imovel> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Imovel nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        imovel.setId(obj.getId());
        response.setData(imovel);
        service.save(imovel);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Imovel>> delete(@PathVariable Integer id) {
        Imovel obj = service.getById(id);
        Response<Imovel> response = new Response<>();
        if (obj == null) {
            response.getErrors().add("Imovel nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        service.delete(obj);
        return ResponseEntity.ok(response);
    }
}
