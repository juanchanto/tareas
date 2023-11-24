package jaca.todotic.tareas.repo;

import jaca.todotic.tareas.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
