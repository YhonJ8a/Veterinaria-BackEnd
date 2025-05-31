package com.api.aplicacionesempresariales.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.aplicacionesempresariales.dtos.CalificacionCreateDto;
import com.api.aplicacionesempresariales.dtos.CalificacionDto;
import com.api.aplicacionesempresariales.services.CalificacionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calificaciones")
public class CalificacionController {
    private final CalificacionService calificacionService;

    @PostMapping
    public ResponseEntity<CalificacionDto> create(@RequestBody @Valid CalificacionCreateDto dto) {
        return ResponseEntity.ok(calificacionService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalificacionDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(calificacionService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CalificacionDto>> findAll() {
        return ResponseEntity.ok(calificacionService.findAll());
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<CalificacionDto> update(@PathVariable UUID id,
    // @RequestBody @Valid CalificacionCreateDto dto) {
    // return ResponseEntity.ok(calificacionService.update(id, dto));
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        calificacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
