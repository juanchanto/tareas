package jaca.todotic.tareas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Note {
    @Id
    private String id;
    private String titulo;
    private String nota;
    private String etiquetas;
    private boolean estado;
    private Date fechaCreado;
    private Date fechaModificacion;

}
