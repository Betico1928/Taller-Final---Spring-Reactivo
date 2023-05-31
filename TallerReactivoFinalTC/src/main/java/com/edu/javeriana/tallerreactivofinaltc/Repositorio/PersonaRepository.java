package com.edu.javeriana.tallerreactivofinaltc.Repositorio;

import com.edu.javeriana.tallerreactivofinaltc.DTO.NotaEstudianteDTO;
import com.edu.javeriana.tallerreactivofinaltc.Modelo.Nota;
import com.edu.javeriana.tallerreactivofinaltc.Modelo.Persona;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PersonaRepository extends ReactiveCrudRepository<Persona, Integer>
{
    @Query("SELECT * FROM persona WHERE rol = 'E'")
    Flux<Persona> findAllStudents();

    @Query("SELECT * FROM nota WHERE  estudiante_id = :id")
    Flux<Nota> findStudentById(Integer id);

    @Query("SELECT p.nombre as estudiante, m.nombre as materia, n.observacion, n.valor " +
            "FROM nota n " +
            "INNER JOIN persona p ON n.estudiante_id = p.id " +
            "INNER JOIN materia m ON n.materia_id = m.id " +
            "WHERE n.estudiante_id = :estudianteId AND n.materia_id = :materiaId ")
    Flux<NotaEstudianteDTO> findByEstudianteIdAndMateriaId(Integer estudianteId, Integer materiaId);
}



