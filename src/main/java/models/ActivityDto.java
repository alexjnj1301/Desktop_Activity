package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ActivityDto {
    String name;
    int duration; // in minutes
    Date date;
    int rpe; // ressenti post-effort (1 à 10)
    int charge; // RPE * duration
}
