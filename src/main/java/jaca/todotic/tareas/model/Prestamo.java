package jaca.todotic.tareas.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Prestamo {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private boolean estado;
    private BigDecimal montoPrestamo;
    private BigDecimal montoCuota;
    private BigDecimal tasaInteres;

}
