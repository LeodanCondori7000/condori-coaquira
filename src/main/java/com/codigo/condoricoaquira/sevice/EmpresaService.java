package com.codigo.condoricoaquira.sevice;

import com.codigo.condoricoaquira.dto.EmpresaDTO;
import com.codigo.condoricoaquira.entity.EmpresaEntity;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    EmpresaEntity crear(EmpresaDTO empresaDTO);
    Optional<EmpresaEntity> buscarxId(Long id);
    List<EmpresaEntity> buscarAll();
    EmpresaEntity actualizar(Long id, EmpresaDTO empresaDTO);
    EmpresaEntity borrar(Long id);
}
