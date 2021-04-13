const fs = require('fs');
let newobj = {"name":"刘强","age":21};
fs.readFile("demo.json",(err,data) => {
    if(err) {
        throw err;
    }
    let person = JSON.parse(data.toString());

    for(let i = 0;i<person.length;i++){
        console.log("姓名:" + person[i].name + " " + "年龄:" + person[i].age);
    }

    person.push(newobj);

    let str = JSON.stringify(person);
    fs.writeFile('demo.json',str,(err) => {
        if(err) {
            throw err;
        } 
        console.log("数据写入成功！");
    });

    for(let j = 0;j<person.length;j++){
        if(person[j].name == '张红') {
            person[j].age = 22;
            break;
        }
    }

    let str2 = JSON.stringify(person);
});