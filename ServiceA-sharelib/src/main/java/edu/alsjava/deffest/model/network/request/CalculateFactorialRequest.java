package edu.alsjava.deffest.model.network.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CalculateFactorialRequest {

    @PositiveOrZero
    private Integer num;
}
