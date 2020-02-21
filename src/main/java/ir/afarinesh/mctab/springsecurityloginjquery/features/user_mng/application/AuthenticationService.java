package ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application;

import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.UserAuthenticationUseCase;
import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.commands.UserAuthenticationCommand;
import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.exceptions.UserAuthenticationException;
import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.outcomes.UserAuthenticationOutcome;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;

@Service
public class AuthenticationService implements UserAuthenticationUseCase {
    @Override
    public UserAuthenticationOutcome login(UserAuthenticationCommand command) throws UserAuthenticationException {
        return new UserAuthenticationOutcome(true);
    }
}
