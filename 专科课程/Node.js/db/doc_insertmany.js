const { Db } = require("mongodb");

const myobj = [
    {"isbn":"9787115474582","name":"Docker 实践","author":"尹恩·米尔","press":"人民邮电出版社","price":79.00,"pubdate":"2018-02-01"},
    {"isbn":"9787115373557","name":"数学之美","author":"吴军","press":"人民邮电出版社","price":49.00,"pubdate":"2014-11-01"}
];
db.collection('bookinfo').insertMany(myobj, function(err,res){
    if (err) throw err;
    console.log("插入的文档数为：" + res.insertredCount);
});