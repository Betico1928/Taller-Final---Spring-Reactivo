package com.edu.javeriana.tallerreactivofinaltc.Controlador;

import com.edu.javeriana.tallerreactivofinaltc.Modelo.Curso;
import com.edu.javeriana.tallerreactivofinaltc.Repositorio.CursoRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository)
    {
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public Mono<Curso> crearCurso(@RequestBody Curso curso)
    {
        return cursoRepository.save(curso);
    }

    @GetMapping
    public Flux<Curso> obtenerTodosLosCursos()
    {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Curso> obtenerCursoPorId(@PathVariable Integer id)
    {
        return cursoRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Curso> actualizarCurso(@PathVariable Integer id, @RequestBody Curso curso)
    {
        return cursoRepository.findById(id)
                .flatMap(c -> {
                    c.setEstudianteId(curso.getEstudianteId());
                    c.setProfesorId(curso.getProfesorId());
                    c.setNumero(curso.getNumero());
                    return cursoRepository.save(c);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> borrarCurso(@PathVariable Integer id)
    {
        return cursoRepository.deleteById(id);
    }
}

