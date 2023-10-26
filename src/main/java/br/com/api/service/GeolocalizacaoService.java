package br.com.api.service;

import br.com.api.model.Geolocalizacao;
import br.com.api.responses.Response;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@Service
public interface GeolocalizacaoService {

    JSONObject searchGeo(String query) throws IOException;
    ResponseEntity<Response<Geolocalizacao>> salvar(@Valid @RequestBody Geolocalizacao geolocalizacao, BindingResult result);

    List<Geolocalizacao> getlAll();

    ResponseEntity<Response<Geolocalizacao>> getById(Integer id);

    ResponseEntity<Response<Geolocalizacao>> deleteById(Integer id);

}
