package ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in;

import ir.afarinesh.mctab.springsecurityloginjquery.core.annotations.UseCase;
import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.commands.UserAuthenticationCommand;
import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.exceptions.UserAuthenticationException;
import ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.outcomes.UserAuthenticationOutcome;

@UseCase
public interface UserAuthenticationUseCase {

    UserAuthenticationOutcome login(UserAuthenticationCommand command) throws UserAuthenticationException;
}
