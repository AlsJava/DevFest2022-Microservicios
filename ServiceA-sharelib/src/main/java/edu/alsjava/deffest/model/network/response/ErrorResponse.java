package edu.alsjava.deffest.model.network.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ErrorResponse {

    private Long errorCode;
    private String description;
}
