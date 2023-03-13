// 引入HTTP模块
const http = require("http");

// 创建HTTP服务器
const httpServer = http.createServer((req,res) => {
    // 设置响应头
    res.writeHead(200,{"Content-Type" : "text/html;charset=utf-8"});
    const info = `<h1>李爽</h1><h2>19604076</h2>`;
    res.write(info);
    res.end();
})

// 启动HTTP服务器
httpServer.listen(8989,() => {
    console.log("服务器在8989端口上监听!");
})