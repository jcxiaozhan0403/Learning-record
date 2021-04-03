const path = require('path');
const url = require('url');
const myUrl = url.parse("https://www.baidu.com/");
const myPath = "D:/Study//Learning-record/Node.js/ch05";


console.log(path.delimiter);
console.log(path.sep);
console.log(path.normalize(myPath));
console.log(path.join("/Study","Learning-record","/Node.js","ch05",".."));
console.log(path.extname("pathAndUrl.js"));
console.log(myUrl.protocol);
console.log(myUrl.host);
console.log(myUrl.pathname);
console.log(myUrl.search);