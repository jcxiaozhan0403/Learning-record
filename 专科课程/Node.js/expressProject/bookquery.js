const query = require("./dbconn.js");

//返回所有记录
exports.getall = function(callback) {
    query('SELECT * FROM `bookinfo`',function(err,results,fields) {
        if (err) {
            console.log('数据库查询失败');
            throw err;
        }
        callback(results);
    });
}
// 返回指定记录值
exports.get = function(bookid,callback) {
    var arr = [];
    arr.push(bookid);
    query('SELECT * FROM `bookinfo` WHERE `id` = ?',arr,function(err,results,fields) {
        if (err) {
            console.log('数据查询失败');
            throw err;
        }
        callback(results);
    });
}

// 增加一条记录
exports.add = function(rec,callback) {
    var addSql = 'INSERT INFO `bookinfo` (`isbn`,`name`,`author`,`press`,`price`,`pubdate`) VALUES(?,?,?,?,?,?)';
    query(addSql,rec,function(err,results,fields) {
        if (err) {
            console.log('[插入记录错误] - ',err.message);
            throw err;
        }
        callback(results);
    });
}

// 修改一条记录
exports.update = function(bookid,keys,values,callback) {
    var updateSql = 'UPDATE `bookinfo` SET';
    console.log(keys);
    for (let i = 0; i < keys.length; i++) {
        if(i == keys.length -1) {
            updateSql += keys[i] + '= ?';
        }else {
            updateSql += keys[i] + '= ?,';
        }
        
    }
    updateSql +='WHERE id = ?';
    values.push(bookid);
    query(updateSql,values,function(err,results,fields) {
        if (err) {
            console.log('[修改记录错误] - ',err.message);
            throw err;
        }
        callback(results);
    });
};

// 删除一条记录值
exports.del = function(bookid,callback) {
    var arr = [];
    arr.push(bookid);
    var delSql = 'DELETE FROM bookinfo WHERE `id` = ?';
    query(delSql,arr,function(err,results,fields) {
        if (err) {
            console.log('[删除记录错误] - ',err.message);
            throw err;
        }
        callback(results);
    });
}