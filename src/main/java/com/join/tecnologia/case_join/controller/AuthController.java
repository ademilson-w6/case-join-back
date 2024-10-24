package com.join.tecnologia.case_join.controller;

import com.join.tecnologia.case_join.dto.LoginRequestDTO;
import com.join.tecnologia.case_join.dto.RegisterRequestDTO;
import com.join.tecnologia.case_join.dto.ResponseDTO;
import com.join.tecnologia.case_join.model.Usuario;
import com.join.tecnologia.case_join.repository.UsuarioRepository;
import com.join.tecnologia.case_join.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Tag(name = "Auth")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @Operation(summary = "Login do usuário", description = "Realiza o login do usuário e retorna um token.")
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body){
        Usuario usuario = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.senha(), usuario.getPassword())) {
            String token = this.tokenService.generateToken(usuario);
            return ResponseEntity.ok(new ResponseDTO(usuario.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Registro do usuário", description = "Registra um novo usuário e retorna um token.")
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body){
        Optional<Usuario> usuario = this.repository.findByEmail(body.email());

        if(usuario.isEmpty()) {
            Usuario novoUsuario = new Usuario();
            novoUsuario.setPassword(passwordEncoder.encode(body.senha()));
            novoUsuario.setEmail(body.email());
            novoUsuario.setName(body.nome());
            this.repository.save(novoUsuario);

            String token = this.tokenService.generateToken(novoUsuario);
            return ResponseEntity.ok(new ResponseDTO(novoUsuario.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

}