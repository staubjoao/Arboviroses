package br.com.api.service.impl;

import br.com.api.model.Larvicida;
import br.com.api.repository.LarvicidaRepository;
import br.com.api.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import br.com.api.service.LarvicidaService;

import jakarta.validation.Valid;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class LarvicidaServiceImpl implements LarvicidaService {

    @Autowired
    private LarvicidaRepository repository;

    @Override
    public ResponseEntity<Response<Larvicida>> salvar(@Valid Larvicida larvicida, BindingResult result) {
//        Response<Larvicida> response = new Response<>();
//        response.setData(larvicida);
//
//        if (result.hasErrors()) {
//            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
//            return ResponseEntity.badRequest().body(response);
//        }
//
//        if ("focal".equalsIgnoreCase(larvicida.getTipo())) {
//            // Configurar campos para tratamento focal
//            larvicida.setQtdDepositosEliminados(0);
//        } else if ("perifocal".equalsIgnoreCase(larvicida.getTipo())) {
//            // Configurar campos para tratamento perifocal (adulticida)
//            larvicida.setQuantidade(0);
//            larvicida.setQtdDepositosTratados(0);
//        } else {
//            // Tipo inválido
//            response.getErrors().add("Tipo de tratamento inválido.");
//            return ResponseEntity.badRequest().body(response);
//        }
//
//        repository.save(larvicida);
//        return ResponseEntity.ok(response);

        Response<Larvicida> response = new Response<Larvicida>();
        response.setData(larvicida);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(larvicida);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Larvicida> getAll() {
        return repository.findAll();
    }

        @Override
        public ResponseEntity<Response<Larvicida>> getById(Long id) {
            Response<Larvicida> response = new Response<>();
            repository.findById(id).ifPresent(
                obj -> response.setData(obj)
            );
            repository.findById(id).orElseGet(
                () -> {
                    response.getErrors().add("Larvicida não encontrado.");
                    return null;
                }
            );

            return ResponseEntity.ok(response);
        }

    @Override
    public ResponseEntity<Response<Larvicida>> deleteById(Long id) {
        Response<Larvicida> response = new Response<>();
        repository.findById(id).ifPresent(
                obj -> {
                    repository.delete(obj);
                    response.setData(obj);
                }
        );

        return ResponseEntity.ok(response);
    }
}
