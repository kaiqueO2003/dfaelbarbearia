package com.barbearia.dfael.controller;

import com.barbearia.dfael.domain.dto.AuthenticationDTO;
import com.barbearia.dfael.domain.dto.CadastroDTO;
import com.barbearia.dfael.domain.dto.LoginResponseDTO;
import com.barbearia.dfael.domain.Usuario;
import com.barbearia.dfael.infra.security.TokenService;
import com.barbearia.dfael.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
   private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
          var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
          var auth = this.authenticationManager.authenticate(usernamePassword);

          var token = tokenService.generateToken((Usuario) auth.getPrincipal());


          return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/cadastro")
    public ResponseEntity <Usuario> cadastro(@RequestBody @Valid CadastroDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String enccryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario novoUsuario = new Usuario(data.name(), data.email(), enccryptedPassword, data.role());

        this.repository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }
}
