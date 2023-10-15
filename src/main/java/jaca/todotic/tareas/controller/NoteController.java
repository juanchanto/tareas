package jaca.todotic.tareas.controller;

import jaca.todotic.tareas.model.Note;
import jaca.todotic.tareas.repo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("")
    List<Note> index(){
        return noteRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Note create(@RequestBody Note note){
        return noteRepository.save(note);
    }

    @PutMapping("{id}")
    Note update(@PathVariable String id, @RequestBody Note note){
        Note noteFromDb = noteRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        noteFromDb.setNota(note.getNota());
        noteFromDb.setEtiquetas(note.getEtiquetas());
        noteFromDb.setEstado(note.isEstado());
        noteFromDb.setTitulo(note.getTitulo());
        noteFromDb.setFechaModificacion(note.getFechaModificacion());

        return noteRepository.save(noteFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Note note = noteRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        noteRepository.delete(note);
    }
}
