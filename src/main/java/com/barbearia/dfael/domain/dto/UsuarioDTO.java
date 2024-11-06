package com.barbearia.dfael.domain.dto;

import com.barbearia.dfael.domain.Usuario;


    public class UsuarioDTO {
    private String id;
    private String name;
    private String telefone;
    private String email;



    public UsuarioDTO(){

    }

        public UsuarioDTO(Usuario obj) {
            id = obj.getId();
            name = obj.getName();
            email = obj.getEmail();
            telefone = obj.getTelefone();
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

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
    }
