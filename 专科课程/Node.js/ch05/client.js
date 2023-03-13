const net = require('net');
let client = net.Socket();
client.connect(8234,'127.0.0.1', () => {
    console.log('连接到服务器');
    client.write('我是一个TCP客户端');
});
client.on('data',(data) => {
    console.log('服务器返回的数据：' + data.toString());
});
client.on('end',() => {
    console.log('数据结束');
})