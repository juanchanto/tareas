package jaca.todotic.tareas.controller;

import jaca.todotic.tareas.model.Message;
import jaca.todotic.tareas.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("")
    List<Message> index(){return messageRepository.findAll();}

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Message create(@RequestBody Message message){ return messageRepository.save(message);}

}