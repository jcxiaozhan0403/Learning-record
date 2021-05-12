// 引入HTTP模块
const http = require("http");
const config = require("./config").config;

// 创建HTTP服务器
const httpServer = http.createServer((req,res) => {
    // 设置响应头
    res.writeHead(200,{"Content-Type" : "text/plain;charset=utf-8"});
    res.end("Hello World 你好世界");
})

// 启动HTTP服务器
httpServer.listen(8080,'127.0.0.1',() => {
    console.log("服务器在8080端口上监听!");
    console.log(config.port);
})