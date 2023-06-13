import com.mongodb.client.MongoCollection;
import lombok.extern.slf4j.Slf4j;
import models.ActivityDto;
import org.bson.Document;
import repository.ActivityRepositoryImpl;

import java.util.Date;

@Slf4j
public class Activity_logiciel {
    public static void main(String[] args) {
        try {
            MongoCollection<Document> activityCollection = Connection.connect("myActivities", "activities");
            ActivityRepositoryImpl activityRepositoryImpl = new ActivityRepositoryImpl(activityCollection);

            //addActivity(activityRepositoryImpl);
            //readActivity(activityRepositoryImpl);
            //deleteActivity(activityRepositoryImpl);
            deleteActivities(activityRepositoryImpl);

        } catch (Exception e) {
            log.error("An error occurred during connection ==> {}", e);
        }
    }

    private static void addActivity(ActivityRepositoryImpl activityRepositoryImpl) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setName("tennis");
        activityDto.setDuration(240);
        activityDto.setDate(new Date());
        activityDto.setRpe(8);
        activityDto.setCharge(activityDto.getDuration() * activityDto.getRpe());

        log.info("Activity saved {}", activityRepositoryImpl.save(activityDto));
    }

    private static void readActivity(ActivityRepositoryImpl activityRepositoryImpl) {
        log.info("All activities: {}", activityRepositoryImpl.getAll());
    }

    private static void deleteActivity(ActivityRepositoryImpl activityRepositoryImpl) {
        log.info("Activity deleted {}", activityRepositoryImpl.deleteOne("Course"));
    }

    private static void deleteActivities(ActivityRepositoryImpl activityRepositoryImpl) {
        log.info("Activities deleted {}", activityRepositoryImpl.deleteMany("tennis"));
    }
}
