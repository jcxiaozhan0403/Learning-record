var Student = require('./hello');
let student = new Student("张三","男",60);
student.logInfo();
student.changeName("李四");
student.logInfo();
console.log(student.testScore());