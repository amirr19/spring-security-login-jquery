package ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.application.ports.in;

import ir.afarinesh.mctab.springsecurityloginjquery.core.annotations.UseCase;
import ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.application.ports.in.commands.FirstLoginMessageCommand;
import ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.domain.FirstLoginMessage;

@UseCase
public interface FirstLoginMessageUseCase {
    FirstLoginMessage firstMessage(FirstLoginMessageCommand command) throws Exception;
}
