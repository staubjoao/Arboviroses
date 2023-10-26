package br.com.api.service.impl;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.api.model.Geolocalizacao;
import br.com.api.model.Imovel;
import br.com.api.repository.ImovelRepository;
import br.com.api.responses.Response;
import br.com.api.service.ImovelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.io.IOException;
import java.util.List;

@Component
public class ImovelServiceImpl implements ImovelService {

    @Autowired
    private ImovelRepository repository;

    @Autowired
    private GeolocalizacaoServiceImpl serviceGeolocalizacao;


    @Override
    public ResponseEntity<Response<Imovel>> salvar(@Valid Imovel imovel, BindingResult result) {
        Response<Imovel> response = new Response<Imovel>();

        String query = "" +
                imovel.getLogradouro().getLogradouro().replace(" ", "+") +
                "+" +
                imovel.getLocalidade().replace(" ", "+") +
                "+" +
                imovel.getNumero() +
                "+" +
                imovel.getBairro().getCidade().getCidade().replace(" ", "+") +
                "+" +
                "Paraná";

        Geolocalizacao geolocalizacao = new Geolocalizacao();

        JSONObject retorno;
        try {
            retorno = serviceGeolocalizacao.searchGeo(query);
        } catch (IOException e) {
            response.getErrors().add("Falha ao buscar a geolocalização");
            throw new RuntimeException(e);
        }

        try {
            geolocalizacao.setLongitude(retorno.getString("lon"));
            geolocalizacao.setLatitude(retorno.getString("lat"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        imovel.setGeolocalizacao(geolocalizacao);

        response.setData(imovel);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(imovel);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<Imovel> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<Imovel>> getById(Integer id) {
        Response<Imovel> response = new Response<Imovel>();
        Imovel obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Imóvel inválido");
        } catch (Exception ex) {
            response.getErrors().add("Imóvel inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<Imovel>> deleteById(Integer id) {
        Response<Imovel> response = new Response<Imovel>();
        Imovel obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Imóvel inválido");
        } catch (Exception ex) {
            response.getErrors().add("Imóvel inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

}
