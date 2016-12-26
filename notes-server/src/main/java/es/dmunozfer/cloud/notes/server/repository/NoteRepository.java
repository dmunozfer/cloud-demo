package es.dmunozfer.cloud.notes.server.repository;

import es.dmunozfer.cloud.notes.server.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by David Muñoz on 26/12/2016.
 */
@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note, Long> {
}
