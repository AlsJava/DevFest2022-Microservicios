package edu.alsjava.deffest.service;

import edu.alsjava.deffest.command.CalculateFactorialCommand;
import edu.alsjava.deffest.command.CreateUserCommand;
import edu.alsjava.deffest.model.network.request.CalculateFactorialRequest;
import edu.alsjava.deffest.model.network.request.CreateUserRequest;
import edu.alsjava.deffest.model.network.response.CalculateFactorialResponse;
import edu.alsjava.deffest.model.network.response.CreateUserResponse;
import edu.alsjava.deffest.pattern.command.CommandBus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {

    private final CommandBus commandBus;

    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        return commandBus.sendCommand(CreateUserCommand.builder()
                .name(createUserRequest.getName())
                .build());
    }

    public CalculateFactorialResponse calculateFactorial(CalculateFactorialRequest calculateFactorialRequest) {
        return commandBus.sendCommand(CalculateFactorialCommand.builder()
                .id(UUID.randomUUID())
                .num(calculateFactorialRequest.getNum())
                .build());
    }
}
