package jaca.todotic.tareas.repo;

import jaca.todotic.tareas.model.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrestamoRepository extends MongoRepository<Prestamo, String> {
}
