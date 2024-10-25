package com.sgh.sgh.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    public Date fecha_cita;
    public String estado;
    public Integer paciente_id;
    public Integer personal_medico_id;
    public Integer usuario_creacion;
    @Column(name = "usuario_modificacion", nullable = true)
    private Integer usuario_modificacion;  
    @Column(name = "fecha_creacion", updatable = false, nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Column(name = "fecha_modificacion", nullable = false)
    private LocalDateTime fechaModificacion = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
    	fechaCreacion = LocalDateTime.now();
    	fechaModificacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
    	fechaModificacion = LocalDateTime.now();
    }
}
