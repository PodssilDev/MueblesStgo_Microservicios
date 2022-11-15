package com.tingeso.oficinaRRHHservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tingeso.oficinaRRHHservice.entities.OficinaRRHHEntity;
import com.tingeso.oficinaRRHHservice.models.AutorizacionModel;
import com.tingeso.oficinaRRHHservice.models.JustificativoModel;
import com.tingeso.oficinaRRHHservice.repositories.OficinaRRHHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OficinaRRHHService {

    @Autowired
    private OficinaRRHHRepository oficinaRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RestTemplate restTemplate;

    public JustificativoModel obtenerJustificativo(String rut, String fecha){
        JustificativoModel justificativo = restTemplate.getForObject("http://justificativo-service/justificativo/porempleado/" + rut +"/"+ fecha, JustificativoModel.class);
        System.out.println(justificativo);
        return justificativo;
    }

    public AutorizacionModel obtenerAutorizacion(String rut, String fecha){
        AutorizacionModel autorizacion = restTemplate.getForObject("http://autorizacion-service/autorizacion/porempleado/" + rut +"/"+ fecha, AutorizacionModel.class);
        System.out.println(autorizacion);
        return autorizacion;
    }

    public double extraCategoria(String categoria, Integer contador) {
        switch (categoria) {
            case "A":
                return (25000 * contador);
            case "B":
                return (20000 * contador);
            case "C":
                return (10000 * contador);
            default:
                return 0.0;
        }
    }

    public Integer contarHoras(String hora_string) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm");
        Date hora = dt.parse(hora_string);
        int contador = 0;
        if (hora.after(dt.parse("18:00"))) {
            contador = (int) ((hora.getTime() - dt.parse("18:00").getTime()) / (60 * 60 * 1000));
        }
        return contador;
    }

    public double calcularBonificacionDedicacion(Integer sueldo_mensual, Integer dedicacion){
        if(sueldo_mensual < 0){
            return 0.0;
        }
        if((dedicacion >= 5) && (dedicacion < 10)){
            return (sueldo_mensual * 0.05);
        } else if((dedicacion >= 10) && (dedicacion < 15)){
            return (sueldo_mensual * 0.08);
        } else if((dedicacion >= 15) && (dedicacion < 20)){
            return (sueldo_mensual * 0.11);
        } else if((dedicacion >= 20) && (dedicacion < 25)){
            return (sueldo_mensual * 0.14);
        } else if(dedicacion >= 25){
            return (sueldo_mensual * 0.17);
        } else{
            return 0.0;
        }
    }

    public Integer obtenerSueldo(String categoria){
        if(categoria.equals("A")){
            return 1700000;
        } else if (categoria.equals("B")) {
            return 1200000;
        }
        else{
            return 800000;
        }
    }

    public Boolean comprobarAtrasado(String hora_string) throws ParseException {
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm");
        Date hora = dt.parse(hora_string);
        return hora.after(dt.parse("09:10"));
    }

    public ArrayList<OficinaRRHHEntity> obtenerData(){
        return (ArrayList<OficinaRRHHEntity>) oficinaRepository.findAll();
    }

    public Calendar prepararCalendario(String fecha) throws ParseException {
        Calendar calendario = Calendar.getInstance();
        DateFormat date1=new SimpleDateFormat("yyyy/MM/dd");
        Date real_fecha = date1.parse(fecha);
        calendario.setTime(real_fecha);
        return calendario;
    }

    public Boolean comprobarFinesSemana(Calendar calendario){
        int dia = calendario.get(Calendar.DAY_OF_WEEK);
        return dia == Calendar.SATURDAY || dia == Calendar.SUNDAY;
    }

    public String formatDate(Calendar calendario){
        DateFormat date1=new SimpleDateFormat("yyyy/MM/dd");
        return date1.format(calendario.getTime());
    }

    public OficinaRRHHEntity encontrarRut(String rut){
        return oficinaRepository.findByRut(rut);
    }

    public void eliminarData(OficinaRRHHEntity reporte){
        oficinaRepository.delete(reporte);
    }

}
