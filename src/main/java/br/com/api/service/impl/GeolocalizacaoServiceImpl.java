package br.com.api.service.impl;

import br.com.api.model.Geolocalizacao;
import br.com.api.repository.GeolocalizacaoRepository;
import br.com.api.responses.Response;
import br.com.api.service.GeolocalizacaoService;
import jakarta.validation.Valid;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.io.IOException;
import java.util.List;

@Component
public class GeolocalizacaoServiceImpl implements GeolocalizacaoService {

    @Autowired
    private GeolocalizacaoRepository repository;

    private final OkHttpClient httpClient = new OkHttpClient();

    @Override
    public JSONObject searchGeo(String query) throws IOException {
        Request request = new Request.Builder()
                .url("https://nominatim.openstreetmap.org/search?format=json&q=" + query)
                .build();

        try (okhttp3.Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            JSONArray jsonArray = new JSONArray(response.body().string());

            if(jsonArray.length() > 0) {
                return jsonArray.getJSONObject(0);
            }

            return null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
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
