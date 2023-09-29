package br.com.api.services;

import br.com.api.model.LocalidadeModel;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface LocalidadeService {

    public LocalidadeModel save(LocalidadeModel localidade);
    public List<LocalidadeModel> getAll();
    public LocalidadeModel getById(Integer id);
    public void delete(LocalidadeModel localidade);
}