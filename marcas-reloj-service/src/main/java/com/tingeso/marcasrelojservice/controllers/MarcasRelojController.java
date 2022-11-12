package com.tingeso.marcasrelojservice.controllers;

import com.tingeso.marcasrelojservice.entities.MarcasRelojEntity;
import com.tingeso.marcasrelojservice.services.MarcasRelojService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

@RestController
@RequestMapping("/marcasreloj")
public class MarcasRelojController {

    @Autowired
    private MarcasRelojService marcasRelojService;

    @GetMapping
    public ResponseEntity<ArrayList<MarcasRelojEntity>> obtenerData() {
        ArrayList<MarcasRelojEntity> data = marcasRelojService.obtenerData();
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(data);
    }

    @PostMapping
    public void guardarData(@RequestParam("file") MultipartFile file, RedirectAttributes ms) throws FileNotFoundException, ParseException{
        marcasRelojService.guardar(file);
        marcasRelojService.leerTxt("Data.txt");
    }
}
