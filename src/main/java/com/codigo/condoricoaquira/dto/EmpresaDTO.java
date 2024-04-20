package com.codigo.condoricoaquira.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDTO {
    private Long idEmpresa;
    private String razonSocial;
    private String tipoDocumento;
    private String numeroDocumento;
    private String condicion;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    private Boolean esAgenteRetencion;
}
