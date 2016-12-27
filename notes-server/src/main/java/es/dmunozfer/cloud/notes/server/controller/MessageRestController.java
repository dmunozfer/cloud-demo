package es.dmunozfer.cloud.notes.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by David Muñoz on 26/12/2016.
 */
@RestController
@RefreshScope
public class MessageRestController {
    private final String message;

    @Autowired
    public MessageRestController(@Value("${message}") String message) {
        this.message = message;
    }

    @GetMapping("/message")
    public String read() {
        return message;
    }
}
