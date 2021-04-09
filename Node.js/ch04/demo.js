const fs = require('fs');
fs.unlink('./demo.png',(err) => {
    if(err){
        console.log(err);
    }
    console.log("删除图便成功");
});


try {
    fs.unlinkSync("./demo.txt");
    console.log("文本删除成功");
} catch (err) {
    console.log(err);
}