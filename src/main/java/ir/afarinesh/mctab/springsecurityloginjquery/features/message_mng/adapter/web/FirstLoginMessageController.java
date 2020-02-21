package ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.adapter.web;

import ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.application.ports.in.FirstLoginMessageUseCase;
import ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.application.ports.in.commands.FirstLoginMessageCommand;
import ir.afarinesh.mctab.springsecurityloginjquery.features.message_mng.domain.FirstLoginMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message/first-login")
public class FirstLoginMessageController {

    final FirstLoginMessageUseCase firstLoginMessageUseCase;

    public FirstLoginMessageController(FirstLoginMessageUseCase firstLoginMessageUseCase) {
        this.firstLoginMessageUseCase = firstLoginMessageUseCase;
    }

    @PostMapping
    private FirstLoginMessage firstLoginMessage(@RequestBody FirstLoginMessageCommand command) throws Exception {
        return firstLoginMessageUseCase.firstMessage(command);
    }
}
