import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBExample {
    public static void main(String[] args) {
        // Connection URI - use your own if using MongoDB Atlas
        String uri = "mongodb://localhost:27017";
        // String uri = "mongodb+srv://<username>:<password>@<cluster-url>/mydatabase?retryWrites=true&w=majority";

        // Create MongoDB client
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // Access a database
            MongoDatabase database = mongoClient.getDatabase("mydatabase");

            // Access a collection
            MongoCollection<Document> collection = database.getCollection("mycollection");

            // Insert a document
            Document doc = new Document("name", "Alice")
                                .append("age", 25)
                                .append("city", "New York");
            collection.insertOne(doc);

            // Query all documents
            FindIterable<Document> docs = collection.find();
            for (Document d : docs) {
                System.out.println(d.toJson());
            }
        }
    }
}
