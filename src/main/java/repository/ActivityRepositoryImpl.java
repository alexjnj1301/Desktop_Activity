package repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import models.ActivityDto;
import org.bson.Document;

import static mappers.ActivityMapper.activityToDocument;

public class ActivityRepositoryImpl implements ActivityRepository {
    MongoCollection<Document> collection;
    public ActivityRepositoryImpl(MongoCollection<Document> collection){
        this.collection = collection;
    }
    @Override
    public InsertOneResult save(ActivityDto activityDto) {
        return this.collection.insertOne(activityToDocument(activityDto));
    }
}
