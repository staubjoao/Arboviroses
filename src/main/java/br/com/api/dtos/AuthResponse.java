package br.com.api.dtos;

import lombok.Data;

@Data
public class AuthResponse {
	private String login;
	private String roles;
	private String accessToken;
	
	public AuthResponse(String login, String accessToken, String roles) {
		super();
		this.login = login;
		this.accessToken = accessToken;
		this.roles = roles;
	}

	public AuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
