const http = require('http');
const fs = require('fs');
const { fstat } = require('node:fs');
const httpServer = http.createServer((req,res) => {
    res.setHeader('Content-Type','text/html');
    fs.readFile('./demo.html',(err,data) => {
        if(err){
            console.log(err);
            res.end();
        }else{
            res.write(data);
            res.end();
        }
    })
});

httpServer.listen(8081,() => {
    console.log("启动成功");
})