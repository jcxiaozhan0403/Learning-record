### **jQuery的两大特性**
1. 隐式迭代
2. 链式编程

## **原生js的缺点**
1. 只能存在一个入口函数
2. 代码量大，造成代码冗余
3. 存在浏览器兼容问题
4. 容错率低，某一行代码出问题，后面的代码不执行

## **jQuery的优点**
1. 可以有多个入口函数
2. 代码量少，代码简洁
3. 解决了浏览器兼容问题
4. 容错率高，某一行代码出问题，后面的代码依旧执行

## **jQuery是什么**
jQuery是一个封装了很多方法的js库

## **jQuery使用的三大步**
1. 引入jQuery文件
2. 写入口函数
3. 找到元素，操作元素

## **jQuery版本**
压缩版(compressed)：文件小，主要用于发布
未压缩版(uncompressed)：文件较大，主要用于开发、学习

## **原生JS与jQuery**
原生js实在页面所有资源加载完成后才执行
jQuery实在DOM树加载完成时开始执行

## **jQuery的两种入口函数**
```javascript
$(document).ready(function(){

})

$(function(){
    
})
```

## **text方法**
```javascript
//获取文本
text()

//设置文本
text("");
```

## **CSS方法**
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

## **jQuery选择器**
过滤选择器
```javascript
$("li:eq(2)") //li元素中索引为2的元素

$("li:odd") //li元素中索引为奇数的元素

$("li:even") //li元素中索引为偶数的元素
```

## **筛选选择器(方法)**
使用 obj.metch()
```javascript
例：$(".dd").children("ul");           //找到.dd下的带Ul的所有子元素

.eq(index)　　　　//匹配index下标的元素
.first()　　　　　　//获取第一元素
.last()　　　　　　//获取最后一个元素
.find()　　　　　　//后代查找
.parent()　　　　//查找父标签
.siblings()　　　　//兄弟元素
.next()　　　　//下一个兄弟元素
.prev()　　　　//前一个兄弟元素
```

## 鼠标移入移出事件
区别
```
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
// 参数3：可选，移动方式，默认swing(缓动)，可设置linear(匀速)
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
父元素.append()  //添加元素作为最后一个子元素
父元素.prepend()  //添加元素作为第一个子元素
.after() //在被选元素之后插入内容
.before() //在被选元素之前插入内容
```

## 删除元素
```javascript
.remove() //删除被选元素（及其子元素）
.empty() //从被选元素中删除子元素
```