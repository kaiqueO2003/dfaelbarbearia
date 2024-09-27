package com.barbearia.dfael.controller;

import com.barbearia.dfael.domain.AuthenticationDTO;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
   private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
          var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
          var auth = this.authenticationManager.authenticate(usernamePassword);

          return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity 
}
