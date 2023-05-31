package com.edu.javeriana.tallerreactivofinaltc.Controlador;

import com.edu.javeriana.tallerreactivofinaltc.DTO.NotaEstudianteDTO;
import com.edu.javeriana.tallerreactivofinaltc.Modelo.Nota;
import com.edu.javeriana.tallerreactivofinaltc.Modelo.Persona;
import com.edu.javeriana.tallerreactivofinaltc.Repositorio.PersonaRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController
{
    private final PersonaRepository personaRepository;
    private static final int LIMIT_RATE = 50;


    public PersonaController(PersonaRepository personaRepository)
    {
        this.personaRepository = personaRepository;
    }

    @PostMapping
    public Mono<Persona> crearPersona(@RequestBody Persona persona)
    {
        return personaRepository.save(persona);
    }

    @GetMapping
    public Flux<Persona> obtenerTodasLasPersonas()
    {
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Persona> obtenerPersonaPorId(@PathVariable Integer id)
    {
        return personaRepository.findById(id);
    }

    @GetMapping("/estudiante/{id}")
    public Flux<Nota> obtenerEstudiantePorId(@PathVariable Integer id)
    {
        return personaRepository.findStudentById(id);
    }






    @PutMapping("/{id}")
    public Mono<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona persona)
    {
        return personaRepository.findById(id)
                .flatMap(p -> {
                    p.setNombre(persona.getNombre());
                    p.setApellido(persona.getApellido());
                    p.setCorreo(persona.getCorreo());
                    p.setRol(persona.getRol());
                    return personaRepository.save(p);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> borrarPersona(@PathVariable Integer id)
    {
        return personaRepository.deleteById(id);
    }

    @GetMapping("/estudiante")
    public Flux<Persona> obtenerTodosLosEstudiantes()
    {
        return personaRepository.findAllStudents().limitRate(LIMIT_RATE);
    }

    @GetMapping("/estudiante/{estudianteId}/{materiaId}/notas")
    public Flux<NotaEstudianteDTO> obtenerNotasEstudiantePorMateria(@PathVariable int estudianteId, @PathVariable int materiaId) {
        return personaRepository.findByEstudianteIdAndMateriaId(estudianteId, materiaId);

    }


}

