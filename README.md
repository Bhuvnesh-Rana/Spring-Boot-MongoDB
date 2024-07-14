## MongoDB
1. open cmd write mongosh.
2. show dbs.
3. use databaseName
4. show collections
5. db.createCollection('collectionName')
6. db.collectionName.insertOne({ name: "Alice", age: 25 })  OR db.collectionName.insertMany([{ name: "Bob", age: 30 }, { name: "Charlie", age: 35 }])
7. db.collectionName.find()  OR db.collectionName.find()
8. db.collectionName.updateOne({ name: "Alice" }, { $set: { age: 26 } })  OR  db.collectionName.updateMany({ age: { $lt: 30 } }, { $inc: { age: 1 } })
9. db.collectionName.deleteOne({ name: "Charlie" })  OR  db.collectionName.deleteOne({ name: "Charlie" })







