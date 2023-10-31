package br.com.api.responses;


import java.util.ArrayList;
import java.util.List;

import br.com.api.model.RotasAgentes;
import lombok.Data;

@Data
public class Response<T> {
    
    private T data;
    private List<String> errors;

    public List<String> getErrors()
    {
        if(this.errors == null)
        {
            this.errors = new ArrayList<String>();
        }

        return this.errors;
    }
}
