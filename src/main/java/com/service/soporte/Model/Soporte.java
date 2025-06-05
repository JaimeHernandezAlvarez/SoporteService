package com.service.soporte.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "soporte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soporte {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "soporte_seq")
    @SequenceGenerator(name = "soporte_seq", sequenceName = "SEQ_SOPORTE", allocationSize = 1)
    @Column(name = "id_soporte")
    private Integer id;

    @Column(name = "fecha_creacion", length = 20)
    private String fecha;

    @Column(name = "tipo_soporte")
    private String tipo;

    @Column(name = "descripcion")
    private String desc;
}
