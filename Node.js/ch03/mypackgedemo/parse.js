const cheerio = require('cheerio');
exports.getImg = function(htmldom,callback) {
    let $ = cheerio.load(htmldom);
    $('img').each(function(i,elem) {
        let imSrc = $(this).attr('src');
        callback(imSrc,i);
    });
}