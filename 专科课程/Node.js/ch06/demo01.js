const pool = require('mysql2/promise').createPool({
    user: 'root',
    password: 'lishuang001219',
    database: 'testmydb',
});
pool.getConnection()
    .then(conn => {
        const res = conn.query('SELECT * FROM `bookinfo`');
        conn.release();
        return res;
    }).then(result => {
        console.log(result);
    }).catch(err => {
        console.log(err);
    });