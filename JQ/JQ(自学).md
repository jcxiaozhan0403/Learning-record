### jQuery的两大特性
1. 隐式迭代
2. 链式编程

## 原生js的缺点
1. 只能存在一个入口函数
2. 代码量大，造成代码冗余
3. 存在浏览器兼容问题
4. 容错率低，某一行代码出问题，后面的代码不执行

## jQuery的优点
1. 可以有多个入口函数
2. 代码量少，代码简洁
3. 解决了浏览器兼容问题
4. 容错率高，某一行代码出问题，后面的代码依旧执行

## jQuery是什么
jQuery是一个封装了很多方法的js库

## jQuery使用的三大步
1. 引入jQuery文件
2. 写入口函数
3. 找到元素，操作元素

## jQuery版本
压缩版(compressed)：文件小，主要用于发布
未压缩版(uncompressed)：文件较大，主要用于开发、学习

## 原生JS与jQuery

原生js实在页面所有资源加载完成后才执行
jQuery实在DOM树加载完成时开始执行

## jQuery的两种入口函数
```javascript
$(document).ready(function(){

})

$(function(){
    
})
```

## DOM对象和JQ对象之间的转换
DOM ==> JQ
```javascript
// 用工厂函数包裹

var div = document.getElementById("div");
var $div = $(div)
```

JQ ==> DOM
```javascript
// 用下标取出

var $divs = $("div");
var div1 = $divs[0];

// 使用get()方法

var $divs = $("div");
var div2 = $divs.get(1);
```

## text方法
```javascript
//获取文本
text()

//设置文本
text("");
```

## CSS方法
```javascript
//获取样式
css("样式名")

//设置单样式
css("样式名","样式值")

//设置多样式
css({
    //JSON键值对格式
    "height" : "200px",
    "width" : "200px"
})
```

## 基本选择器

```javascript
//id选择器
$("#idOne").css("backgroundColor","red");

//元素选择器
$("div").css("backgroundColor","green");

//类选择器
$(".classTow").css("backgroundColor","red");

//并集
$("#idOne,classTow").css("backgroundColor","red");
```

## 层次选择器

```javascript
//子代选择器
$("ul>li").css("backgroundColor","red");

//后代选择器
$("ul p").css("backgroundColor","red");
```

## 过滤选择器

```javascript
$("li:eq(2)") //li元素中索引为2的元素

$("li:odd") //li元素中索引为奇数的元素

$("li:even") //li元素中索引为偶数的元素
```

## 筛选选择器(方法)
使用 obj.metch()
```javascript
$("ul").children("li"); //找子代
$("ul").find("li"); //找后代
$("ul").siblings("li"); //找兄弟
$("ul").parent("li"); //找父亲
$("ul").eq(0); //找索引
$("ul").prev("li"); //找上一个兄弟
$("ul").next("li"); //找下一个兄弟
.first()　　　　　　//获取第一元素
.last()　　　　　　//获取最后一个元素
```

## 鼠标移入移出事件
区别
```javascript
mouseover与mouseout  //事件在鼠标移动选取的元素及其子元素上触发
mouseenter与mouseleave  //事件只在鼠标移动到选取的元素上触发
hover(function(){},function(){}) //同时写移入移出
```

## class操作
```javascript
//添加单个类
addClass("xxx");

//添加多个类
addClass("xxx xx");

//移除单个类
removeClass("xxx");

//移除多个类
removeClass("xxx xx");

//移除所有类
removeClass();

//判断类(返回true或者false)
hasClass("xx");

//切换类(如果元素有此类就删除，没有就添加)
toggleClass("xx");
```

## 三组基本动画
1. show()、hide()、toggle() //隐藏与现实
```javascript
show(2000,function(){

})
```
2. slideDown()、slideUP()、slideToggle() //卷帘门上下
```javascript
slideDown(2000,function(){

})
```
3. fadeIn()、fadeOut()、fadeToggle()、fadeTo() //淡入与淡出
```javascript
fadeIn(2000,function(){

})

fadeTo(2000,0.5)
```

## 自定义动画
```javascript
animate()
// 参数1：必选，对象，代表要做动画的属性
// 参数2：可选，代表动画时长
// 参数3：可选，移动方式，默认swing(缓动)(默认)，可设置linear(匀速)
// 参数4：可选，回调函数
```

## 停止动画
```javascript
stop()
// 参数1：是否清除队列
// 参数2：是否跳转到最终效果
//stop()不给参数默认为stop(false,false)
```

## 获取html节点
```javascript
html() //获取子元素内容

html("xxxxx");//覆盖子元素和内容，也可用于创建标签

$("xxxx") //$()创建的元素指存放在内存中，不显示到页面端，要显示要用append方法追加

append($("xxxxx"))
```

## 添加元素
```javascript
//添加元素作为最后一个子元素

父元素.append()
子元素.appendTo()

//添加元素作为第一个子元素

父元素.prepend()

.after() //在被选元素之后插入内容
.before() //在被选元素之前插入内容
```

## 删除元素
```javascript
.remove() //移除节点
.empty() //清空节点
```

## 克隆元素
```javascript
.clone() //复制但不复制事件
.clone(true) //复制元素及其事件

//注：克隆的元素指存放在内存中，不显示到页面端，要显示要用方法添加
```

