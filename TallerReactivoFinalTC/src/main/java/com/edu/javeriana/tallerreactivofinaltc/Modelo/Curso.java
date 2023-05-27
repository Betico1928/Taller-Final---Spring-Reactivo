package com.edu.javeriana.tallerreactivofinaltc.Modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Curso
{
    @Id
    private Integer materiaId;
    private Integer profesorId;
    private String numero;
    private Integer estudianteId;
}
