const fs = require('fs');
const zlib = require('zlib');
const r = fs.createReadStream('demo.txt');
const w = fs.createWriteStream('output.txt');
// 读取 demo.txt 文件内容，并将内容写入到 output.txt 文件中
const z = r.pipe(w);