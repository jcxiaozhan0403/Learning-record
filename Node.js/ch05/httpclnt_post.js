const http = require('http');
const querystring = require('querystring');
const postData = querystring.stringify({
    'name':'李爽',
});
const options = {
    hostname: '127.0.0.1',
    port: 8080,
    method: 'Post',
};

const req = http.request(options, (res) => {
    res.setEncoding('utf8');
    res.on('data',(chunk) => {
        console.log(chunk.toString());
    });
});
req.write(postData);
req.end();