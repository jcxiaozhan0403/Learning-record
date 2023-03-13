    async function getData(){
        const mysql = require('mysql2/promise');
        const pool = mysql.createPool({ user: 'root',password: 'lishuang001219',database: 'testmydb',});
        var results = await Promise.all([pool.query('SELECT * FROM `bookinfo`')]);
        await pool.end();
        return results;
    };
    getData().then(data => {
        console.log(data[0]);
    }).catch(error => {
        console.log(error);
    })
