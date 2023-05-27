package com.edu.javeriana.tallerreactivofinaltc.Controlador;

import com.edu.javeriana.tallerreactivofinaltc.Modelo.Nota;
import com.edu.javeriana.tallerreactivofinaltc.Repositorio.NotaRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notas")
public class NotaController
{

    private final NotaRepository notaRepository;

    public NotaController(NotaRepository notaRepository)
    {
        this.notaRepository = notaRepository;
    }

    @PostMapping
    public Mono<Nota> crearNota(@RequestBody Nota nota)
    {
        return notaRepository.save(nota);
    }

    @GetMapping
    public Flux<Nota> obtenerTodasLasNotas()
    {
        return notaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Nota> obtenerNotaPorId(@PathVariable Integer id)
    {
        return notaRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Nota> actualizarNota(@PathVariable Integer id, @RequestBody Nota nota)
    {
        return notaRepository.findById(id)
                .flatMap(n -> {
                    n.setEstudianteId(nota.getEstudianteId());
                    n.setProfesorId(nota.getProfesorId());
                    n.setObservacion(nota.getObservacion());
                    n.setValor(nota.getValor());
                    return notaRepository.save(n);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> borrarNota(@PathVariable Integer id)
    {
        return notaRepository.deleteById(id);
    }
}

