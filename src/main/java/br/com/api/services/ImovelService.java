package br.com.api.services;

import br.com.api.model.Imovel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImovelService {

    public Imovel save(Imovel imovel);

    public List<Imovel> getAll();

    public Imovel getById(Integer id);

    public void delete(Imovel imovel);

}
