package br.com.api.services;

import br.com.api.model.Quarteirao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuarteiraoService {
    public Quarteirao save(Quarteirao quarteirao);
    public List<Quarteirao> getAll();
    public Quarteirao getById(int id);
    public void delete(Quarteirao quarteirao);
}
