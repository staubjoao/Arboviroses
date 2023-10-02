package br.com.api.services;

import br.com.api.model.Localidade;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface LocalidadeService {

    public Localidade save(Localidade localidade);
    public List<Localidade> getAll();
    public Localidade getById(Integer id);
    public void delete(Localidade localidade);
}