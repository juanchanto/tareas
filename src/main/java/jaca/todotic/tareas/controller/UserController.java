package jaca.todotic.tareas.controller;

import jaca.todotic.tareas.model.User;
import jaca.todotic.tareas.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    List<User> index() {return userRepository.findAll();}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    User create(@RequestBody User user){return userRepository.save(user);}

    /*Revisar metodo por ser usuario, solo actualiza contraseña*/
    @PutMapping("{id}")
    User update(@PathVariable String id, @RequestBody User user){
        User userFromDb = userRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        userFromDb.setPassword(user.getPassword());
        userFromDb.setFechaModificacion(user.getFechaModificacion());

        return userRepository.save(userFromDb);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        User user = userRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        userRepository.delete(user);
    }
}