## 操作元素属性
```javascript
//设置单个属性
attr("属性名","属性值")

//设置多个属性
attr({
    //JSON键值对格式
    "src" : "aaa",
    "title" : "xxx"
})

//获取属性
attr("属性名")

//移除单个属性
removeAttr("属性名")

//移除多个属性
removeAttr("xxx xx xxx")

//布尔类型属性
prop()
```

## 宽高
```javascript
width() //获取宽，只含数字
height() //获取高，只含数字

width(100) //设置宽
height(100) //设置高

innerWidth() //获取宽+内边距
innerHeight() //获取高+内边距

outerWidth() //获取宽+内边距+边框
outerHeight() //获取高+内边距+边框

outerWidth(true) //获取宽+内边距+边框+外边距
outerHeight(true) //获取高+内边距+边框+外边距

$(window).width() //获取页面可视区宽
$(window).height() //获取页面可视区高
```

## 获取定位
```javascript
offset() //获取到一个对象，对象包含top和left，是元素距离document的位置

position() //获取到一个对象，对象包含top和left，是元素距离上一个定位元素的位置
```

## 滚动条
```javascript
scrollLeft() //返回被选元素的水平滚动条位置
scrollLeft(100) //设置被选元素的水平滚动条位置

scrollTop() //返回被选元素的垂直滚动条位置
scrollTop(100) //设置被选元素的垂直滚动条位置
```

## on事件注册
```javascript
// 简单注册，不支持动态注册(事件对新元素不生效)
on("事件名",function(){

});

// 委托注册，支持动态注册(事件对新元素生效)
$("父元素").on("事件名","子元素",function(){
    
});
```

## off事件解绑
```javascript
off(); //不给参数，解绑所有事件

off("click"); //给参数，解绑指定事件
```

## trigger事件
```javascript
trigger("自定义事件名") //trigger是个触发器，用于触发自定义的事件
```

## 事件对象
当我们在触发一个事件时，系统会自动生成一个对象，用于存放事件触发时的一些状态信息，可以用事件参数e来获取

## 坐标属性
```javascript
screenX和screenY //触发点到屏幕的距离
clientX和clientY //触发点到视窗的距离
pageX和pageY //触发点到文档边缘的固定距离
```

## 事件行为
```javascript
event.stopPropagation(); // 阻止事件冒泡，不阻止默认行为  事件冒泡：子元素的单击事件会传递到上级，连环触发，称为冒泡

event.preventDefault(); // 不阻止事件冒泡，阻止默认行为

return false; // 同时阻止默认行为和冒泡

event.keyCode; // 获取键值

end(); // 回到上一个状态，操作返回值
```

## 显示迭代
```javascript
each(function(){

});
```

## 查看JQ版本
```javascript
console.log(jQuery.fn.jquery);

console.log(jQuery.prototype.jquery);

console.log($.fn.jquery);

console.log($.fn.jquery);
```

## 多库共存
```javascript
// 一次引入多个JQ文件,$属于最后一个引入的文件
<script src="./jquery-3.0.0.min.js"></script>
<script src="./jquery-3.5.1.min.js"></script>
//此时$属于3.5.1文件

// 要想使用其他文件的$，必须释放当前$的控制权
$.noConflict();

// 创建一个新变量来保存当前$，一般以_$打头，以便随时调用，实现多库共存
var _$001 = $.noConflict();
```

## PHP基础语法
```php
<?php
// 定义变量
$abc = "xxx";

// 定义数组
$abc = array(1,2,3);

// 定义对象
$abc = array("name"=>"john","age"=>18);

// 打印一般内容
echo xxx;
echo $abc["name"];
// 打印对象或数组
print_r(xxx);

// php接收请求,接收的数据会保存在一个对象中
$_GET
$_POST

?>
```

## Ajax

## 遍历
> jQuery 遍历，意为"移动"，用于根据其相对于其他元素的关系来"查找"（或选取）HTML 元素。以某项选择开始，并沿着这个选择移动，直到抵达您期望的元素为止。

```javascript
.parent() //返回直接父元素
.parents() //返回所有的祖先元素
内层元素.parentsUntil(外层元素) //返回介于两个给定元素之间的所有祖先元素
.children() //返回被选元素的所有直接子元素
.find() //返回被选元素的后代元素，一路向下直到最后一个后代
.siblings() //返回被选元素的所有兄弟元素
.next() //返回被选元素的下一个兄弟元素
.nextAll() //返回被选元素之后的所有兄弟元素
.nextUntil() //返回介于两个给定参数之间的所有跟随的兄弟元素
.prev() //返回被选元素的上一个兄弟元素
.prevAll() //返回被选元素之前的所有兄弟元素
.prevUntil() //返回介于两个给定参数之间的所有跟随的兄弟元素
.filter() //括号中填写一个标准，符合的元素返回
.not() //括号中填写一个标准，不符合的元素返回
```

## Ajax
```javascript
.load(URL,data,callback);
// 必需的 URL 参数规定您希望加载的 URL
//可选的 data 参数规定与请求一同发送的查询字符串键/值对集合
//可选的 callback 参数是 load() 方法完成后所执行的函数名称
```