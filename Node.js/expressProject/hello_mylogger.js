const express = require('express');
const app = express();
var myLogger = (req,res,next) => {
    console.log('已记录');
    next();
}
app.use(myLogger);
app.get('/',(req,res) => res.send('Hello World!'));
app.listen(3000);