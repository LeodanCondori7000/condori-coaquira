package com.codigo.condoricoaquira.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Entity
@Table(name = "empresa")
@Getter
@Setter
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "razon_social", length = 255)
    private String razonSocial;

    @Column(name = "tipo_documento", length = 10)
    private String tipoDocumento;

    @Column(name = "numero_documento", length = 11)
    private String numeroDocumento;

    @Column(name = "condicion", length = 10)
    private String condicion;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "distrito", length = 255)
    private String distrito;

    @Column(name = "provincia", length = 255)
    private String provincia;

    @Column(name = "departamento", length = 255)
    private String departamento;

    @Column(name = "es_agente_retencion")
    private Boolean esAgenteRetencion;

    @Column(name = "estado")
    private Integer estado;

    @Column(name = "usua_crea", length = 50)
    private String usuaCrea;

    @Column(name = "date_create", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Timestamp dateCreate;

    @Column(name = "usua_modif", length = 50)
    private String usuaModif;

    @Column(name = "date_modif", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Timestamp dateModif;

    @Column(name = "usua_delet", length = 50)
    private String usuaDelet;

    @Column(name = "date_delet", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Timestamp dateDelet;
}
