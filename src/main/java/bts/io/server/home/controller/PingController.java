package bts.io.server.home.controller;

import bts.io.server.home.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {
    private long count = 0;
    @GetMapping
    public ResponseEntity<Message> ping() {
        Message message = new Message(count++, String.valueOf(count));
        return ResponseEntity.ok(message);
    }
}
