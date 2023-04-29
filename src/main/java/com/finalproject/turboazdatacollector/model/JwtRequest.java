package com.finalproject.turboazdatacollector.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	@NotBlank(message = "Zehmet olmasa emaili hissesino bos qoymayin.")
	@Email(message = "emaili duzgun daxil edin")
	private String email;
	@NotBlank(message = "Zehmet olmasa password duzgun daxil edin.")
	@Size(min = 8, max = 20 ,message = "password length can be minimum 8 and maximum 20")
	private String password;
	@NotBlank(message = "Zehmet olmasa role hissesini bos qoymayin.")
	@Size(min = 4, max = 20 ,message = "role length can be minimum 8 and maximum 20")
	private String role;

	//need default constructor for JSON Parsing
	public JwtRequest()
	{
		
	}

	public JwtRequest(String email, String password) {
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}