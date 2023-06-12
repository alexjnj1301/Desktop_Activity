package mappers;

import lombok.extern.slf4j.Slf4j;
import models.ActivityDto;
import org.bson.Document;


@Slf4j
public class ActivityMapper {
    public static Document activityToDocument(ActivityDto activityDto) {
        return new Document()
                .append("name", activityDto.getName())
                .append("duration", activityDto.getDuration())
                .append("date", activityDto.getDate())
                .append("rpe", activityDto.getRpe())
                .append("charge", activityDto.getCharge());
    }
}