package com.edu.javeriana.tallerreactivofinaltc.Modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Materia
{
    @Id
    private Integer id;
    private String nombre;
    private Integer creditos;
}
