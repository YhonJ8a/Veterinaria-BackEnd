package com.api.aplicacionesempresariales.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.aplicacionesempresariales.dtos.*;

import com.api.aplicacionesempresariales.services.PerfilService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/perfiles")
@RequiredArgsConstructor
public class PerfilController {
    private final PerfilService perfilService;

    @PostMapping
    public ResponseEntity<PerfilDto> create(@RequestBody @Valid PerfilDto dto) {
        return ResponseEntity.ok(perfilService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(perfilService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PerfilDto>> findAll() {
        return ResponseEntity.ok(perfilService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilDto> update(@PathVariable UUID id, @RequestBody @Valid PerfilDto dto) {
        return ResponseEntity.ok(perfilService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        perfilService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
