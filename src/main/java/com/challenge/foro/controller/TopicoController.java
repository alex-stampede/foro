package com.challenge.foro.controller;

import com.challenge.foro.model.Topico;
import com.challenge.foro.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> listarTodos() {
        return topicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Topico> crear(@RequestBody Topico topico) {
        return ResponseEntity.ok(topicoService.crear(topico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizar(@PathVariable Long id, @RequestBody Topico detalles) {
        return ResponseEntity.ok(topicoService.actualizar(id, detalles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}