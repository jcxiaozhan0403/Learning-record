const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017';
const dbName = 'testmgdb';

MongoClient.connect(url, {useNewUrlParser: true},function(err, client) {
    if (err) throw err;
    const db = client.db (dbName);
    const coll = db.collection('bookinfo');
    const myobj = {"isbn":"9787115474582","name":"Docker 实践","author":"尹恩·米尔","press":"人民邮电出版社","price":79.00,"pubdate":"2018-02-01"};
    coll.insertOne(myobj, function(err,res){
        if (err) throw err;
        console.log("文档添加成功");
        console.log(res);
        client.close();
    });
});