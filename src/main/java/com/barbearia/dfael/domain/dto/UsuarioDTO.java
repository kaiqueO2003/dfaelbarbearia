package com.barbearia.dfael.domain.dto;

import com.barbearia.dfael.domain.Usuario;


    public class UsuarioDTO {
    private String id;
    private String name;
    private String email;



    public UsuarioDTO(){

    }

        public UsuarioDTO(Usuario obj) {
            id = obj.getId();
            name = obj.getName();
            email = obj.getEmail();
        }
        public Usuario toEntity() {
            Usuario usuario = new Usuario();
            usuario.setId(this.id); // Verifique se `this.id` não é nulo
            usuario.setName(this.name); // Verifique se `this.name` não é nulo
            usuario.setEmail(this.email); // Verifique se `this.email` não é nulo
            return usuario;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }



    }
