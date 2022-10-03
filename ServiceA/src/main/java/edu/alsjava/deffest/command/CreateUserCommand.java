package edu.alsjava.deffest.command;

import edu.alsjava.deffest.model.network.response.CreateUserResponse;
import edu.alsjava.deffest.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateUserCommand extends Command<CreateUserResponse> {

    private String name;

}
