## Node的三大特点
- 非阻塞I/O
- 事件驱动
- 单线程

## Node多版本管理工具
NVM地址
```
https://github.com/coreybutler/nvm-windows/releases
```

常用命令
列出当前电脑所有node版本
```
nvm list
```
显示node是运行在32位还是64位
```
nvm arch
```
显示nvm版本。version可简化为v
```
nvm version
```

## 进程和线程
- 进程
    - 进程负责为程序的运行提供必备的环境
    - 进程就相当于工厂中的车间
- 线程
    - 线程是计算机中的最小的计算单位，线程负责执行进程中的程序
    - 线程就相当于工厂中的工人

node.js是单线程的
node.js的奇数为开发板，偶数为稳定版

node执行外部js文件
```
node demo.js
```

## 模块化
模块的创建
- 在node中，一个js文件就是一个模块
- 在node中，每一个js文伴中的js代码部是独立运行在一个函数中，而不是全局作用域，所以一个模块的中的变量和函数在其他模块中无法访问

模块的引入
- 在node中，通过`require()`函数来引入外部的模块
- `require()`可似传一个文伴的路径作为参数，node将会自动根据该路径来引入外部模块
路径如果使用相对路径，必须以.或..开头
- 我们可以通过`exports`来向外部暴露变量和方法，只需要将需要暴给外部的变量或方法设置为`exports`的属性即可
```js
exports.x = "123";
exports.demo = function() {

}

// 一次暴露多个
module.exports = {
    x = "123",
    demo() {
        
    }
}
```

模块的标识
核心模块的标识就是文件名
```
require("fs")
```
文件模块的标识是文件路径
```
require("./demo")
```

## 创建服务器
```javascript
// 引入HTTP模块
const http = require("http");

// 创建HTTP服务器
const httpServer = http.createServer((req,res) => {
    // 设置响应头
    res.writeHead(200,{"Content-Type" : "text/plain;charset=utf-8"});
    res.end("Hello World 你好世界");
})

// 启动HTTP服务器
httpServer.listen(8080,() => {
    console.log("服务器在8080端口上监听!");
})
```

## 包
包结构
- package.json 描述文件(必须) 注：描述文件内不能写注释
- bin 可执行二进制文件
- lib 外部依赖的一些js代码
- doc 文档
- test 单元测试

自动创建package.json
```
npm init
npm init -y 跳过询问创建
```

## NPM
node包管理工具,node自带

npm命令
```
npm -v 查看npm版本
npm version 查看所有模块版本
npm search 包名 搜索包
npm install / i 包名 安装包(会自动添加到依赖表)
npm remove / r 包名 删除包
npm install 下载当前项目所依赖的包
npm install 包名 -g 全局安装包(全局安装的包一般都是一些工具)
```

安装cnpm
```
npm install cnpm -g --registry=https://registry.npm.taobao.org
```

## Buffer
Buffer（缓冲区）
- Buffer的结构和数组很像，操作的方法也和数组类似
- 数组中不能存二进制的文件，而Buffer就是专门用来存储二进制数据的
- 使用Buffer.不需要引入模块，直接使用即可
- 在Buffer中存储的都是二进制数据，但是在显示时部是以16进制的形式显示
- Buffer中的每一个元素的范围是0-255

```javascript
// 直接放入数据，自动创建Buffer
var str = "Hello";
Buffer.from(str);

// 创建指定长度的Buffer
var buf = Buffer.alloc(20);

// 填充数据
buf[0] = 44;
```

## fs(文件模块)
```javascript
// 引入fs模块
var fs = require("fs");
```

同步文件写入
```javascript
// 打开文件
fs.openSync(path,flags,[mode])
/*
- path 打开文件的路径
- flags 打开文件的操作类型 r或者w
- mode 设置文件的操作权限，一般不传

该方法会返回一个文件的描述符，便于我们操作文件
*/

// 编写文件
fs.writeSync(fd,string,[position],[encoding])
/*
- fd 文件的描述符
- string 要写入的内容
- position 写入的起始位置，一般不传
- encoding 编码，一般不传
*/

// 关闭文件
fs.closeSync(fd);
// fd 文件的描述符
```

异步文件写入
```javascript
// 打开文件
fs.open(path[, flags[, mode]], callback)
/*
- 异步调用的方法，结果都是通过回调函数的参数返回的
- 参数一：err 错误对象，如果没有错误则为null
- 参数二：fd 文件描述符
*/

//Demo
fs.open("hello.txt","w",function(err,fd){
    if(!err) {
        fs.write(fd,"今天天气真好",function(err){
            if(!err) {
                console.log("写入成功");
            }

            fs.close(fd,function(err){
                if(!err) {
                    console.log("文件已关闭");
                }
            });
        });
    }else {
        console.log(err);
    }
})
```

简单文件操作
```javascript
// 引入模块
var fs = require("fs");
// 简单文件写入
fs.writeFile("hello.txt","今天天气真好",function(err) {
    if(!err) {
        console.log("写入成功");
    }
});
// 简单文件读取，data默认是一个buffer对象，用toString()方法可以转换成字符串
fs.readFile("hello.txt","今天天气真好",function(err,data) {
    if(!err) {
        console.log(data);
    }
});
```

文件流操作(操作大文件)
```javascript
// 引入模块
var fs = require("fs");

// 创建输入流
var ws = fs.createWriteStream("hello.txt");
ws.write("今天天气真好");
// 关闭输入流
ws.close();

// 创建输出流
var rs = fs.createReadStream("hello.txt");
// 绑定data事件，自动读取，读取完后自动关闭
rs.on("data",function() {
    console.log(data);
});

// pipe()可以将输出流中的内容，直接输出到输入流中，并完成关闭
rs.pipe(ws);
```

## events模块
```javascript
// 引入 events 模块
var events = require('events');

// 创建 eventEmitter 对象
var eventEmitter = new events.EventEmitter();

// 绑定demo事件的处理函数
eventEmitter.on("demo",demo);

function demo() {
    console.log("事件触发");    
}

// 触发demo事件
eventEmitter.emit('demo');
```

## 全局变量
```javascript
__fileName
__dirName
```
