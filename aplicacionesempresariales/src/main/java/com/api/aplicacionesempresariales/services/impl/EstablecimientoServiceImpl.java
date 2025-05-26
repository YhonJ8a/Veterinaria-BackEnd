package com.api.aplicacionesempresariales.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.aplicacionesempresariales.dtos.EstablecimientoCreateDto;
import com.api.aplicacionesempresariales.dtos.EstablecimientoDto;
import com.api.aplicacionesempresariales.dtos.ServicioPorEstablecimientoCreateDto;
import com.api.aplicacionesempresariales.dtos.ServicioPorEstablecimientoDto;
import com.api.aplicacionesempresariales.mappers.EstablecimientoMapper;
import com.api.aplicacionesempresariales.models.Establecimiento;
import com.api.aplicacionesempresariales.models.Servicio;
import com.api.aplicacionesempresariales.models.ServicioPorEstablecimiento;
import com.api.aplicacionesempresariales.repositories.EstablecimientoRepository;
import com.api.aplicacionesempresariales.repositories.ServicioPorEstablecimientoRepository;
import com.api.aplicacionesempresariales.repositories.ServicioRepository;
import com.api.aplicacionesempresariales.services.EstablecimientoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class EstablecimientoServiceImpl implements EstablecimientoService {
    private final EstablecimientoRepository repo;
    private final ServicioRepository repoSer;
    private final ServicioPorEstablecimientoRepository repoServices;
    private final EstablecimientoMapper mapper;

    public EstablecimientoDto create(EstablecimientoCreateDto dto) {
        return mapper.toDto(repo.save(mapper.toEntity(dto)));
    }

    public EstablecimientoDto update(UUID id, EstablecimientoCreateDto dto) {
        Establecimiento e = repo.findById(id).orElseThrow();
        e.setNombre(dto.getNombre());
        e.setDireccion(dto.getDireccion());
        e.setDepartamento(dto.getDepartamento());
        e.setStartTime(dto.getStartTime());
        e.setEndTime(dto.getEndTime());
        return mapper.toDto(repo.save(e));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

    public EstablecimientoDto findById(UUID id) {
        return mapper.toDto(repo.findById(id).orElseThrow());
    }

    public List<EstablecimientoDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public List<ServicioPorEstablecimientoDto> findServiciosById(UUID id) {
        return mapper.toSxEDtos(repoServices.findByEstablecimientoId(id));
    }

    public ServicioPorEstablecimientoDto createService(UUID id, ServicioPorEstablecimientoCreateDto dto) {
        ServicioPorEstablecimiento relacion = mapper.toEntityService(dto);
        System.out.println("### dto ###: " + dto);
        System.out.println("getServicioId: " + dto.getServicioId());
        relacion.setEstablecimiento(repo.findById(id).orElseThrow());
        relacion.setServicio(repoSer.findById(dto.getServicioId()).orElseThrow());
        System.out.println("Relacion: " + relacion);
        return mapper.toSxEDto(repoServices.save(relacion));
    }
}