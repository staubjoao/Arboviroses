package br.com.api.services;

import br.com.api.model.Logradouro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LogradouroService {
    public Logradouro save(Logradouro logradouro);
    public List<Logradouro> getAll();
    public Logradouro getById(int id);
    public void delete(Logradouro logradouro);
}
