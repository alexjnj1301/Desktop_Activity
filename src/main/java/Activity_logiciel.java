import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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

            ActivityDto activityDto = new ActivityDto();
            activityDto.setName("tennis");
            activityDto.setDuration(240);
            activityDto.setDate(new Date());
            activityDto.setRpe(8);
            activityDto.setCharge(activityDto.getDuration() * activityDto.getRpe());

            log.info("Activity saved {}", activityRepositoryImpl.save(activityDto));
        } catch (Exception e) {
            log.error("An error occurred during connection ==> {}", e);
        }
    }
}
