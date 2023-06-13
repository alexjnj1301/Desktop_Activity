package models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    String name;
    String firstname;
    LocalDateTime birthdate;
    String sexe;
}
