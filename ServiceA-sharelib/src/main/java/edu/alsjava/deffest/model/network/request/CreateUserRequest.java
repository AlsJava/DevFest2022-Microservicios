package edu.alsjava.deffest.model.network.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CreateUserRequest {

    @NotBlank
    private String name;
}
