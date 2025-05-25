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

import com.api.aplicacionesempresariales.dtos.ServicioCreateDto;
import com.api.aplicacionesempresariales.dtos.ServicioDto;
import com.api.aplicacionesempresariales.services.ServicioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
public class ServicioController {
    private final ServicioService servicioService;

    @PostMapping
    public ResponseEntity<ServicioDto> create(@RequestBody @Valid ServicioCreateDto dto) {
        return ResponseEntity.ok(servicioService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(servicioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ServicioDto>> findAll() {
        return ResponseEntity.ok(servicioService.findAll());
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<ServicioDto> update(@PathVariable UUID id, @RequestBody
    // @Valid ServicioCreateDto dto) {
    // return ResponseEntity.ok(servicioService.update(id, dto));
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        servicioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
