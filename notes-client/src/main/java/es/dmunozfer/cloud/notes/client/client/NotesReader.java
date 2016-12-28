package es.dmunozfer.cloud.notes.client.client;

import es.dmunozfer.cloud.notes.client.model.Note;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by David Muñoz on 28/12/2016.
 */
@FeignClient("notes-server")
public interface NotesReader {

    @RequestMapping(method = RequestMethod.GET, value = "/notes")
    Resources<Note> notes();

    @RequestMapping(method = RequestMethod.GET, value = "/message")
    String message();
}
