var http = require('http');
var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";
 
MongoClient.connect(url, function(err, db) {
    if (err) throw err;
    var dbo = db.db("testmgdb");
    dbo.collection("bookinfo"). find({}).toArray(function(err, result) { // 返回集合中所有数据
        if (err) throw err;
        console.log(result);
        http.createServer(function (request, response) {
            response.writeHead(200, { 'Content-Type': 'text-plain' });
            response.end(result.toString);
        }).listen(8080);
        db.close();
    });
});