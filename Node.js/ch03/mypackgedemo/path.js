const cheerio = require('cheerio');
exports.getImg = (htmldom,callback) => {
    let $ = cheerio.load(htmldom); //装载网页
    $('img').each((i,elem) => {
        let imgSrc = $(this).attr('src'); //得到图片网址
        callback(imgSrc,i) //调用回调处理图片网址
    })
}