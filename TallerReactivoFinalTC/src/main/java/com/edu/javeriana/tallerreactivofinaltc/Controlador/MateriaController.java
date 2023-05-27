package com.edu.javeriana.tallerreactivofinaltc.Controlador;

import com.edu.javeriana.tallerreactivofinaltc.Modelo.Materia;
import com.edu.javeriana.tallerreactivofinaltc.Repositorio.MateriaRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/materias")
public class MateriaController
{
    private final MateriaRepository materiaRepository;

    public MateriaController(MateriaRepository materiaRepository)
    {
        this.materiaRepository = materiaRepository;
    }

    @PostMapping
    public Mono<Materia> crearMateria(@RequestBody Materia materia)
    {
        return materiaRepository.save(materia);
    }

    @GetMapping
    public Flux<Materia> obtenerTodasLasMaterias()
    {
        return materiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Materia> obtenerMateriaPorId(@PathVariable Integer id)
    {
        return materiaRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Materia> actualizarMateria(@PathVariable Integer id, @RequestBody Materia materia)
    {
        return materiaRepository.findById(id)
                .flatMap(m -> {
                    m.setNombre(materia.getNombre());
                    m.setCreditos(materia.getCreditos());
                    return materiaRepository.save(m);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> borrarMateria(@PathVariable Integer id)
    {
        return materiaRepository.deleteById(id);
    }
}
