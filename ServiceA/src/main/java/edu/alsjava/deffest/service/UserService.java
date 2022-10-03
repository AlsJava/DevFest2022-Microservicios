package edu.alsjava.deffest.service;

import edu.alsjava.deffest.command.CreateUserCommand;
import edu.alsjava.deffest.model.network.request.CreateUserRequest;
import edu.alsjava.deffest.model.network.response.CreateUserResponse;
import edu.alsjava.deffest.patterns.command.CommandBus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final CommandBus commandBus;

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        return commandBus.sendCommand(CreateUserCommand.builder()
                .name(createUserRequest.getName())
                .build());
    }
}
