package repository;

import com.mongodb.client.result.InsertOneResult;
import models.ActivityDto;

public interface ActivityRepository {
    InsertOneResult save(ActivityDto activityDto);
}
