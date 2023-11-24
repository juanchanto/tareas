package jaca.todotic.tareas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class User {
    private String id;
    private String nombre;
    private String apellido;
    private String password;
    private Date fechaNacimiento;
    private boolean estado;
    private Date fechaCreado;
    private Date fechaModificacion;
}
