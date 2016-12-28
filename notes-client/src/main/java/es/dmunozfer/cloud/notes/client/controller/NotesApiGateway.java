package es.dmunozfer.cloud.notes.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import es.dmunozfer.cloud.notes.client.client.NotesReader;
import es.dmunozfer.cloud.notes.client.messaging.outbound.NotesWriter;
import es.dmunozfer.cloud.notes.client.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by David Muñoz on 27/12/2016.
 */
@RestController
@RequestMapping("/notes")
public class NotesApiGateway {

    private final NotesReader notesReader;
    private final NotesWriter notesWriter;

    @Autowired
    public NotesApiGateway(NotesReader notesReader, NotesWriter notesWriter) {
        this.notesReader = notesReader;
        this.notesWriter = notesWriter;
    }

    public Collection<String> fallbackText() {
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "fallbackText")
    @GetMapping("text")
    public Collection<String> text() {
        return this.notesReader
                .notes()
                .getContent()
                .stream()
                .map(Note::getText)
                .collect(Collectors.toList());
    }

    @GetMapping("message")
    public String message() {
        return this.notesReader.message();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public void write(@RequestBody Note note) {
        this.notesWriter.write(note.getText());
    }
}

