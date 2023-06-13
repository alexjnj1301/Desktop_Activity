package repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import models.ActivityDto;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static mappers.ActivityMapper.activityToDocument;
import static mappers.ActivityMapper.documentToActivity;

public class ActivityRepositoryImpl implements ActivityRepository {
    MongoCollection<Document> collection;
    public ActivityRepositoryImpl(MongoCollection<Document> collection){
        this.collection = collection;
    }
    @Override
    public InsertOneResult save(ActivityDto activityDto) {
        return this.collection.insertOne(activityToDocument(activityDto));
    }

    @Override
    public List<ActivityDto> getAll() {
        List<ActivityDto> activities = new ArrayList<>();
        for (Document document : this.collection.find()) {
            activities.add(documentToActivity(document));
        }
        return activities;
    }

    @Override
    public DeleteResult deleteOne(String name) {
        return this.collection.deleteOne(new Document("name", name));
    }

    @Override
    public DeleteResult deleteMany(String name) {
        return this.collection.deleteMany(new Document("name", name));
    }
}
