package com.tingeso.justificativoservice.services;

import com.tingeso.justificativoservice.entities.JustificativoEntity;
import com.tingeso.justificativoservice.repositories.JustificativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JustificativoService {

    @Autowired
    private JustificativoRepository justificativoRepository;

    public JustificativoEntity guardarJustificativo(JustificativoEntity justificativo){
        JustificativoEntity nuevoJustificativo = justificativoRepository.save(justificativo);
        return nuevoJustificativo;
    }

    public List<JustificativoEntity> obtenerJustificativos(){
        return justificativoRepository.findAll();
    }
    public JustificativoEntity buscarJustificativo(String rut, String fecha){
        return this.justificativoRepository.buscarJustificativo(rut, fecha);
    }

    public void eliminarJustificativo(JustificativoEntity justificativo){
        this.justificativoRepository.delete(justificativo);
    }

    public List<JustificativoEntity> obtenerJustificativosEmpleado(String rut){
        return justificativoRepository.buscarJustificativosPorRUT(rut);
    }
    public void eliminarJustificativos(){
        this.justificativoRepository.deleteAll();
    }

}