package com.challenge.foro.service;

import com.challenge.foro.model.Topico;
import com.challenge.foro.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> obtenerTodos() {
        return topicoRepository.findAll();
    }

    public Topico obtenerPorId(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
    }

    public Topico crear(Topico topico) {
        return topicoRepository.save(topico);
    }

    public Topico actualizar(Long id, Topico detalles) {
        Topico topico = obtenerPorId(id);
        topico.setTitulo(detalles.getTitulo());
        topico.setMensaje(detalles.getMensaje());
        return topicoRepository.save(topico);
    }

    public void eliminar(Long id) {
        Topico topico = obtenerPorId(id);
        topicoRepository.delete(topico);
    }
}