import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

@Slf4j
public class Connection {
    public static MongoCollection<Document> connect(String databaseName, String collectionName) {
        try {
            String connectionString = "mongodb+srv://alex_jnj13:VbYXJiztuURLmhKY@app-de-test.ssynvdw.mongodb.net/?retryWrites=true&w=majority";
            MongoClient mongoClient = MongoClients.create(connectionString);
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> activityCollection = database.getCollection(collectionName);
            log.info("Database connection successful");
            return activityCollection;
        } catch (Exception e) {
            log.error("An error occurred during connection ==> {}", e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
