package es.dmunozfer.cloud.notes.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by David Muñoz on 27/12/2016.
 */
@RestController
@RequestMapping("/notes")
public class NotesApiGateway {

    private final NotesReader notesReader;

    @Autowired
    public NotesApiGateway(NotesReader notesReader) {
        this.notesReader = notesReader;
    }

    @GetMapping("text")
    public List<String> text() {
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
}

@FeignClient("notes-server")
interface NotesReader {

    @RequestMapping(method = RequestMethod.GET, value = "/notes")
    Resources<Note> notes();

    @RequestMapping(method = RequestMethod.GET, value = "/message")
    String message();
}

class Note {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}