package es.dmunozfer.cloud.notes.client.messaging.outbound;

import es.dmunozfer.cloud.notes.client.messaging.channel.NotesChannel;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by David Muñoz on 28/12/2016.
 */
@MessagingGateway
public interface NotesWriter {

    @Gateway(requestChannel = NotesChannel.OUTPUT)
    void write(String noteText);
}