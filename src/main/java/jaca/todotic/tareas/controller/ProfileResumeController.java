package jaca.todotic.tareas.controller;

import jaca.todotic.tareas.model.ProfileResume;
import jaca.todotic.tareas.repo.ProfileResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/profiles")
public class ProfileResumeController {
    @Autowired
    private ProfileResumeRepository profileResumeRepository;

    @GetMapping("")
    List<ProfileResume> index(){return profileResumeRepository.findAll();}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    ProfileResume create(@RequestBody ProfileResume profileResume){return profileResumeRepository.save(profileResume);}

    @PutMapping("{id}")
    ProfileResume update(@PathVariable String id, @RequestBody ProfileResume profileResume){
        ProfileResume profileResumeFromDb = profileResumeRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        profileResumeFromDb.setNombre(profileResume.getNombre());
        profileResumeFromDb.setResumen(profileResume.getResumen());
        profileResumeFromDb.setHabilidades(profileResume.getHabilidades());
        profileResumeFromDb.setIdiomas(profileResume.getIdiomas());
        profileResumeFromDb.setLinkedIn(profileResume.getLinkedIn());
        profileResumeFromDb.setFile(profileResume.getFile());
        profileResumeFromDb.setEstado(profileResume.isEstado());
        profileResumeFromDb.setFechaModificacion(profileResume.getFechaModificacion());

        return profileResumeRepository.save(profileResumeFromDb);
    }
}
