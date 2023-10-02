package br.com.api.responses;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Response<T> {

    private T data;
    private List<String> errors;

    public List<String> getErrors() {
        if(this.errors == null) {
            this.errors = new ArrayList<String>();
        }
        return errors;
    }
}
