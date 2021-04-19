const WebSoket = require('ws');
const ws = new WebSoket('ws://localhost:8080');
ws.on('open',function open(){
    console.log('已连接服务器');
    ws.send(Date.now());
});
ws.on('close',function close(){
    console.log('连接已断开');
});
ws.on('message',function incoming(data){
    console.log(`往返延时:${Date.now() - data} ms`);
    setTimeout(function timeout(){
        ws.send(Date.now());
    },1000);
});