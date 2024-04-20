package com.codigo.condoricoaquira.sevice.impl;

import com.codigo.condoricoaquira.constants.Constants;
import com.codigo.condoricoaquira.dao.EmpresaRepository;
import com.codigo.condoricoaquira.dto.EmpresaDTO;
import com.codigo.condoricoaquira.entity.EmpresaEntity;
import com.codigo.condoricoaquira.sevice.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    @Override
    public EmpresaEntity crear(EmpresaDTO empresaDTO) {
        EmpresaEntity empresaEntity = new EmpresaEntity();

        empresaEntity.setRazonSocial(empresaDTO.getRazonSocial());
        empresaEntity.setTipoDocumento(empresaDTO.getTipoDocumento());
        empresaEntity.setNumeroDocumento(empresaDTO.getNumeroDocumento());
        empresaEntity.setCondicion(empresaDTO.getCondicion());
        empresaEntity.setDireccion(empresaDTO.getDireccion());
        empresaEntity.setDistrito(empresaDTO.getDistrito());
        empresaEntity.setProvincia(empresaDTO.getProvincia());
        empresaEntity.setDepartamento(empresaDTO.getDepartamento());
        empresaEntity.setEsAgenteRetencion(empresaDTO.getEsAgenteRetencion());
        empresaEntity.setEstado(Constants.STATUS_ACTIVE);
        empresaEntity.setUsuaCrea(Constants.USU_ADMIN);
        empresaEntity.setDateCreate(getTimestamp());

        return empresaRepository.save(empresaEntity);
    }

    @Override
    public Optional<EmpresaEntity> buscarxId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<EmpresaEntity> buscarAll() {
        return empresaRepository.findAll();
    }

    @Override
    public EmpresaEntity actualizar(Long id, EmpresaDTO empresaDTO) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);

        if(empresaRecuperada.isPresent()){
            EmpresaEntity empresaEntity = empresaRecuperada.get();
            empresaEntity.setRazonSocial(empresaDTO.getRazonSocial());
            empresaEntity.setTipoDocumento(empresaDTO.getTipoDocumento());
            empresaEntity.setNumeroDocumento(empresaDTO.getNumeroDocumento());
            empresaEntity.setCondicion(empresaDTO.getCondicion());
            empresaEntity.setDireccion(empresaDTO.getDireccion());
            empresaEntity.setDistrito(empresaDTO.getDistrito());
            empresaEntity.setProvincia(empresaDTO.getProvincia());
            empresaEntity.setDepartamento(empresaDTO.getDepartamento());
            empresaEntity.setEsAgenteRetencion(empresaDTO.getEsAgenteRetencion());

            empresaEntity.setUsuaModif(Constants.USU_ADMIN);
            empresaEntity.setDateModif(getTimestamp());

            return empresaRepository.save(empresaEntity);
        }
        return null;
    }

    @Override
    public EmpresaEntity borrar(Long id) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
            empresaRecuperada.get().setEstado(0);
            empresaRecuperada.get().setUsuaDelet(Constants.USU_ADMIN);
            empresaRecuperada.get().setDateDelet(getTimestamp());
            return empresaRepository.save(empresaRecuperada.get());
        }
        return null;
    }
    private Timestamp getTimestamp(){
        long currenTIme = System.currentTimeMillis();
        return new Timestamp(currenTIme);
    }
}
