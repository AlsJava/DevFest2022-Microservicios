package edu.alsjava.deffest.command;

import edu.alsjava.deffest.model.network.response.CalculateFactorialResponse;
import edu.alsjava.deffest.pattern.command.Command;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CalculateFactorialCommand extends Command<CalculateFactorialResponse> {

    private UUID id;
    private Integer num;

}
