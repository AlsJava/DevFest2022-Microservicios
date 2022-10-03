package edu.alsjava.deffest.model.network.response;

import edu.alsjava.deffest.model.dto.UserDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateUserResponse {

    private UserDto user;
}
