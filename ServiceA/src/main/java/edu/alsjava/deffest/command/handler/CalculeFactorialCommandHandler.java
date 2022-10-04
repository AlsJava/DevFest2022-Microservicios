package edu.alsjava.deffest.command.handler;

import edu.alsjava.deffest.command.CalculateFactorialCommand;
import edu.alsjava.deffest.model.network.response.CalculateFactorialResponse;
import edu.alsjava.deffest.pattern.command.CommandEvent;
import edu.alsjava.deffest.pattern.command.CommandHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@CommandEvent(command = CalculateFactorialCommand.class)
@Slf4j
public class CalculeFactorialCommandHandler implements CommandHandler<CalculateFactorialResponse, CalculateFactorialCommand> {

    private static final Map<Integer, Long> FACTORIALS = new HashMap<>() {{
        put(0, 1L);
        put(1, 1L);
        put(2, 2L);
        put(3, 6L);
    }};

    @Override
    public CalculateFactorialResponse handle(CalculateFactorialCommand command) {
        long factorial = factorial(command.getId(), command.getNum());
        return CalculateFactorialResponse.builder()
                .num(command.getNum())
                .factorial(factorial)
                .build();
    }

    public long factorial(UUID id, int num) {
        log.info("Running process ID: {} and factorial {} ", id, num);
        if (FACTORIALS.get(num) == null) {
            log.info("{} - Starting factorial calculation process, value {} is not in memory", id, num);
            int size = FACTORIALS.size();
            for (int i = size; i <= num; i++) {
                Long lastValueCalculated = FACTORIALS.get(i - 1);
                long factorial = lastValueCalculated * i;
                log.debug("{} - Factorial ({}) pre calculated is {}", id, i, factorial);
                FACTORIALS.put(i, factorial);
            }
            log.info("{} - Ending factorial calculation process, value {}", id, num);
        }
        return FACTORIALS.get(num);
    }
}
