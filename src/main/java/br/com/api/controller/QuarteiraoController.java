package br.com.api.controller;

import br.com.api.dtos.QuarteiraoDTO;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/quarteirao")
public class QuarteiraoController {

    @Autowired
    private QuarteiraoServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Quarteirao>> listarTodos(){
        List<Quarteirao> quarteirao = service.getAll();
        return ResponseEntity.ok(quarteirao);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> listaUmQuarteirao(@PathVariable(value = "id") int id) {
        Optional<Quarteirao> obj = service.buscaId(id);
        Response<Optional<Quarteirao>> response = new Response<>();
        if(!obj.isPresent())
        {
            response.getErrors().add("quarteirao nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Quarteirao>> iserirQuarteirao(
            @Valid @RequestBody QuarteiraoDTO quarteiraoDTO, BindingResult result){
        var quarteirao = new Quarteirao(quarteiraoDTO);
        Response<Quarteirao> response = new Response<Quarteirao>();
        if(result.hasErrors())
        {
            for(ObjectError errors: result.getAllErrors())
            {
                response.getErrors().add(errors.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(response);
        }
        response.setData(quarteirao);
        service.save(quarteirao);
        return ResponseEntity.ok(response);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> deletarQuarteirao(@PathVariable(value = "id") int id) {
        Optional<Quarteirao> obj = service.buscaId(id);
        Response<Optional<Quarteirao>> response = new Response<>();
        if(!obj.isPresent())
        {
            response.getErrors().add("quarteirao nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        service.delete(obj.get());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> editarQuarteirao(
            @PathVariable(value = "id") int id,
            @Valid @RequestBody QuarteiraoDTO quarteiraoDTO, BindingResult result){
        var quarteirao = new Quarteirao(quarteiraoDTO);
        Optional<Quarteirao> obj = service.buscaId(id);
        Response<Optional<Quarteirao>> response = new Response<>();
        if(!obj.isPresent())
        {
            response.getErrors().add("quarteirao nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        quarteirao.setId(obj.get().getId());
        response.setData(Optional.of(quarteirao));
        service.save(quarteirao);
        return ResponseEntity.ok(response);
    }
}
