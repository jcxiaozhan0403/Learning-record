const http = require('http');
const fs = require('fs');
const url = require('url');

const server = http.createServer((req,res) => {
    const pathname = url.parse(req.url).pathname;

    if(pathname.substring(1,4)==='img'){
        fs.readFile(pathname.substring(1),function(err,data){
        res.writeHead(200,{'Content-Type':'image/jpg'});
        res.end(data);
    });
    }
});

server.listen(8081,() => {
    console.log("启动成功");
});
