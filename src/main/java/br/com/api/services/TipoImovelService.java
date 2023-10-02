package br.com.api.services;

import br.com.api.model.TipoImovel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TipoImovelService {

    public TipoImovel save(TipoImovel tipoImovel);

    public List<TipoImovel> getAll();

    public TipoImovel getById(Integer id);

    public void delete(TipoImovel tipoImovel);

    public TipoImovel put(TipoImovel tipoImovel);
}
