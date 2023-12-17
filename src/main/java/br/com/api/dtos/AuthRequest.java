package br.com.api.dtos;
import lombok.Data;
// import java.lang.invoke.StringConcatFactory;

@Data
public class AuthRequest {	
	private String login;
	private String password;	
}
