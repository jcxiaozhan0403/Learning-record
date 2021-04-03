const os = require('os');
const util = require('util');
const path = require('path');
const url = require('url');
console.log(os.type());
console.log(os.platform());
console.log(os.totalmem());
console.log(os.freemem());
console.log(os.cpus());

let obj = {
    "name" : "小明",
    "age" : 18
}

console.log(util.format("%o",obj));
console.log(obj);