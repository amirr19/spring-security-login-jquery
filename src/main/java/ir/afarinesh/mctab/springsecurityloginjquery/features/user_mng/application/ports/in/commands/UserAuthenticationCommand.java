package ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.commands;

import ir.afarinesh.mctab.springsecurityloginjquery.core.annotations.UseCaseCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString

@UseCaseCommand
public class UserAuthenticationCommand {
    private String username;
    private String password;
}
