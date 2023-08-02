package com.apipagvalmod.blog_api_crud_pag_val_mod1.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Data
public class PostDTO {
    private long id;
@NotEmpty(message=" title should not be null")
@Size(min=2,message="at least 2 char")
    private String title;
    @NotEmpty(message="content should not be null")
    @Size(min=2,message="at least 2 char")

    private String content;
    @NotEmpty(message="description should not be null")
    @Size(min=2,message="at least 2 char")

    private String description;
}
