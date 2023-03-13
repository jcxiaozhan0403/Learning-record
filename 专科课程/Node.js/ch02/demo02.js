const buf1 = Buffer.alloc(11);
const rs = buf1.write("Hello World",0);
const buf2 = Buffer.from("我是一个中国人");
const buf3 = Buffer.concat([buf1,buf2]);
const buf4 = buf2.slice(12);
console.log(buf3.toString());

buf2.copy(buf1,2);
console.log(buf1.toString());
console.log(buf4.toString());