const express = require('express');
const app = express();
const server = require('http').Server(app);
//通过中间件函数托管静态文件
app.use(express.static('static'));
//显示网页客户端文件index.html
app.get('/', function(req, res){
  res.sendFile(__dirname + '/index.html');
});
server.listen(8000, function(){
  console.log('侦听端口 *:8000');
});

//创建socket.io实例
const io = require("socket.io")(server);
//当有连接打开时
io.on('connection', (socket) => {
	console.log('有新用户接入！');
	//设置默认用户名
	socket.username = "匿名";
    //侦听到change_username事件就实时修改用户名
    socket.on('change_username', (data) => {
        socket.username = data.username;
    });

    //侦听到new_message事件就广播客户端发送的新消息
    socket.on('new_message', (data) => {
        io.sockets.emit('new_message', {message : data.message, username : socket.username});
    });
    
});