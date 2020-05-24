package bts.io.server.home.controller;

import bts.io.server.home.model.Message;
import bts.io.server.home.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ping")
public class PingController {
    private long count = 0;

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity<Message> ping() {
        Message message = new Message(count++, String.valueOf(count));
        return ResponseEntity.ok(message);
    }

    @GetMapping("/reset")
    public ResponseEntity<String> reset() {
        count = 0;
        return ResponseEntity.ok("reset");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Message>> getAll() {
        List<Message> allMessage = messageService.getAllMessage();
        return ResponseEntity.ok(allMessage);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addMessage(Message message) {
        messageService.addMessage(message);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
