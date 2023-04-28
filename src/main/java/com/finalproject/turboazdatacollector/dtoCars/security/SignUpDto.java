package com.finalproject.turboazdatacollector.dtoCars.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class SignUpDto {
    @NotBlank(message = "/Zehmet olmasa emaili duzgun daxil edin.")
    @Email(message = "emaili duzgun daxil edin")
    private String email;
    @NotBlank(message = "/Zehmet olmasa passwordu duzgun daxil edin.")
//    @Size(min = )
    private String password;

    private String role;


    public SignUpDto(String email, String password) {
        this.email = email;
        this.password = password;

    }

}
