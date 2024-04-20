package com.codigo.condoricoaquira.controller;

import com.codigo.condoricoaquira.dto.EmpresaDTO;
import com.codigo.condoricoaquira.entity.EmpresaEntity;
import com.codigo.condoricoaquira.sevice.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "API DE REGISTRO DE EMPRESAS", description = "Esta api contiene todos los endpoints para realizar el registro, actualizacion y monitoreo de empresas"
)
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(summary = "Crear una nueva Empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa Registrada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.ok(empresaService.crear(empresaDTO));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar una Empresa Por ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<Optional<EmpresaEntity>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.buscarxId(id));
    }
    @GetMapping("/todos")
    @Operation(summary = "Buscar y mostrar todas las empresas creadas")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresas Registradas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<List<EmpresaEntity>> buscarTodos(){
        return ResponseEntity.ok(empresaService.buscarAll());
    }

    @PutMapping("/actualizar/{id}")
    @Operation(summary = "Buscar una empresa por su id y actualizar dicha empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa actualizada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id, @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.ok(empresaService.actualizar(id,empresaDTO));
    }
    @DeleteMapping("/eliminar/{id}")
    @Operation(summary = "Buscar una empresa por su id y hace un borrado logico de dicha empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa eliminada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> eliminar(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.borrar(id));
    }

}
