package es.dmunozfer.cloud.oauth.service;

import es.dmunozfer.cloud.oauth.repository.AccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by David Muñoz on 30/12/2016.
 */
@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    public AccountUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.accountRepository.findByUsername(username)
                .map(account -> new User(
                        account.getUsername(),
                        account.getPassword(),
                        account.isActive(), account.isActive(), account.isActive(), account.isActive(),
                        createAuthListFormUsername(username)
                ))
                .orElseThrow(() -> new UsernameNotFoundException("No user named " + username));
    }

    // Si el usuario es admin devuelve los roles ADMIN y USER, en caso contrario solo USER
    private List<GrantedAuthority> createAuthListFormUsername(String username) {
        return "admin".equalsIgnoreCase(username) ? AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")
                : AuthorityUtils.createAuthorityList("ROLE_USER");
    }
}