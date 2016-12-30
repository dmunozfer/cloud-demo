package es.dmunozfer.cloud.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by David Muñoz on 30/12/2016.
 */
@RestController
public class PrincipalRestController {

    @RequestMapping("/user")
    Principal principal(Principal principal) {
        return principal;
    }
}
