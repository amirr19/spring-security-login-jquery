package ir.afarinesh.mctab.springsecurityloginjquery.features.user_mng.application.ports.in.outcomes;

import ir.afarinesh.mctab.springsecurityloginjquery.core.annotations.UseCaseOutcome;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

@UseCaseOutcome
public class UserAuthenticationOutcome {
    Boolean isAuthenticated;
}
