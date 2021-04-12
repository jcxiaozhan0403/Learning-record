const fs = require('fs');
fs.readFile("demo.json",(err,data) => {
    if(err) {
        throw err;
    }
    let person = JSON.parse(data.toString());

    for(let i = 0;i<person.length;i++){
        console.log("姓名:" + person[i].name + " " + "年龄:" + person[i].age);
    }
})