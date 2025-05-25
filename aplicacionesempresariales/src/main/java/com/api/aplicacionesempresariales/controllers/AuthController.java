package com.api.aplicacionesempresariales.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.aplicacionesempresariales.dtos.JwtResponseDto;
import com.api.aplicacionesempresariales.dtos.LoginRequestDto;
import com.api.aplicacionesempresariales.dtos.UsuarioCreateDto;
import com.api.aplicacionesempresariales.dtos.UsuarioDto;
import com.api.aplicacionesempresariales.services.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody @Valid LoginRequestDto dto) {
        System.out.println("Login request: " + dto);
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioDto> register(@RequestBody @Valid UsuarioCreateDto dto) {
        return ResponseEntity.ok(authService.register(dto));
    }

    // @PostMapping("/refresh-token")
    // public ResponseEntity<JwtResponseDto> refreshToken(@RequestBody
    // TokenRefreshRequestDto dto) {
    // return ResponseEntity.ok(authService.refreshToken(dto));
    // }
}