const request = require('request');
const path = require('path');
const fs = require('fs');
const parse = require('./parse');
const workUrl = 'https://pic.netbian.com/tupian/25331.html';
const imgDir = path.join(__dirname,'downimages');

function downImg(imgUrl,i) {
    if(imgUrl) {
        console.log(imgUrl);
        let ext = imgUrl.split('.').pop();
        request.get(imgUrl).pipe(fs.createWriteStream(path.join(imgDir,i+'.'+ext),{'encoding':'utf8'}));
    }
}

request(workUrl,function(err,res,body){
    if(!err && res){
        console.log('start');
        parse.getImg(body,downImg);
        console.log('done');
    }else{
        console.log('error');
    }
})