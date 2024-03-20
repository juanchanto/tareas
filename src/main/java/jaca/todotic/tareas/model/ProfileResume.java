package jaca.todotic.tareas.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class ProfileResume {
    private String id;
    private String nombre;
    private String resumen;
    private String habilidades;
    private String idiomas;
    private String linkedIn;
    private byte[] file;
    private boolean estado;
    private Date fechaCreado;
    private Date fechaModificacion;
}
