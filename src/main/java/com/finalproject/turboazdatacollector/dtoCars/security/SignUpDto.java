package com.finalproject.turboazdatacollector.dtoCars.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class SignUpDto {
    @NotBlank(message = "/Zehmet olmasa email daxil edin.")
    private String email;
    @NotBlank(message = "/Zehmet olmasa password daxil edin.")
    private String password;

    private String role;


    public SignUpDto(String email, String password) {
        this.email = email;
        this.password = password;

    }

}
