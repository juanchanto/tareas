package jaca.todotic.tareas.controller;

import jaca.todotic.tareas.model.User;
import jaca.todotic.tareas.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Lógica de autenticación / verificación de credenciales
        // Puedes usar UserRepository o un servicio de autenticación personalizado aquí

        User user = userRepository
                .findById(username)
                .orElseThrow(RuntimeException::new);
        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    // Otros métodos relacionados con la autenticación, si los hay
}
