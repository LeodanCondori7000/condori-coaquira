package com.codigo.condoricoaquira.dao;

import com.codigo.condoricoaquira.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {
}
