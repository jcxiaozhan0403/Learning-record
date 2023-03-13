const fs = require("fs");

fs.readFile("demo.txt",(err,data) => {
    if(!err) {
        console.log(data.toString());
    }
});

console.log(__filename);
console.log(__dirname);