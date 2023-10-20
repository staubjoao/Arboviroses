package br.com.api.utils;
import org.springframework.beans.factory.annotation.Value;

public class PropertiesConfigUtils {
    
    @Value("${spring.datasource.url}")
    private String urlDB;

    public String getUrlDB() {
        return urlDB;
    }
}
