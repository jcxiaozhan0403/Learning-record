const fs = require('fs');
const readStream = fs.createReadStream('demo.txt');
const writerStream = fs.createWriteStream('output.txt');
let str = "";
let data = "Hello World";

writerStream.write(data);

readStream.on('data',(chunk) => {
    str+=chunk;
});

readStream.on('end',(chunk) => {
    console.log(str);
});

readStream.on('error',(err) => {
    console.log(err);
});

writerStream.on('finish',(data) => {
    console.log("完成");
});

writerStream.on('error',(err) => {
    console.log(err);
})
