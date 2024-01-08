package br.com.api.service.impl;

import br.com.api.model.Imovel;
import br.com.api.model.ImovelSequencia;
import br.com.api.repository.ImovelSequenciaRepository;
import br.com.api.responses.Response;
import br.com.api.service.ImovelSequenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class ImovelSequenciaServiceImpl implements ImovelSequenciaService {

    @Autowired
    private ImovelSequenciaRepository repository;

    @Override
    public ResponseEntity<Response<ImovelSequencia>> salvar(ImovelSequencia imovelSequencia, BindingResult result) {
        Response<ImovelSequencia> response = new Response<ImovelSequencia>();
        response.setData(imovelSequencia);
        if (result.hasErrors()) {
            for (ObjectError erros : result.getAllErrors()) {
                response.getErrors().add(erros.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(response);
        }
        repository.save(imovelSequencia);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<ImovelSequencia> getlAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Response<ImovelSequencia>> getById(Integer id) {
        Response<ImovelSequencia> response = new Response<ImovelSequencia>();
        ImovelSequencia obj = null;
        try {
            obj = repository.findById(id).get();
        } catch (NullPointerException ex) {
            response.getErrors().add("Imóvel sequencia inválido");
        } catch (Exception ex) {
            response.getErrors().add("Imóvel sequencia inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response<ImovelSequencia>> deleteById(Integer id) {
        Response<ImovelSequencia> response = new Response<ImovelSequencia>();
        ImovelSequencia obj = null;
        try {
            obj = repository.findById(id).get();
            repository.delete(obj);
        } catch (NullPointerException ex) {
            response.getErrors().add("Imóvel sequencia inválido");
        } catch (Exception ex) {
            response.getErrors().add("Imóvel sequencia inválido");
        }
        response.setData(obj);
        return ResponseEntity.ok(response);
    }

    @Override
    public List<ImovelSequencia> getByImovel(Imovel imovel) {
        return repository.findByImovel(imovel);
    }
}
