package com.tingeso.autorizacionservice.controllers;


import com.tingeso.autorizacionservice.entities.AutorizacionEntity;
import com.tingeso.autorizacionservice.services.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autorizaciones")
public class AutorizacionController {

    @Autowired
    AutorizacionService autorizacionService;

    @GetMapping
    public ResponseEntity<List<AutorizacionEntity>> obtenerAutorizaciones() {
        List<AutorizacionEntity> autorizaciones = autorizacionService.obtenerAutorizaciones();
        if (autorizaciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autorizaciones);
    }


    @GetMapping("/porempleado/{rut}/{fecha}")
    public ResponseEntity<AutorizacionEntity> obtenerAutorizacionPorRut(
            @PathVariable("rut") String rut, @PathVariable("fecha") String fecha)
    {
        AutorizacionEntity autorizacion = autorizacionService.buscarAutorizacion(rut, fecha);
        return ResponseEntity.ok(autorizacion);
    }

    @PostMapping
    public ResponseEntity<AutorizacionEntity> guardarAutorizacion( @RequestBody AutorizacionEntity autorizacion)
    {
        AutorizacionEntity nuevaAutorizacion = autorizacionService.guardarAutorizacion(autorizacion);
        return ResponseEntity.ok(nuevaAutorizacion);
    }

    @GetMapping("/eliminar")
    public void eliminarAutorizaciones(){
        autorizacionService.eliminarAutorizaciones();
    }
}