const fs = require('fs');
fs.stat("demo.js",(err,stats) => {
    if(err){
        throw err;
    }
    console.log(stats);
    console.log("读取文件成功");

    // 检测文件类型
    console.log("是否为文件(isFile) ?" + (stats.isFile() ? '是':'否'));
    console.log("是否为目录(isDirectory) ?" + (stats.isDirectory() ? '是':'否'));

    // 读取文件属性
    console.log("文件大小：" + stats.size);
    console.log("创建时间：" + stats.birthtime);

    // 分隔符
    console.log("=====================================================");

});

fs.open("demo.js","r",(err,fd) => {
    if(err){
        throw err;
    }
    console.log("打开文件成功!");
    let buf = Buffer.alloc(24); //分配缓冲区
    //读取字节
    fs.read(fd,buf,0,buf.length,0,(err,bytes) => {
        if(err) {
            fs.closeSync(fd);
            return console.log(err);
        }
        console.log("读取字节长度：" + bytes);
        //仅输出读取的字节
        if(bytes > 0) {
            console.log("打开文件后读取buff内容：" + buf.slice(0,bytes).toString());
        }
        // 分隔符
        console.log("=====================================================");
        fs.closeSync(fd); //关闭文件
    });
});

console.log("准备追加文件！");
fs.appendFile("demo.js","这是用于追加文件测试的内容",(err) => {
    if(err) {
        throw err;
    }
    console.log("数据追加成功");
})
