package es.dmunozfer.cloud.notes.server;

import es.dmunozfer.cloud.notes.server.model.Note;
import es.dmunozfer.cloud.notes.server.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by David Muñoz on 26/12/2016.
 */
@Component
public class NotesServerSampleDataCLR implements CommandLineRunner {

    private final NoteRepository noteRepository;

    @Autowired
    public NotesServerSampleDataCLR(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Note 1", "Note 2", "Note 3", "Note 4", "Note 5").forEach(note -> noteRepository.save(new Note(note)));
        noteRepository.findAll().forEach(System.out::println);
    }
}
