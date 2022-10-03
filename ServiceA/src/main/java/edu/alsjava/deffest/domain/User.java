package edu.alsjava.deffest.domain;

import edu.alsjava.deffest.model.dto.UserDto;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    @NotNull
    private String name;

    public UserDto toDTO() {
        return UserDto.builder()
                .id(id)
                .name(name)
                .build();
    }
}
