var express = require("express");
var app = express();
var router = express.Router();
var MongoClient = require('mongodb').MongoClient;
var DataBaseURL = "mongodb://localhost:27017/hackHersDB";

MongoClient.connect(DataBaseURL, function(err,db) {
    if (err) throw err;
    console.log("Database " + DataBaseURL + " created!");
    db.close();
});

// middle ware for express api
router.use(function(req, res, next) {
    // do logging
    console.log('request sent.');
    next(); // make sure we go to the next routes and don't stop here
});


router.post('/posts',function(req,res){
    MongoClient.connect(DataBaseURL, function(err,client){
        if (err) throw err;
        const dataBase = client.db('hackHersDB');
        dataBase.collection('posts',function(err,collection){
            collection.insert({message: "this is a test"}); // replace message key with  actual data to store 
        });
    });
    res.json({message: "data uploaded."});
});

router.get('/posts', function(req,res){
    MongoClient.connect(DataBaseURL, function(err,client){
        const db = client.db("hackHersDB");
        db.collection('posts',function(err,collection){
            collection.find().toArray(function(err, items){
                if (err) throw err;
                console.log(items);
                res.json({
                    post_data: items
                });
            });
        });
    });
});

app.use('/api/v1/',router);
app.listen(8080);
console.log("api running on port 8080");
