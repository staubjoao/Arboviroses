package br.com.api.service.impl;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.api.model.Imovel;
import br.com.api.model.Quarteirao;
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

    private final OkHttpClient httpClient = new OkHttpClient();

    @Override
    public ResponseEntity<Response<Imovel>> salvar(@Valid Imovel imovel, BindingResult result) {
        Response<Imovel> response = new Response<Imovel>();

        String query = getString(imovel);

        System.out.println(query);

        JSONObject retorno;
        try {
            retorno = this.searchGeo(query);
        } catch (IOException e) {
            response.getErrors().add("Falha ao buscar a geolocalização");
            throw new RuntimeException(e);
        }

        System.out.println(retorno);

        if (retorno != null) {
            try {
                imovel.setLongitude(retorno.getString("lon"));
                imovel.setLatitude(retorno.getString("lat"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }else {
            imovel.setLongitude("Erro");
            imovel.setLatitude("Erro");
        }

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

    @NotNull
    public JSONObject searchGeo(String query) throws IOException {
        Request request = new Request.Builder()
                .url("https://nominatim.openstreetmap.org/search?format=json&q=" + query)
                .build();

        try (okhttp3.Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            JSONArray jsonArray = new JSONArray(response.body().string());


            if (jsonArray.length() > 0) {
                return jsonArray.getJSONObject(0);
            }

            return null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    private static String getString(Imovel imovel) {
        String logradouro = imovel.getLogradouro().getLogradouro();
        String numero = imovel.getNumero();
        String bairro = imovel.getBairro().getNome();
        String cidade = imovel.getBairro().getMunicipio().getMunicipio();

        return logradouro.replace(" ", "+") +
                "+" +
                numero +
                "+" +
                bairro.replace(" ", "+") +
                "+" +
                cidade.replace(" ", "+") +
                "+" +
                "Paraná";
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

    @Override
    public List<Imovel> getByQuateirao(Quarteirao quarteirao) {
        return repository.findByQuarteirao(quarteirao);
    }
}
