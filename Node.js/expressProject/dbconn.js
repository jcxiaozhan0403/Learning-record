const mysql = require('mysql2');
const pool = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: 'abc123',
    database: 'testmydb',
    dateString: true,
    waitForConnections: true,
    connectionLimit: 10,
    queueLimit: 0
});
// 定义通用的查询接口并将其导出
var query = function(sql,values,callback) {
    pool.getConnection(function(err,conn) {
        if(err) {
            callback(err,null,null);
        }else {
            conn.query(sql,values,function(qerr,results,fields) {
                conn.release(); // 释放连接
                callback(qerr,results,fields); // 事件驱动回调
            });
        }
    });
};
module.exporets=query;