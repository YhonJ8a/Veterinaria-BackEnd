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

import com.api.aplicacionesempresariales.dtos.MascotaCreateDto;
import com.api.aplicacionesempresariales.dtos.MascotaDto;
import com.api.aplicacionesempresariales.dtos.MascotaUpdateDto;
import com.api.aplicacionesempresariales.services.MascotaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {
    private final MascotaService mascotaService;

    @PostMapping
    public ResponseEntity<MascotaDto> create(@RequestBody @Valid MascotaCreateDto dto) {
        return ResponseEntity.ok(mascotaService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MascotaDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(mascotaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<MascotaDto>> findAll() {
        return ResponseEntity.ok(mascotaService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MascotaDto> update(@PathVariable UUID id, @RequestBody MascotaUpdateDto dto) {
        return ResponseEntity.ok(mascotaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        mascotaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/responsable/{responsableId}")
    public ResponseEntity<List<MascotaDto>> findByResponsable(@PathVariable UUID responsableId) {
        return ResponseEntity.ok(mascotaService.buscarPorResponsable(responsableId));
    }
}
