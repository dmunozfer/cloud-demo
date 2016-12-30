package es.dmunozfer.cloud.oauth.repository;

import es.dmunozfer.cloud.oauth.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by David Muñoz on 30/12/2016.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}