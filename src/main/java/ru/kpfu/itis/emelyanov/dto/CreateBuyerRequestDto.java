package ru.kpfu.itis.emelyanov.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CreateBuyerRequestDto {

    @NotBlank(message = "First name shouldn't be blank")
    @Size(min = 2, max = 32, message = "First Name must be between 2 and 32 characters long")
    String fName;

    @NotBlank(message = "Second name shouldn't be blank")
    @Size(min = 2, max = 32, message = "Second Name must be between 2 and 32 characters long")
    String sName;

    @NotBlank(message = "Username shouldn't be blank")
    @Size(min = 2, max = 40, message = "Username must be between 2 and 40 characters long")
    String username;
    @NotBlank(message = "Email shouldn't be blank")
    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    @Size(min = 3, max = 64, message = "Email must be between 3 and 64 characters long")
    String email;

    @NotBlank(message = "Password can't be blank")
    @Size(min = 2, max = 24, message = "Password must be between 2 and 24 characters long")
    String password;
}
