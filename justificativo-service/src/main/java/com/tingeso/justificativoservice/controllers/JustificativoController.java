package com.tingeso.justificativoservice.controllers;

import com.tingeso.justificativoservice.entities.JustificativoEntity;
import com.tingeso.justificativoservice.services.JustificativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/justificativo")
public class JustificativoController {

    @Autowired
    JustificativoService justificativoService;

    @GetMapping
    public List<JustificativoEntity> obtenerJustificativos(){
        return justificativoService.obtenerJustificativos();
    }

    @GetMapping("/porempleados/{rut}")
    public ResponseEntity<List<JustificativoEntity>> obtenerJustificativosPorRut(@PathVariable("rut") String rut) {
        List<JustificativoEntity> justificativos = justificativoService.obtenerJustificativosEmpleado(
                rut);
        return ResponseEntity.ok(justificativos);
    }

    @PostMapping
    public ResponseEntity<JustificativoEntity> guardarJustificativo(@RequestBody JustificativoEntity justificativo) {
        JustificativoEntity nuevoJustificativo = justificativoService.guardarJustificativo(justificativo);
        return ResponseEntity.ok(nuevoJustificativo);
    }

    @GetMapping("/eliminar")
    public void eliminarJustificativos(){
        justificativoService.eliminarJustificativos();
    }
}