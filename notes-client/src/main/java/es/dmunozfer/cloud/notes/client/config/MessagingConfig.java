package es.dmunozfer.cloud.notes.client.config;

import es.dmunozfer.cloud.notes.client.messaging.channel.NotesChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;

/**
 * Created by David Muñoz on 28/12/2016.
 */
@EnableBinding(NotesChannel.class)
@IntegrationComponentScan
public class MessagingConfig {
}
