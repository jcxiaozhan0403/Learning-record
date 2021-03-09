const events = require('events');

const eventEmitter = new events.EventEmitter();

eventEmitter.addListener('seen',(who) => {
    console.log('报告,来人是一位' + who);
})

eventEmitter.on('seen',() => {
    console.log('欢迎光临');
})

eventEmitter.emit('seen','女生');

eventEmitter.on('error',(err) => {
    console.log(err);
})

eventEmitter.emit('');