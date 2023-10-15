package jaca.todotic.tareas.controller;

import jaca.todotic.tareas.model.Prestamo;
import jaca.todotic.tareas.repo.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping("")
    List<Prestamo> index(){
        return prestamoRepository.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Prestamo create(@RequestBody Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }

    @PutMapping("{id}")
    Prestamo update(@PathVariable String id, @RequestBody Prestamo prestamo){
        Prestamo prestamoFromDb = prestamoRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        prestamoFromDb.setNombre(prestamo.getNombre());
        prestamoFromDb.setTipo(prestamo.getTipo());
        prestamoFromDb.setEstado(prestamo.isEstado());
        prestamoFromDb.setMontoPrestamo(prestamo.getMontoPrestamo());
        prestamoFromDb.setMontoCuota(prestamo.getMontoCuota());
        prestamoFromDb.setTasaInteres(prestamo.getTasaInteres());

        return prestamoRepository.save(prestamoFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Prestamo prestamo = prestamoRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        prestamoRepository.delete(prestamo);
    }
}
