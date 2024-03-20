package jaca.todotic.tareas.repo;

import jaca.todotic.tareas.model.ProfileResume;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileResumeRepository extends MongoRepository<ProfileResume, String> {
}
