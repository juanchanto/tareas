package jaca.todotic.tareas.repo;

import jaca.todotic.tareas.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
