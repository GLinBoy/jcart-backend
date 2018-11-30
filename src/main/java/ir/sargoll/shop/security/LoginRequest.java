package ir.sargoll.shop.security;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private String emailOrMobile;

    @NotBlank
    private String password;
    
    private Boolean rememberMe = false;
}