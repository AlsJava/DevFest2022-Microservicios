package edu.alsjava.deffest.command.handler;

import edu.alsjava.deffest.command.CreateUserCommand;
import edu.alsjava.deffest.domain.User;
import edu.alsjava.deffest.model.network.response.CreateUserResponse;
import edu.alsjava.deffest.patterns.command.CommandEvent;
import edu.alsjava.deffest.patterns.command.CommandHandler;
import edu.alsjava.deffest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CommandEvent(command = CreateUserCommand.class)
@Slf4j
public class WithdrawCommandHandler implements CommandHandler<CreateUserResponse, CreateUserCommand> {

    private final UserRepository userRepository;

    @Override
    public CreateUserResponse handle(CreateUserCommand command) {
        User user = User.builder().name(command.getName()).build();
        userRepository.save(user);
        return CreateUserResponse.builder()
                .user(user.toDTO())
                .build();
    }
}
