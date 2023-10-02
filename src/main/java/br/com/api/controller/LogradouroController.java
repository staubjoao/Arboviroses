package br.com.api.controller;

import br.com.api.dtos.LogradouroDTO;
import br.com.api.model.Logradouro;
import br.com.api.services.LogradouroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/logradouro")
public class LogradouroController {

    @Autowired
    private LogradouroService logradouroService;

    @GetMapping("/todos")
    public ResponseEntity<List<Logradouro>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(logradouroService.getAll());
    }

    @PostMapping("/novo")
    public ResponseEntity<Object> iserirLogradouro(@RequestBody @Valid LogradouroDTO logradouroDTO){
        var logradouroModel = new Logradouro(logradouroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(logradouroService.save(logradouroModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listaUmLogradouro(@PathVariable(value = "id") int id) {
        Optional<Logradouro> logradouroModelOptional = logradouroService.buscaId(id);
        if(!logradouroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Logradouro não encontrado na base de dados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(logradouroModelOptional);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletarLogradouro(@PathVariable(value = "id") int id){
        Optional<Logradouro> logradouroModelOptional = logradouroService.buscaId(id);
        if(!logradouroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Logradouro não encontrado na base de dados");
        }
        logradouroService.delete(logradouroModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Logradouro deletado com sucesso!!");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Object> editarBairro(@PathVariable(value = "id") int id,
                                               @RequestBody @Valid LogradouroDTO logradouroDTO){
        Optional<Logradouro> logradouroModelOptional = logradouroService.buscaId(id);
        if(!logradouroModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Logradouro não encontrado na base de dados");
        }
        var logradouroModel = new Logradouro();
        BeanUtils.copyProperties(logradouroDTO, logradouroModel);
        logradouroModel.setId(logradouroModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(logradouroService.save(logradouroModel));
    }
}
