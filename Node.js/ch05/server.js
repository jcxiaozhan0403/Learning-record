const net = require('net');
let clientNo = 0;
const server = net.createServer((client) => {
    clientNo++;
    console.log(clientNo + "号客户端已连接");
    client.on('end',() => {
        console.log(clientNo + "号客户端已断开连接");
    });
    client.write(clientNo + "号客户端，你好 \r\n");
    client.pipe(client);
    client.on('data',(data) => {
        console.log(clientNo + '号客户端发来的数据：' + data.toString());
    });
});
server.on('error',(err) => {
    throw err;
});
server.listen(8234,() => {
    console.log('TCP服务器已启动');
});