# needed packages  
# 1.   pip install pymongo 

from pymongo import MongoClient

# Connect to MongoDB running on localhost at port 27017
client = MongoClient("mongodb://localhost:27017/")

# for online atlas database
# # Replace <username>, <password>, and <cluster-url> with your actual credentials
# uri = "mongodb+srv://<username>:<password>@<cluster-url>/test?retryWrites=true&w=majority"
# client = MongoClient(uri)

# Create/use a database
db = client["mydatabase"]

# Create/use a collection
collection = db["mycollection"]

# Example: Insert a document
doc = {"name": "Alice", "age": 25}
collection.insert_one(doc)

# Example: Fetch documents
for document in collection.find():
    print(document)
