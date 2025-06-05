package com.service.soporte.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.soporte.Model.Soporte;
import com.service.soporte.Service.SoporteService;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/soportes")
public class SoporteController {
    @Autowired
    private SoporteService soporteService;


    @GetMapping
    public ResponseEntity<List<Soporte>> listar() {
        List<Soporte> soportes = soporteService.findAll();
        if (soportes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(soportes);
    }

    @PostMapping()
    public ResponseEntity<Soporte> guardar(@RequestBody Soporte soporte){
        Soporte nuevo = soporteService.save(soporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soporte> buscar(@PathVariable Integer id) {
        try {
            Soporte soporte = soporteService.findById(id);
            return ResponseEntity.ok(soporte);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Soporte> actualizar(@PathVariable Integer id, @RequestBody Soporte soporte) {
        try {
            Soporte existente = soporteService.findById(id);
            existente.setId(id);
            existente.setFecha(soporte.getFecha());
            existente.setDesc(soporte.getDesc());
            existente.setTipo(soporte.getTipo());

            Soporte actualizado = soporteService.save(existente);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            soporteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
