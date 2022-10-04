package edu.alsjava.deffest.model.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserDto {

    private UUID id;
    private String name;
}
