## 今天，我的JSON学习算是完成了，不过只是入门阶段，我只是掌握了一些基础语法，下面是我的学习笔记，有兴趣的小伙伴可以看一看，这不是一篇教程贴，但是如果你有基础的话，应该很容易看得懂，我只是想分享一下我的所学

### JSON在线工具

这个网站可以在线编写JSON
https://json.cn/

### JSON是什么

JSON，全称JavaScript Object Notation,即JavaScript对象标记法

JSON是存储和交换文本信息的语法，类似 XML

JSON是一种轻量级的、基于文本的、可读的格式，语法格式参考JavaScript对象，格式永不升级

### JSON语法规则

规则五大点
- 数组（Array）用方括号`[]`表示，存放放值
- 对象（Object）用大括号`{}`表示，存放放名称/值
- 名称/值对（name/value）组合成数组和对象
- 名称（name）置于双引号中，值（value）有字符串、数值、布尔值、null、对象、数组。

```JSON
{
    "name":"John",
    "age":19,
    "hobby":["Sing","dance","Rap","basketball"]
}
```

字符串规则
- 用英语双引号括起来
- 字符串中不能单独出现双引号`"`和反斜杠`\`
- 如需输入双引号或反斜杠，需要在其前面加上一个`\`，如 `"你喜欢苹果\\香蕉"`

### JSON的解析与生成

 ```
JSON.parse()    将符合JSON规则的字符串转换为对象
JSON.stringify()     将Javascript值转换为字符串
eval()     将字符串解析为代码执行
 ```
解析是指将JSON字符串转化为Javascript对象的过程

JSON.parse(name,value)
- 第一个参数为变量名，是必选参数。
- 第二个参数为需要执行的函数名，如果使用两个参数的话，对象中的每一组名称/值对都会执行一次函数，用于解析过程中的赋值

```JavaScript
var str = '{"name":"John","age":19}';

console.log(str);

  var obj = JSON.parse(str,fun);
//var obj = eval("("+ str + ")");

function fun(name,value){  
    return value;
}

console.log(obj);
```

序列化是指将Javascript值转化为JSON字符串的过程

JSON.stringify(value,replacer,space)
- 第一个参数为Jascript的值，一般是对象或数组，是必选参数。
- 第二个参数可以是函数或者数组,如果是函数，对象中的每一组名称/值对都会执行一次函数，函数返回值将代替转化结果进行输出，如果返回undefind，则被忽略。如果是数组，则只有数组中存在的名称，才能被转化，且转化后顺序与数组中的值保持一致
- 第三个参数是为了方便阅读和排版，用来添加空白或制表符等

```JavaScript
var obj = {
    name:"John",
    age:19
};

console.log(obj);

var jsonstr = JSON.stringify(obj,fun);

function fun(name,value){
    return value;
}

console.log(jsonstr);
```

```JavaScript
var obj = {
    a:1,
    b:2,
    c:3,
    d:4   
};

console.log(obj);

var jsonstr = JSON.stringify(obj,["b","c","a"],"\t");

console.log(jsonstr);
```

### JSON和XML的转化

官网很慢，我们在下面这个网站下载jQuery
http://www.jq22.com/jquery-info122

在下面这个网站下载jquery.json2xml.js和jquery.xml2json.js两个组件
https://json.cn/component.html

先引入下载的三个js文件，然后就可以使用了，引入顺序很重要
```JavaScript
<script src="jquery-3.4.1.min.js"></script>
<script src="jquery.json2xml.js"></script>
<script src="jquery.xml2json.js"></script>
```
将XML字符串转化为JSON字符串的过程
```JavaScript
var str = "<root>"+
          "<name>John</name>"+
          "<age>19</age>"+
          "<hobby>Sing</hobby>"+
          "<hobby>dance</hobby>"+
          "<hobby>Rap</hobby>"+
          "<hobby>basketball</hobby>"+
          "</root>";

console.log(str);

var obj = $.xml2json(str);

console.log(obj);

var jsonstr = JSON.stringify(obj);

console.log(jsonstr);
```
将Javascript对象转换为XML字符串的过程
```Javascript
var obj = {
    name:"John",
    age:19
};

console.log(obj);

var xmlstr = $.json2xml(obj);

console.log(xmlstr);
```

### GeoJSON和TopoJSON
下面这个网站，可以在线在地图上表示GeoJSON信息
http://geojson.io

GeoJSON和TopoJSON是符合JSON语法规则的两种数据格式，用于表示地理信息

1. GeoJSON
GeoJSON用于表示地理空间信息，它的最外层是一个对象，对象可表示几何体(Geometry)、特征(Feature)、特征集合(FeatureCollection)

最外层的GeoJSON里可能包含多个子对象，每一个GeoJSON对象都有一个type属性，表示对象类型，有下面这些类型

- Point 点
- MultiPoint 多点
- LineString 线
- MultiLineString 多线
- Polygon 面
- MultiPolygon 多面
- GeometryCollection 几何体集合
- Feature 特征
- FeatureCollection 特征集合

如果type值为Point、MultiPoint、LineString、MultiLineString、Polygon、MultiPolygon，对象必有变量coordinates

如果type值为GeometryCollection，对象必有变量geometries，其值是一个数组，数组每一项都是一个几何对象

如果type值为Feature，对象必有变量geometry，表示几何体其值为一个几何体对象。此特征对象还包含一个properties，表示特征，其值可以是任意JSON对象或者Null

```JSON
{
    "type":"GeometryCollection",
    "geometries":[
    {
        "type": "Point",
        "coordinates": [50,30]
    },
    {
        "type": "LineString",
        "coordinates": [[50,30],[100,30]]
    }
]
}
```

```JSON
{
    "type":"Feature",
    "properties":{
        "name":"四川成都"
    },
    "geometry":{
        "type":"Point",
        "coordinates":[104.05,30.68]
    }
}
```

2. TopoJSON
TopoJSON是GeoJSON按拓扑学编码后的扩展形式

TopoJSON消除了冗余，相比TopoJSON文件较小

下面这个网站可以进行TopoJSON和GeoJSON格式的转换
https://mapshaper.org/****