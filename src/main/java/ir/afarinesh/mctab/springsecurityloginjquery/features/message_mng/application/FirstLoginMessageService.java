package ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.application;

import ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.application.ports.in.FirstLoginMessageUseCase;
import ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.application.ports.in.commands.FirstLoginMessageCommand;
import ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.domain.FirstLoginMessage;
import org.springframework.stereotype.Service;

@Service
public class FirstLoginMessageService implements FirstLoginMessageUseCase {
    @Override
    public FirstLoginMessage firstMessage(FirstLoginMessageCommand command) throws Exception {
        return new FirstLoginMessage(command.getWhoIAm() + " " + "به نخستین ورود خودتان خوش آمدید");
    }
}
