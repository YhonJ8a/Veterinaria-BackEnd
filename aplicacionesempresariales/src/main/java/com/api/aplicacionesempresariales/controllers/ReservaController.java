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

import com.api.aplicacionesempresariales.services.ReservaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaDto> create(@RequestBody @Valid ReservaCreateDto dto) {
        return ResponseEntity.ok(reservaService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(reservaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReservaDto>> findAll() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaDto> update(@PathVariable UUID id, @RequestBody @Valid ReservaUpdateDto dto) {
        return ResponseEntity.ok(reservaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/confirmar")
    public ResponseEntity<Void> confirmar(@PathVariable UUID id) {
        reservaService.confirmar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<ReservaDto> cancelar(@PathVariable UUID id) {
        reservaService.cancelar(id);
        return ResponseEntity.noContent().build();
    }
}