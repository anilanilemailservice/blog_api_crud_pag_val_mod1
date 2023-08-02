package com.apipagvalmod.blog_api_crud_pag_val_mod1.repository;

import com.apipagvalmod.blog_api_crud_pag_val_mod1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name );

}
