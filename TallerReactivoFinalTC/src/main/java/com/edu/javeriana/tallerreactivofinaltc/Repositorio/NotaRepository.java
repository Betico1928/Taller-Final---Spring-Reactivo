package com.edu.javeriana.tallerreactivofinaltc.Repositorio;

import com.edu.javeriana.tallerreactivofinaltc.Modelo.Nota;
import com.edu.javeriana.tallerreactivofinaltc.Modelo.Persona;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface NotaRepository extends ReactiveCrudRepository<Nota, Integer>
{


}
