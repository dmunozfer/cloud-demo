package es.dmunozfer.cloud;

import es.dmunozfer.cloud.oauth.model.Account;
import es.dmunozfer.cloud.oauth.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by David Muñoz on 30/12/2016.
 */
@Component
public class AccountsCLR implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public AccountsCLR(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("admin,admin", "user,password")
                .map(x -> x.split(","))
                .forEach(tuple -> this.accountRepository.save(new Account(tuple[0], tuple[1], true)));
    }
}
