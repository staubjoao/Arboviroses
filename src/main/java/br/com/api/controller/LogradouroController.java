package br.com.api.controller;

import br.com.api.dtos.LogradouroDTO;
import br.com.api.model.Logradouro;
import br.com.api.responses.Response;
import br.com.api.serviceimpl.LogradouroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/logradouro")
public class LogradouroController {

    @Autowired
    private LogradouroServiceImpl service;

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Logradouro>> listarTodos(){
        List<Logradouro> logradouro = service.getAll();
        return ResponseEntity.ok(logradouro);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> listaUmLogradouro(@PathVariable(value = "id") int id) {
        Optional<Logradouro> obj = service.buscaId(id);
        Response<Optional<Logradouro>> response = new Response<>();
        if(!obj.isPresent())
        {
            response.getErrors().add("logradouro nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/novo")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Response<Logradouro>> iserirLogradouro(
            @Valid @RequestBody LogradouroDTO logradouroDTO, BindingResult result){
        var logradouro = new Logradouro(logradouroDTO);
        Response<Logradouro> response = new Response<Logradouro>();
        if(result.hasErrors())
        {
            for(ObjectError errors: result.getAllErrors())
            {
                response.getErrors().add(errors.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(response);
        }
        response.setData(logradouro);
        service.save(logradouro);
        return ResponseEntity.ok(response);
    }



    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> deletaLogradouro(@PathVariable(value = "id") int id) {
        Optional<Logradouro> obj = service.buscaId(id);
        Response<Optional<Logradouro>> response = new Response<>();
        if(!obj.isPresent())
        {
            response.getErrors().add("logradouro nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(obj);
        service.delete(obj.get());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> editarLogradouro(
            @PathVariable(value = "id") int id,
            @Valid @RequestBody LogradouroDTO logradouroDTO, BindingResult result){
        var logradouro = new Logradouro(logradouroDTO);
        Optional<Logradouro> obj = service.buscaId(id);
        Response<Optional<Logradouro>> response = new Response<>();
        if(!obj.isPresent())
        {
            response.getErrors().add("logradouro nao encontrado");
            return ResponseEntity.badRequest().body(response);
        }
        logradouro.setId(obj.get().getId());
        response.setData(Optional.of(logradouro));
        service.save(logradouro);
        return ResponseEntity.ok(response);
    }
}
