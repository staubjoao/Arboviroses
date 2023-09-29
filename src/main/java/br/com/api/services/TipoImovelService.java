package br.com.api.services;

import br.com.api.model.TipoImovelModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public interface TipoImovelService {

    public TipoImovelModel save(TipoImovelModel tipoImovelModel);

    public List<TipoImovelModel> getAll();

    public TipoImovelModel getById(Integer id);

    public void delete(TipoImovelModel tipoImovelModel);

    public TipoImovelModel put(TipoImovelModel tipoImovelModel);
}
