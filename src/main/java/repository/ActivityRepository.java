package repository;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import models.ActivityDto;

import java.util.List;

public interface ActivityRepository {
    InsertOneResult save(ActivityDto activityDto);
    List<ActivityDto> getAll();
    DeleteResult deleteOne(String name);
    DeleteResult deleteMany(String name);
}
