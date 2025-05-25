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

import com.api.aplicacionesempresariales.dtos.HorarioCreateDto;
import com.api.aplicacionesempresariales.dtos.HorarioDto;
import com.api.aplicacionesempresariales.services.HorarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/horarios")
@RequiredArgsConstructor
public class HorarioController {
    private final HorarioService horarioService;

    @PostMapping
    public ResponseEntity<HorarioDto> create(@RequestBody @Valid HorarioCreateDto dto) {
        return ResponseEntity.ok(horarioService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(horarioService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<HorarioDto>> findAll() {
        return ResponseEntity.ok(horarioService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioDto> update(@PathVariable UUID id, @RequestBody @Valid HorarioCreateDto dto) {
        return ResponseEntity.ok(horarioService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        horarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
