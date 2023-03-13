const express = require('express');
const app = express();
app.get('/',(req,res) => res.send('Hello World!'));
app.listen(3000, () => console.log('示例app监听端口3000！'));