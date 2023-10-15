package jaca.todotic.tareas.repo;

import jaca.todotic.tareas.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
}
