package mappers;

import lombok.extern.slf4j.Slf4j;
import models.ActivityDto;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


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

    public static ActivityDto documentToActivity(Document document) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setName(document.getString("name"));
        activityDto.setDuration(document.getInteger("duration"));
        activityDto.setDate(document.getDate("date"));
        activityDto.setRpe(document.getInteger("rpe"));
        activityDto.setCharge(document.getInteger("charge"));
        return activityDto;
    }
}