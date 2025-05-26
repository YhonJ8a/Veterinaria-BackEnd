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

import com.api.aplicacionesempresariales.dtos.EstablecimientoCreateDto;
import com.api.aplicacionesempresariales.dtos.EstablecimientoDto;
import com.api.aplicacionesempresariales.dtos.ServicioPorEstablecimientoCreateDto;
import com.api.aplicacionesempresariales.dtos.ServicioPorEstablecimientoDto;
import com.api.aplicacionesempresariales.services.EstablecimientoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/establecimientos")
@RequiredArgsConstructor
public class EstablecimientoController {
    private final EstablecimientoService establecimientoService;

    @PostMapping
    public ResponseEntity<EstablecimientoDto> create(@RequestBody @Valid EstablecimientoCreateDto dto) {
        return ResponseEntity.ok(establecimientoService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstablecimientoDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(establecimientoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<EstablecimientoDto>> findAll() {
        return ResponseEntity.ok(establecimientoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstablecimientoDto> update(@PathVariable UUID id,
            @RequestBody @Valid EstablecimientoCreateDto dto) {
        return ResponseEntity.ok(establecimientoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        establecimientoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/servicios")
    public ResponseEntity<List<ServicioPorEstablecimientoDto>> getServiciosById(@PathVariable UUID id) {
        return ResponseEntity.ok(establecimientoService.findServiciosById(id));
    }

    @PostMapping("/{id}/servicios")
    public ResponseEntity<ServicioPorEstablecimientoDto> createServiceXEstablecimiento(@PathVariable UUID id,
            @RequestBody @Valid ServicioPorEstablecimientoCreateDto dto) {
        return ResponseEntity.ok(establecimientoService.createService(id, dto));
    }
}
