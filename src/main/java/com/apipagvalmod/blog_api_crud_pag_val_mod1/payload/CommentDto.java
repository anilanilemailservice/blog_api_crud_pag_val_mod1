package com.apipagvalmod.blog_api_crud_pag_val_mod1.payload;

import lombok.Data;

@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;

}
