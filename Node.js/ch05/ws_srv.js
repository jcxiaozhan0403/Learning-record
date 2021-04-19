const WebSoket = require('ws');
const wss = new WebSoket.Server({port:8080});
console.log('服务正在8080端口上监听');
wss.on('connection',function connection(ws){
    ws.on('message',function incoming(message){
        console.log('收到:%s',message);
        ws.send(message);
    });
});