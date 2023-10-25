package br.com.api.service.impl;

import br.com.api.model.Geolocalizacao;
import br.com.api.repository.GeolocalizacaoRepository;
import br.com.api.responses.Response;
import br.com.api.service.GeolocalizacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class GeolocalizacaoServiceImpl implements GeolocalizacaoService {

    @Autowired
    private GeolocalizacaoRepository repository;

    @Override
    public ResponseEntity<Response<Geolocalizacao>> salvar(@Valid Geolocalizacao geolocalizacao, BindingResult result) {
        Response<Geolocalizacao> response = new Response<Geolocalizacao>();
        response.setData(geolocalizacao);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(geolocalizacao);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Geolocalizacao> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Geolocalizacao>> getById(Integer id) {
        Response<Geolocalizacao> response = new Response<Geolocalizacao>();
        Geolocalizacao obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Geolocalização inválida");
        } catch (Exception ex) {
            response.getErrors().add("Geolocalização inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Geolocalizacao>> deleteById(Integer id) {
        Response<Geolocalizacao> response = new Response<Geolocalizacao>();
        Geolocalizacao obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Geolocalização inválida");
        } catch (Exception ex) {
            response.getErrors().add("Geolocalização inválida");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

}
