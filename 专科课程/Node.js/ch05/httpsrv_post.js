const http = require('http');
const querystring = require('querystring');
let server = http.createServer((req,res) => {
    let data = '';
    req.on('data',(chunk) => {
        data += chunk;
    });
    req.on('end',() => {
        data = decodeURI(data);
        console.log(data);
        let dataObj = querystring.parse(data);
        console.log(dataObj);
        if(dataObj.name == '李爽'){
            res.end(dataObj.name + '学号：19604076');
        }else{
            res.end('查询失败');
        }
    });
}).listen(8080);