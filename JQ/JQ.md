**闭卷笔试、64课时**

## jQuery对象和DOM对象
```javascript
var xx = document.getElementById("xx"); //DOM对象

$(xx) //将DOM对象变为JQ对象

var xx = $(xx)[0] //将JQ对象变为DOM对象

```

## jQ插件
```
Validate 表单验证
Treeview 无序灵活可折叠树形菜单
Uploadify 文件上传
Echarts 强大图像处理
Pagination 数据分页
```

## 基本选择器
```
ID选择器
元素选择器
类选择器
复合选择器
```

```javascript
$("#idOne").css("backgroundColor","red");
$("div").css("backgroundColor","green");
$("div").css("height","200px");
$(".classTow").css("backgroundColor","red");
$("#idOne,classTow").css("backgroundColor","red");
```

## 层次选择器
```
后代选择器
子选择器
next选择器
nextAll选择器
```
```javascript
$("div p").css("backgroundColor","red"); //后代p
$("div > p").css("backgroundColor","red"); //子p
$("div + p").css("backgroundColor","red"); //div的下一个同级p
$("div ~ p").css("backgroundColor","red"); //div的后续所有同级p
```
## 过滤选择器
```javascript
:first //第一个元素
:header //标题标签
:last //最后一元素
:not() //不是...
:eq //下标等于
:gt //下表大于
:lt //下标小于
:odd //奇数行
:even //偶数行
```
```javascript
$(":header").css("backgroundColor","red"); //标题标签
$("p:first").css("backgroundColor","red"); //第一个p
$("p:eq(0)").css("backgroundColor","red"); //下标为0的p
$("p:gt(0)").css("backgroundColor","red"); //下标大于0的p
$("p:lt(1)").css("backgroundColor","red"); //下标小于1的p
```

```javascript
$("ul li:nth-child(1)").hide(); //所有ul的子元素
$("ul li:first").hide(); //第一个ul的子元素
```

## 表单选择器
内容过滤选择器
```javascript
:empty //空单元格
:has() //包含括号中选中元素的
:parent //疑问
:contains() //包含括号内的文本的
```

可见性过滤选择器
```javascript
:visible //所有可见元素
:hidden //所有隐藏标签
```

## 节点操作
创建节点
```javascript
$("html");
```
插入节点
```javascript
.append("html") //新节点作为最后一个子节点追加
.prepend("html") //新节点作为第一个子节点追加
.after() //在元素后面加上
.befor() //在元素前面加上
```
删除节点
```javascript
.remove() //删除整个节点，不保留事件和附加数据
.detach() //删除但保留事件
.empty() //清空子节点，但保留节点本身
```
复制节点
```javascript
.clone() //复制但不复制事件
.clone(true) //复制元素及其事件
```
替换节点
```javascript
replacewith() //被替换的节点.replacewith(替换内容)
replaceAll() //替换内容.replaceAll(被替换的节点)
```
包裹节点
```javascript
.wrap() //分开包裹
.wrapAll() //整体包裹
.wrapInner() //包裹内容
```
遍历节点
```javascript
.each(function(index,element){

});
```

## 事件监听
```javascript
$(selector).on(even,[data],function(){

});


// 在上述方法中进行修改后，表示事件只有第一次会触发，触发后就失效，下次不执行
$(selector).one(even,[data],function(){

});

// 解除事件绑定
$(selector).off(even);

// 事件传递
$("#btn1").click(function(){
    $("#btn2").trigger("click");
});
```

## 事件冒泡
```javascript
// 阻止事件冒泡，不阻止默认行为
event.stopPropagation();

// 不阻止事件冒泡，阻止默认行为
event.preventDefault();

// 同时阻止默认行为和冒泡
return false;
```