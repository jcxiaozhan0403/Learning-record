const http = require('http');
const options = {
    hostname: '127.0.0.1',
    port: 8081,
    method: 'Post',
};

const req = http.request(options, (res) => {
    res.setEncoding('utf8');
    res.on('data',(chunk) => {
        console.log(chunk.toString());
    });
});