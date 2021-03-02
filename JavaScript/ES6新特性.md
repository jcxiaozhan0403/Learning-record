## let和const
var定义变量存在的问题
```javascript
// 用var定义变量，系统在进行代码编译时，会将xxx这个变量提升到头部进行声明，所以这里控制台会打印出undefined
console.log(xxx);
var xxx = "Hello World";

// 重复定义相同变量是被允许的，用后面的变量覆盖前面的变量值，这里xxx的值被覆盖，xxx指向demo这个字符串
var xxx = "demo";
```
let和const的使用：默认情况下使用const定义，只有在知道变量值需要改变的情况下使用let定义
```javascript
// 用let定义变量，不会存在变量提升的问题，以为这里控制台没有找到xxx这个变量，所以会直接报错
console.log(xxx);
let xxx = "Hello World";

// let不允许重复定义相同变量，所以这里再次定义xxx会报标识符已被声明的错误
let xxx = "Hello World";
```

## 模板字符串
```javascript
// 在ES5中，复杂字符串要拼接完成
var id = 1;
var str = "<p id =" + id + ">Hello World</p>";

// 在ES6中，模板字符串简化了这一操作
let id2 = 2;
let str2 = `<p id = ${id2}>Hello World</p>`;
```

## 函数
带参函数提供默认值
```javascript
// 给两个形参分别提供了默认值值后，即使不传值，也有返回结果，这里的sum值为20
function add(a = 10,b = 10){
    return a+b;
}

let sum = add();
```
剩余参数和扩展运算符
```javascript
// 传入函数的剩余参数，会被装入一个数组中
function demo(a,...numbers){
    console.log(numbers);
}
demo(1,2,3,5,4,7);

// 扩展运算符：将一个数组分隔，并将各个项作为分离的参数传给函数
const arr = [4,8,1,7,9,2,3,5];
const maxNum = Math.max(...arr);
```
箭头函数
```javascript
// ES5中的匿名函数
function() {}

// ES6中的箭头函数(匿名函数)
() => {}

// 返回值简写
(a,b) => a+b;
(a,b) => ({name:a,age:b})

// 箭头函数中没有this指向，没有arguements对象
```

## 解构赋值
- 解构赋值是对赋值运算符的一种扩展
- 针对数组和对象进行操作
- 简化了代码书写

```javascript
// ES5
var obj = {
    name: "xiaoming",
    age: 18
}

var name = obj.name;
var age = obj.age;

var arr = [1,2,3];
var a = arr[0];
var b = arr[1];
var c = arr[2];

// ES6
let obj = {
    name: "xiaoming",
    age: 18
}

let {name,age} = obj;

const arr = [1,2,3];

let [a,b,c] = arr;
```

## 对象中的属性和方法
```javascript
let obj = {
// 简写属性,等价于name:name
    name,
// 简写方法,等价于demo:function(){}
    demo(){}
}

// 取值
obj[name];

// 设置值
obj[name] = "小明";
```

## 两个对象方法
```javascript
// 比较两个值是否严格相等，等价于 ===
Object.is(123,123);

// 将多个对象结合形成一个新对象，返回值为这个新对象
let obj1 = {
    a: 1,
    b: 2
}

let obj2 = {
    c: 3,
    d: 4
}

let newObj = Object.assign({},obj1,obj2);
```

## Symbol(不常用)
Symbol是原始数据类型，它表示独一无二的值
最大的用途：用来定义对象的私有变量
```javascript
const name = Symbol("name");
let obj = {};
obj[name] = "小明";

// 用Symbol定义的对象中的变量，取值时要用[],不能用.
console.log(obj[name]);
```

## set集合
表示无重复值的有序列表
```javascript
let set = new Set();

// 添加元素
set.add(2);
set.add("Hello World")

// 删除元素
set.delete(2);

// 验证集合中是否存在某值
set.has("Hello World");

// 清空集合
set.clear();

// 集合长度
set.size;

// 将集合转换成数组,利用扩展运算符
let arr = [...set];
```

## Map集合
键值对有序列表，键和值是任意类型
```javascript
let map = new Map();

// 添加元素
map.set("name","张三");
map.set("age",18);

// 删除元素
map.delete("name");

// 获取元素
map.get("age");

// 验证集合中是否存在某值
map.has("name");

//清空集合
map.clear();

// 集合长度
map.size;
```

## 数组的新方法
```javascript
// from将维数组转化为数组
let lis = document.querySelectorAll("li");
let arr = Array.from(lis);

// of将一组值转换成数组
let arr = Array.of(1,2,"3",{num: 5});

// copyWithin()复制数组元素
let arr = [1,2,3,4,5,6];
let newArr = arr.copyWithin(0,3); //用从索引3开始后面所有的值，从索引0开始填充，覆盖数组

// find()找出第一个符合条件的数组成员
let arr = [1,2,3,10,-10,4,5,6];
let num = arr.find(n => n< 0);

// findIndex()找出第一个符合条件的数组成员的索引
let arr = [1,2,3,10,-10,4,5,6];
let numIndex = arr.findIndex(n => n< 0);

// 遍历器
// keys() 对键名遍历
// values() 对值遍历
// entries() 对键值对遍历
let arr = ["a","b"];
for(let index of arr.keys()) {
    console.log(index);
}
for(let ele of arr.values()) {
    console.log(ele);
}
for(let [index,ele] of arr.entries()) {
    console.log(index,ele);
}

// includes() 返回一个布尔值，表示某个数组是否包含给定值
let console.log([1,2,3].includes(2));
```