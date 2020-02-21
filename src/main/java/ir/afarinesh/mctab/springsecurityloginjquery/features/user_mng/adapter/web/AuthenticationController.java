package ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.adapter.web;

import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.UserAuthenticationUseCase;
import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.commands.UserAuthenticationCommand;
import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.exceptions.UserAuthenticationException;
import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.outcomes.UserAuthenticationOutcome;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    final UserAuthenticationUseCase userAuthenticationUseCase;

    public AuthenticationController(UserAuthenticationUseCase userAuthenticationUseCase) {
        this.userAuthenticationUseCase = userAuthenticationUseCase;
    }

    @PostMapping("/login")
    private UserAuthenticationOutcome login(@RequestBody UserAuthenticationCommand command) throws UserAuthenticationException {
        LOGGER.info("User is authenticated by username: " + command.getUsername());
        return userAuthenticationUseCase.login(command);
    }
}
