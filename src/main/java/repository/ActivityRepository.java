package repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import models.ActivityDto;
import org.bson.Document;

import java.util.List;

public interface ActivityRepository {
    InsertOneResult save(ActivityDto activityDto);
    List<ActivityDto> getAll();
}
