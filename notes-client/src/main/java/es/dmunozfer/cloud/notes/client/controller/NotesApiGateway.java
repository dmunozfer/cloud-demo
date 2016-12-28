package es.dmunozfer.cloud.notes.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import es.dmunozfer.cloud.notes.client.model.Note;
import es.dmunozfer.cloud.notes.client.messaging.outbound.NotesWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
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

    @PostMapping
    public void write(@RequestBody Note note) {
        this.notesWriter.write(note.getText());
    }
}

@FeignClient("notes-server")
interface NotesReader {

    @RequestMapping(method = RequestMethod.GET, value = "/notes")
    Resources<Note> notes();

    @RequestMapping(method = RequestMethod.GET, value = "/message")
    String message();
}

