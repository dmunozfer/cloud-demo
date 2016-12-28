package es.dmunozfer.cloud.notes.client.messaging.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by David Muñoz on 28/12/2016.
 */
public interface NotesChannel {

    String OUTPUT = "output";

    @Output(NotesChannel.OUTPUT)
    MessageChannel output();
}