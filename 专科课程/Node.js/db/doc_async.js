const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017';
const dbName ='testmgdb';//数据库名称
const collName=' bookinfo';//集合名称

async function getConnect() {
    try {
        let connect = await MongoClient.connect(url,{useNewUrlParser: true});
        return connect;
    } catch (err) {
        throw err;
    }
}

async function getBookInfo() {//声明查询操作的 async函数
    //“顺序”执行以下步骤
    let connect = await getConnect();//执行建立连接的 async函数
    let coll= connect.db(dbName).collection(collName);//得到集合对象
    let result= await coll.find({}).toArray();//查询文档
    connect.close();//关闭连接
    return result;//返回查询结果(这是 remise对象)
}

getBookInfo().then(data => {
    console.log("查询的数据：",JSON.stringify(data,null,4));//获取返回的内容
}).catch(error => {
    console.log(error);
});