package com.example.banguat.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tipo_cambio")
public class TipoCambioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroSolicitud;
    private String respuesta;
    private LocalDateTime fechaConsulta;
}