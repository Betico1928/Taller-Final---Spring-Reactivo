package com.edu.javeriana.tallerreactivofinaltc.Modelo;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;


@Data
@Getter
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
