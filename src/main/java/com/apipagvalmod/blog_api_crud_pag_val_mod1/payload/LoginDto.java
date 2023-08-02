package com.apipagvalmod.blog_api_crud_pag_val_mod1.payload;

import lombok.Data;

@Data
public class LoginDto {
    private String  usernameOrEmail;
    private String password;
}
