package com.edu.javeriana.tallerreactivofinaltc.modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Persona
{
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private char rol;
}
