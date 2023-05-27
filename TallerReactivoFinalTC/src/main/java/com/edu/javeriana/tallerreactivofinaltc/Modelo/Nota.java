package com.edu.javeriana.tallerreactivofinaltc.Modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Nota
{
    @Id
    private Integer id;
    private Integer materiaId;
    private Integer profesorId;
    private Integer estudianteId;
    private String observacion;
    private Double valor;
}
