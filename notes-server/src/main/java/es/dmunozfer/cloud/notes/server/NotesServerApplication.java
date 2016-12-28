package es.dmunozfer.cloud.notes.server;

import es.dmunozfer.cloud.notes.server.model.Note;
import es.dmunozfer.cloud.notes.server.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding(NotesChannel.class)
@EnableDiscoveryClient
@SpringBootApplication
public class NotesServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesServerApplication.class, args);
    }

}

interface NotesChannel {
    @Input
    SubscribableChannel input();
}

@MessageEndpoint
class NoteProcessor {

    private final NoteRepository noteRepository;

    @Autowired
    NoteProcessor(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @ServiceActivator(inputChannel = "input")
    public void onNewNote(String text) {
        this.noteRepository.save(new Note(text));
    }
}