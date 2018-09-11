package ir.sargoll.shop.security;

import ir.sargoll.shop.model.UserGender;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 4, max = 40)
    private String family;

    @NotBlank
    @Size(min = 10, max = 15)
    private String mobile;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    @NotBlank
    private String gender;

}