const express = require('express');
const app = express();
var requesrTime = function(req,res,next) {
    req.requesrTime = Date.now();
    next();
}
app.use(requesrTime);
app.get('/',function (req,res) {
    var responseText = 'Hello World!<br>';
    responseText += '<small>请求时间：' + req.requesrTime + '</small>';
    res.send(responseText)
});
app.listen(3000);