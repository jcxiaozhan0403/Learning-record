# ECMAScript 6 简介

ECMAScript 6.0（以下简称 ES6）是 JavaScript 语言的下一代标准，已经在 2015 年 6 月正式发布了。它的目标，是使得 JavaScript 语言可以用来编写复杂的大型应用程序，成为企业级开发语言。

## ECMAScript 和 JavaScript 的关系

一个常见的问题是，ECMAScript 和 JavaScript 到底是什么关系？

1996 年 11 月，JavaScript 的创造者 Netscape （网景）公司，决定将 JavaScript 提交给标准化组织  ECMA，希望这种语言能够成为国际标准。次年，ECMA 发布 262  号标准文件（ECMA-262）的第一版，规定了浏览器脚本语言的标准，并将这种语言称为 ECMAScript，这个版本就是 1.0 版。

因此，ECMAScript 和 JavaScript 的关系是，前者是后者的规范，后者是前者的一种实现（ 其他实现还有 Jscript 和 ActionScript）

## ES6 与 ECMAScript 2015 的关系

ECMAScript 2015（简称 ES2015）这个词，也是经常可以看到的

2011 年，ECMAScript 5.1 版发布后，就开始制定 6.0 版。因此，ES6 这个词的原意，就是指 JavaScript 语言的下一个版本。

ES6 的第一个版本，在 2015 年 6 月发布，正式名称是《ECMAScript 2015 标准》（简称 ES2015）。

2016 年 6 月，小幅修订的《ECMAScript 2016 标准》（简称 ES2016）如期发布，这个版本可以看作是 ES6.1 版，因为两者的差异非常小，基本上是同一个标准。根据计划，2017 年 6 月发布 ES2017 标准。

因此，ES6 既是一个历史名词，也是一个泛指，含义是 5.1 版以后的 JavaScript 的下一代标准，涵盖了 ES2015、ES2016、ES2017 等等，而 ES2015 则是正式名称，特指该年发布的正式版本的语言标准

## ES5和ES6的优劣

- ES5：
  - 代码复杂
  - 兼容性好
- ES6
  - 代码简洁
  - 兼容性差
- 所以一般，我们学习ES6，然后用ES5执行



# ES6基本语法

> ES标准中不包含 DOM 和 BOM的定义，只涵盖基本数据类型、关键字、语句、运算符、内建对象、内建函数等通用语法。

## let声明变量

- var 声明的变量没有局部作用

- let 声明的变量有局部作用

```javascript
<script>
    {
        var a = 3;
        let b = 4;
    }
    console.log(a);
    console.log(b);//Uncaught ReferenceError: b is not defined(b没有被定义)

</script>
```

- var 可以声明多次
- let 只可以声明一次

```JavaScript
<script>
    var a = 3;
    var a = 6;
    let b = 4;
    let b = 8;//ncaught SyntaxError: Identifier 'b' has already been declared
    console.log(a);
    console.log(b);
</script>
```

## const 定义常量

- 定义常量必须初始化
- 常量不可以重新赋值

```JavaScript
<script>
    //定义常量必须初始化
    //const b ;//Uncaught SyntaxError: Missing initializer in const declaration
    const a = 3;
    //常量不可以重新赋值
    //a = 4;//let1.html:4 Uncaught TypeError: Assignment to constant variable

    document.writeln(a);
    document.writeln(typeof(a));
</script>
```

## 解构赋值

> 解构赋值是对赋值运算符的扩展。
>
> 他是一种针对数组或者对象进行模式匹配，然后对其中的变量进行赋值。
>
> 在代码书写上简洁且易读，语义更加清晰明了；也方便了复杂对象中数据字段获取。

- 数组解构

```javascript
<script>
  	//传统方式
    let a = 1,b = "你好",c = true;
    console.log(a,b,typeof(b),c);

	//es6的方式
    let [x,y,z] = [3,"世界",false];
    console.log(x,y,z)
</script>
```

- 对象解构

```javascript
<script>
    let user = {name : "张三", age : 12};//此处使用大括号
    //传统方式
    let name1 = user.name;
    let age1 = user.age;
    console.log(name1,age1)

    //es6方式
    let {name,age} = user;//解构的变量必须是user中的属性
    console.log(name,age)
</script>
```

## 模板字符串

> 模板字符串相当于加强版的字符串，用反单引号 `（1左边的键）,除了作为普通字符串，还可以用来定义多行字符串，还可以在字符串中加入变量和表达式。

```JavaScript
// 1、多行字符串
<script>
    
   let a = `hello,
    javaScript,
ECMAScript`;//同时可以保留空格
    console.log(a);

	// 字符串不可换行
    // let b = "hello,
    // World";
    // console.log(b);

</script>
```

```javascript
// 2、字符串插入变量和表达式。变量名写在 ${} 中，${} 中可以放入 JavaScript 表达式。
<script>

    let user = {name:"张三",age:18};
    let a = `你好${user.name},
你今年是${user.age}岁吗？`;
    console.log(a)

</script>
```

```javascript
// 3、字符串中调用函数
<script>
    function fun(){
        return "帅哥";
    }

    let a = `你好${fun()}`;
    console.log(a);

</script>
```

## 声明对象

```javascript
<script>    let name = "张三";    let age = 12;    //传统    let user1 = {name : name,age : age};    console.log(user1);    //es6    let user2 = {name,age};    console.log(user2);</script>
```

## 定义方法

- user1相当于在Java中的类名
- 多个方法用","(逗号)隔开

```html
<script>    
//传统写法    
let user1 = {        
    eat:function(){console.log("hello");},        
    run:function(){console.log("跑");}    
}    
user1.eat();    
user1.run();

//ES6的写法    
//省掉了function
let user2 = {
    sleep(){console.log("hi")},        
    play(){console.log("玩")        }    
}    
user2.sleep();    
user2.play();
</script>
```

## 拷贝对象

```html
<script>        
    let user1 = {name:"李四",age:18};    
    let user2 = {...user1};    
    let user3 = user1;    
    console.log(user1)    
    console.log(user2)    
    console.log(user3)   
</script>
```

## 合并对象

```html
<script>    
    let user1 = {name:"李四",age:18};    
    let user2 = {gender:"男"};    
    let user3 = {...user1,...user2};    
    console.log(user1)    
    console.log(user2)    
    console.log(user3)   
</script>
```

## 箭头函数

```html
<script>    
    //传统    
    unction f1(a){return a+1;}    
    console.log(f1(3))    
    //es6    
    let f2 = b => ++b;    
    console.log(f2(6))   
</script>
```

- 当箭头函数没有参数或者有多个参数，要用 () 括起来。
- 当箭头函数函数体有多行语句，用 {} 包裹起来，表示代码块，
- 当只有一行语句，并且需要返回结果时，可以省略 {} , 结果会自动返回。
- 多用于匿名函数的定义

```html
<script>    
    let f3 = (a,b) => {        
        console.log("你好吗")        
        console.log("我很好")        
        return a+b;    
    }    
    console.log(f3(4,3))   
</script>
```

![image-20201206152000729](./03前端技术(Vue)-image/image-20201206152000729.png)

# Vue.js

## Vue.js 是什么

> Vue是一套用于构建用户界面的渐进式框架。
>
> Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与现代化的工具链以及各种支持类库结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。

## Vue入门案例

下载Vue框架，放入相应位置

![image-20201206162614906](./03前端技术(Vue)-image/image-20201206162614906.png)

![image-20201206162649512](./03前端技术(Vue)-image/image-20201206162649512.png)

导入Vue框架并测试

```html
<!DOCTYPE html>
<html lang="en">
    <head>    
        <title>Document</title>    
        <!-- 导入Vue框架 -->    
        <script src="vue.min.js"></script>
    </head>
    <body>    
        <div id="demo1">        
            <!-- 使用插值表达式取data中的值 格式：{{属性名}} -->        
            {{message}}    
        </div>    
            
        <script>        
            //创建一个vue对象        
            new Vue({
                //注意首字母大写            
                 el:'#demo1',
                //绑定vue的作用范围            
                data:{
                    //定义页面中显示的模型数据                
                    message:'hello,vue'            
                }        
            })    
        </script>    
    </body>
</html>
```

测试结果

![image-20201206162904214](./03前端技术(Vue)-image/image-20201206162904214.png)

## Vue代码片段抽取

文件 =>  首选项 => 用户代码片段 => 新建全局代码片段/或文件夹代码片段：vue-html.code-snippets

![image-20201206170516905](./03前端技术(Vue)-image/image-20201206170516905.png)

![image-20201206170737115](./03前端技术(Vue)-image/image-20201206170737115.png)

将里面代码替换为以下代码

```html
{	"vue htm":{		"scope": "html",		"prefix": "vuehtml",		"body": [			"<!DOCTYPE html>",			"<html lang=\"en\">",			"",			"<head>",			"    <meta charset=\"UTF-8\">",			"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">",			"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">",			"    <title>Document</title>",			"</head>",			"",			"<body>",			"    <div id=\"demo1\">",			"",			"    </div>",			"    <script src=\"vue.min.js\"></script>",			"    <script>",			"        new Vue({",			"            el: '#demo1',",			"            data: {",			"                $1",			"            }",			"        })",			"    </script>",			"</body>",			"",			"</html>",		],			"description": "my vue template in html"			}}
```

![image-20201206170947743](./03前端技术(Vue)-image/image-20201206170947743.png)

测试代码片段

![image-20201206171103685](./03前端技术(Vue)-image/image-20201206171103685.png)

测试成功

![image-20201206171137370](./03前端技术(Vue)-image/image-20201206171137370.png)

# 基本语法:数据渲染和指令

##v-bind:单向绑定

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="demo1">        <h1 title="测试title属性">            {{message}}        </h1>        <!--			v-bind指令：单向数据绑定			一般用于在标签属性中获取值		-->	        <h1 v-bind:title="content">            {{message}}        </h1>        <!-- 简写：v-bind省略不写 -->        <h1 :title="content">            {{message}}        </h1>    </div>    <script src="vue.min.js"></script>    <script>        new Vue({            el: '#demo1',            data: {                content:'我是标题',                message:"页面加载于" + new Date().toLocaleString()            }        })    </script></body></html>
```

##v-model:双向绑定

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="demo1">        <input type="text" value="测试value属性">        <!-- 单向绑定 -->        <input type="text" v-bind:value="user.name">        <!-- 双向绑定：修改值时，会修改所有使用user.name位置的值 -->        <input type="text" v-model:value="user.name">        <!-- 双向绑定：value可以省略不写 -->        <input type="text" v-model="user.name">        <p>{{user.name}}</p>    </div>    <script src="vue.min.js"></script>    <script>        new Vue({            el: '#demo1',            data: {                user:{                    name:"张三",                }            }        })    </script></body></html>
```

## v-on:click绑定单击事件

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="demo1">        <!-- 绑定事件: v-on:click="show()" -->        <input type="button" value="点我试试" v-on:click="show()"/>        <!-- 绑定事件简写: @click="show1()" -->        <input type="button" value="你再点一下试试！！" @click="show1()">        <!-- 绑定事件时，方法的括号可以不写，但是建议写上 -->        <input type="button" value="点我试试" v-on:click="show"/>        <input type="button" value="你再点一下试试！！" @click="show1">    </div>    <script src="vue.min.js"></script>    <script>        new Vue({            el: '#demo1',            data:{                           },            methods:{                    show(){                        alert("试试就试试")                    },                    show1(){                        alert("可以定义多个方法")                    }                }        })    </script></body></html>
```

##修饰符

.prevent：阻止事件原本的默认行为，执行指定方法

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="demo1">        <!-- v-on:submit.prevent：阻止提交，执行testing方法 -->        <!-- 方法不常用，但是要简单了解 -->        <form action="##" method="get" v-on:submit.prevent="testing()">            用户名：<input type="text" name="username" v-model="user.username">            <input type="submit" value="登录">        </form>    </div>    <script src="vue.min.js"></script>    <script>        new Vue({            el: '#demo1',            data: {                user:{                }            },            methods:{                testing(){                    if(this.user.username){//有值则为true                        alert("登录成功")                    }else{                        alert("请先输入用户名")                    }                }            }        })    </script></body></html>
```

## 条件指令

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="demo1">        <input type="checkbox" v-model="flag">        <!-- 条件指令 -->        <h1 v-if="flag">张三</h1>        <h1 v-else>李四</h1>    </div>    <script src="vue.min.js"></script>    <script>        new Vue({            el: '#demo1',            data: {                flag:false            }        })    </script></body></html>
```



![image-20201206213454344](./03前端技术(Vue)-image/image-20201206213454344.png)



![image-20201206213506787](./03前端技术(Vue)-image/image-20201206213506787.png)

## 遍历指令

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="demo1">        <!-- 简单遍历 -->        <!-- v-for="n in 10"：循环10次，每次把值赋值给n这个变量，然后输出 -->        <ul>            <li v-for="n in 10">{{n}}</li>        </ul>        <!-- v-for="(n,index) in 10":注意n和index的顺序，index在后面，代表索引值 -->        <ul>            <!-- <li v-for="(m,index) in 10">{{m}} - {{index}}</li> -->            <li v-for="(m,n) in 10">{{m}} - {{n}}</li>        </ul>        <!-- 对象遍历 -->        <table>            <tr>                <th>索引</th>                <th>编号</th>                <th>姓名</th>                <th>年龄</th>            </tr>            <tr v-for="(user,index) in userList">                <td>{{index}}</td>                <td>{{user.id}}</td>                <td>{{user.name}}</td>                <td>{{user.age}}</td>            </tr>        </table>        <h3 v-for="user in userList">{{user}}</h3>    </div>    <script src="vue.min.js"></script>    <script>        new Vue({            el: '#demo1',            data: {                userList:[                    {id:1,name:"张三",age:18},                    {id:2,name:"李四",age:19},                    {id:3,name:"王五",age:17}                ]            }        })    </script></body></html>
```



# 组件

组件（Component）是 Vue.js 最强大的功能之一。

组件可以扩展 HTML 元素，封装可重用的代码。

组件系统让我们可以用独立可复用的小组件来构建大型应用，几乎任意类型的应用的界面都可以抽象为一个组件树：

![image-20210131102737212](./03前端技术(Vue)-image/image-20210131102737212.png)

##局部组件

### 代码演示

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="demo1">        <nar></nar>        <nar1></nar1>        <h1></h1>    </div>    <script src="vue.min.js"></script>    <script>        new Vue({            el: '#demo1',            data: {                            },            //定义局部组件，这里可以定义多个局部组件            components:{                //组件的名称，随便起的                'nar':{                    template:'<ul><li>张三</li><li>李四</li></ul>'                },                'nar1':{                    template:"<ul><li>王五</li><li>赵六</li></ul>"                },                /*定义已经存在的组件，不会产生效果 */                'h1':{                    template:"<ul><li>孙七</li><li>周八</li></ul>"                 }            }        })    </script></body></html>
```

### 效果

![image-20210131103108822](./03前端技术(Vue)-image/image-20210131103108822.png)

## 全局组件

### 代码

- 定义全局组件

![image-20210131104207949](./03前端技术(Vue)-image/image-20210131104207949.png)

```js
Vue.component('Navbar',{    template:'<ul><li>刘一</li><li>陈二</li></ul>'})
```

- 使用全局组件

```html
<!DOCTYPE html>
<html lang="en">
    <head>    
        <meta charset="UTF-8">    
        <meta name="viewport" content="width=device-width, initial-scale=1.0">    
        <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title>
        </head><body>    
            <div id="demo1">        
                <Navbar></Navbar>    
                </div>    
                <script src="vue.min.js"></script>    
                <script src="components/Navbar.js"></script>    <script>        
                new Vue({            el: '#demo1',            data: {                            }        })    </script></body></html>
```

### 效果

![image-20210131104320117](./03前端技术(Vue)-image/image-20210131104320117.png)

# 实例的生命周期

![vue生命周期](./03前端技术(Vue)-image/vue%25E7%2594%259F%25E5%2591%25BD%25E5%2591%25A8%25E6%259C%259F.png)

- **beforeCreate和created方法：都会在数据渲染之前执行，但是会先执行beforeCreate，然后再执行created**
- **deforeMount和mounted方法：都会在数据渲染之后执行，但是会先执行deforeMount，然后再执行mounted**
- beforeUpdate和updated方法：都会在数据修改时执行，但是会先执行beforeUpdate，然后再执行updated
- beforeDestroy和destroyed方法：都会在数据渲染完成后进行销毁，但是会先执行beforeDestroy，然后再执行destroyed

##代码演示

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="demo1">        哈哈    </div>    <script src="vue.min.js"></script>    <script>        new Vue({            el: '#demo1',            data: {                            },            //渲染后执行            mounted(){                debugger//前端断点                console.log('mounted...')            },            //渲染前执行            created(){                debugger//前端断点                console.log('created...')            }            //created和mounted,执行顺序与代码位置无关        })    </script></body></html>
```



## 前端断点调试：debugger

![image-20210131113258580](./03前端技术(Vue)-image/image-20210131113258580.png)



# Vue路由

Vue.js 路由允许我们通过不同的 URL 访问不同的内容。

通过 Vue.js 可以实现多视图的单页Web应用（single page web application，SPA）。

Vue.js 路由需要载入 vue-router 库

##引入vue-router 库

```html
<script src="vue.min.js"></script><script src="vue-router.min.js"></script>
```

## 代码演示

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="app">        <h1>欢迎来到王牌儿商城</h1>        <!-- 2.定义前端页面 -->        <!-- 使用 router-link 组件来导航. -->        <!-- 通过传入 `to` 属性指定链接. -->        <!-- <router-link> 默认会被渲染成一个 `<a>` 标签 -->        <p>            <router-link to="/">首页</router-link>            <router-link to="/food">食物</router-link>            <router-link to="/clothes">服饰</router-link>        </p>        <!-- 3.定义路由出口，路由匹配到的组件将渲染在这里 -->        <router-view></router-view>    </div>    <script src="vue.min.js"></script>    <!-- 1.导入router的jar包 -->    <script src="vue-router.min.js"></script>    <script>        // 4.定义路由的组件        const welcome = { template:'<div>欢迎</div>'}        const food = { template:'<div>食物列表</div>'}        const clothes = { template:'<div>服饰列表</div>'}        // 5.定义路由和组件的映射        const routes = [          {path:'/',redirect:'/welcome'},//可以使用重定向          {path:'/welcome',component:welcome},          {path:'/food',component:food},          {path:'/clothes',component:clothes}        ]        // 6.创建 router 实例，然后传 `routes` 配置        const router = new VueRouter({            routes        })        // 7.创建和挂载根实例，让整个应用都有路由的功能        const app = new Vue({            el:'#app',            router        })    </script>    </body></html>
```

## 效果演示

![image-20210131122848680](./03前端技术(Vue)-image/image-20210131122848680.png)

# Element-UI

> element-ui是饿了么前端出品的基于Vue.js的后台组件库，方便程序员快速布局与构建



# Axios请求

##作用

> axios是独立于vue的一个项目，只不过经常结合Vue实现ajax请求
>
> 在浏览器中可以帮助我们完成 ajax请求的发送
>
> 在node.js中可以向远程接口发送请求

## 导入依赖

```html
<script src="vue.min.js"></script><script src="axios.min.js"></script><!-- 导入相关jar包 -->
```

## 代码演示

> 手动完成创建json文件并调用完成测试

data.json

```json
{    "sucess":true,    "code":20000,    "message":"成功",    "data":{        "items":[            {"name":"张三","age":20},            {"name":"李四","age":30},            {"name":"王五","age":40}        ]    }}
```



```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <meta http-equiv="X-UA-Compatible" content="ie=edge">    <title>Document</title></head><body>    <div id="demo1">        <!-- 遍历得到的数据 -->        <ul>            <li v-for="user in userlist">                {{user.name}}:{{user.age}}            </li>        </ul>    </div>    <script src="vue.min.js"></script>    <script src="axios.min.js"></script><!-- 导入相关jar包 -->    <script>        new Vue({            el: '#demo1',            data: {                // 在data中定义变量和初始值                userlist:[]            },            created(){                //页面渲染之前执行                //一般用于调用定义的方法                this.getUserList()            },            methods:{                //编写具体的方法                //查询用户所有的信息                getUserList(){                    //使用axios发送请求                    //格式：axios.请求方式("请求路径").then(箭头函数).catch(箭头函数)                    //.then是成功时执行的方法                    //.catch是失败时执行的方法                    axios.get("data.json")                    .then(response =>{                        //response为成功后返回的数据，名字随便写，一般写为response                        // console.log(response)//通过该行代码我们发现：数据有一定的层级关系response.data.data.items才是我们要得到的数据                        // 在控制台输出我们要的数据                        console.log(response.data.data.items)                        // 将我们得到的数据赋值给空的userList数组，this代表的是当前vue对象                        this.userlist = response.data.data.items                    })//成功后执行的方法                    .catch(error =>{                        console.log("error...")                    })//失败后执行的方法                }            }        })    </script></body></html>
```

```html
console.log(response)//通过该行代码我们发现：数据有一定的层级	关系response.data.data.items才是我们要得到的数据
```

- 结构展示

![image-20210131155652094](./03前端技术(Vue)-image/image-20210131155652094.png)

## 演示效果

![image-20210131154943819](./03前端技术(Vue)-image/image-20210131154943819.png)



# Node.js

## 什么是Node.js

> Node.js 就是运行在服务端的 JavaScript。
>
> Node.js是一个事件驱动I/O服务端JavaScript环境，基于Google的V8引擎，V8引擎执行Javascript的速度非常快，性能非常好。

> 理解：nodjs就是javaScript的运行环境

## Node.js有什么用

> Node.js 是运行在服务端的 JavaScript
>
> 可以部署一些高性能的服务

> 理解：高效的在服务端运行JavaScript代码



## 安装

### 下载

官网：https://nodejs.org/en/

中文网：http://nodejs.cn/

LTS：长期支持版本

Current：最新版

### 安装

![image-20210131170112953](./03前端技术(Vue)-image/image-20210131170112953.png)

![image-20210131170135155](./03前端技术(Vue)-image/image-20210131170135155.png)

![image-20210131170206166](./03前端技术(Vue)-image/image-20210131170206166.png)

![image-20210131170221026](./03前端技术(Vue)-image/image-20210131170221026.png)

![image-20210131170439869](./03前端技术(Vue)-image/image-20210131170439869.png)

![image-20210131170452979](./03前端技术(Vue)-image/image-20210131170452979.png)

![image-20210131170532027](./03前端技术(Vue)-image/image-20210131170532027.png)

### 查看版本

```
node -v
```

![image-20210131170748956](./03前端技术(Vue)-image/image-20210131170748956.png)



## 快速入门

![image-20210131171430666](./03前端技术(Vue)-image/image-20210131171430666.png)

### cmd窗口执行

![image-20210131171342263](./03前端技术(Vue)-image/image-20210131171342263.png)



##浏览器的内核

> 浏览器的内核包括两部分核心
>
> > DOM渲染引擎
> >
> > js解析器（js引擎）

> js运行在浏览器中的内核中的js引擎内部
>
> Node.js是脱离浏览器环境运行的JavaScript程序，基于V8 引擎（Chrome 的 JavaScript的引擎）
>
> 所以我们可以使用node执行js文件



##用VSCode打开cmd窗口

![image-20210131173202264](./03前端技术(Vue)-image/image-20210131173202264.png)

![image-20210131173433109](./03前端技术(Vue)-image/image-20210131173433109.png)

![image-20210131174421089](./03前端技术(Vue)-image/image-20210131174421089.png)

![image-20210131174446726](./03前端技术(Vue)-image/image-20210131174446726.png)

## 可能遇到的问题

1. 因系统文件不完善，导致终端没有任何内容

   - 解决：多按几下回车

2. 在VSCode中输入**node -v**不提示版本号

   - 原因：win10系统一般都会有，因为很多地方都需要权限

   - 解决：关掉vscode，右键打开属性，在兼容性里面设置为用管理员打开即可

   ![image-20210131175754598](./03前端技术(Vue)-image/image-20210131175754598.png)

   - 如果没有问题就不要选上了

3. 如果确定已经安装成功，并且用上述方法还是不能够看到版本号，那么就需要电脑重启



# NPM 

## 什么是NPM

NPM全称Node Package Manager，是Node.js包管理工具，是全球最大的模块生态系统，里面所有的模块都是开源免费的

是Node.js的包管理工具，相当于前端的Maven（可以联网下载jar包） 



## NPM工具的安装位置

我们通过npm 可以很方便地下载js库，管理前端工程。

Node.js默认安装的npm包和工具的位置：Node.js目录\node_modules

在这个目录下可以看见 npm目录，npm本身就是被NPM包管理器管理的一个工具，说明 Node.js已经集成了npm工具

![image-20210201075651728](./03前端技术(Vue)-image/image-20210201075651728.png)

##验证是否安装

```
在命令提示符输入 npm -v 可查看当前npm版本
```

![image-20210201075836635](./03前端技术(Vue)-image/image-20210201075836635.png)



## 使用npm管理项目

### 创建文件夹npm

### 项目初始化

> 什么是初始化：将创建的普通文件夹添加一些配置文件（例如类似于pom.xml的文件），从而成为一个前端的工程文件夹

```properties
#建立一个空文件夹，在命令提示符进入该文件夹  执行命令初始化npm init#按照提示输入相关信息，如果是用默认值则直接回车即可。#name: 项目名称#version: 项目版本号#description: 项目描述#keywords: {Array}关键词，便于用户搜索到我们的项目#最后会生成package.json文件，这个是包的配置文件，相当于maven的pom.xml#我们之后也可以根据需要进行修改。
```

![image-20210201081610749](./03前端技术(Vue)-image/image-20210201081610749.png)

```properties
#因为所有配置都是默认的，可以使用npm init -y直接生成 package.json 文件npm init -y
```

![image-20210201082033832](./03前端技术(Vue)-image/image-20210201082033832.png)

### 修改npm镜像

NPM官方的管理的包都是从 http://npmjs.com下载的，但是这个网站在国内速度很慢。

这里推荐使用淘宝 NPM 镜像 http://npm.taobao.org/ ，淘宝 NPM 镜像是一个完整 npmjs.com 镜像，同步频率目前为 10分钟一次，以保证尽量与官方服务同步。

**设置镜像地址：**

```properties
#经过下面的配置，以后所有的 npm install 都会经过淘宝的镜像地址下载npm config set registry https://registry.npm.taobao.org #查看npm配置信息npm config list
```

![image-20210201083401935](./03前端技术(Vue)-image/image-20210201083401935.png)

## npm install 命令的使用

###npm install jquery

```properties
#使用 npm install 安装依赖包的最新版，#模块安装的位置：项目目录\node_modules#安装会自动在项目目录下添加 package-lock.json文件，这个文件帮助锁定安装包的版本#同时package.json 文件中，依赖包会被添加到dependencies节点下，类似maven中的 <dependencies>npm install jquery
```

![image-20210201085410839](./03前端技术(Vue)-image/image-20210201085410839.png)

![image-20210201085619382](./03前端技术(Vue)-image/image-20210201085619382.png)

```properties
#如果安装时想指定特定的版本(了解)npm install jquery@2.1.x
```

###npm install

```properties
#npm管理的项目在备份和传输的时候一般不携带node_modules文件夹，只传输package.json文件npm install #根据package.json中的配置下载依赖，初始化项目
```

![image-20210201090546033](./03前端技术(Vue)-image/image-20210201090546033.png)

### 了解即可

```properties
#devDependencies节点：开发时的依赖包，项目打包到生产环境的时候不包含的依赖#使用 -D参数将依赖添加到devDependencies节点npm install --save-dev eslint#或npm install -D eslint#全局安装#Node.js全局安装的npm包和工具的位置：用户目录\AppData\Roaming\npm\node_modules#一些命令行工具常使用全局安装的方式npm install -g webpack
```

### 其它命令(了解即可)

```properties
#更新包（更新到最新版本）npm update 包名#全局更新npm update -g 包名#卸载包npm uninstall 包名#全局卸载npm uninstall -g 包名
```



# Babel

> Babel是一个广泛使用的转码器，可以将ES6代码转为ES5代码，从而在现有环境执行执行。
>
> 这意味着，我们可以现在就用 ES6 编写程序，而不用担心现有环境是否支持。

**注意：在安装命令之前需要先将项目初始化，成为一个前端项目**

![image-20210201094401344](./03前端技术(Vue)-image/image-20210201094401344.png)

## 安装命令行转码工具

Babel提供babel-cli工具，用于命令行转码。它的安装命令如下：

```properties
npm install --global babel-cli#查看是否安装成功babel --version
```

![image-20210201094839067](./03前端技术(Vue)-image/image-20210201094839067.png)

##创建es6的文件

![image-20210201095608378](./03前端技术(Vue)-image/image-20210201095608378.png)

```js
let f = b => ++b;//箭头函数是es6特有的表达式console.log(f(6))
```

##创建.babelrc文件

Babel的配置文件是.babelrc，存放在项目的根目录下，该文件用来设置转码规则和插件，基本格式如下。

```js
{    "presets": ["es2015"],    "plugins": []}
```

![image-20210201100002480](./03前端技术(Vue)-image/image-20210201100002480.png)

##在项目中安装转码器

```
npm install --save-dev babel-preset-es2015
```

![image-20210201100355772](./03前端技术(Vue)-image/image-20210201100355772.png)

## 进行转码

###方式一：根据文件转码

```properties
# --out-file 或 -o 参数指定输出文件babel es6/es6001.js --out-file es5/es5001.js# 或者babel es6/es6001.js -o es5/es5001.js
```

![image-20210201101119957](./03前端技术(Vue)-image/image-20210201101119957.png)

### 方式二：根据文件夹转码

```properties
# --out-dir 或 -d 参数指定输出目录babel es6 --out-dir es5# 或者babel es6 -d es5
```

![image-20210201101620300](./03前端技术(Vue)-image/image-20210201101620300.png)



# 模块化

## 什么是模块化

> 前端的模块化类似于java后台代码实现接口（controller、service、mapper整合在一起）
>
> java实现接口时是在使用多个包和类，每个包和类的功能不同，他们之间互相调用，最终实现某一个功能，这可以说是java的模块化
>
> 而前端的模块化是在多个js文件之间互相调用方法

##模块化产生的背景

> 随着网站逐渐变成"互联网应用程序"，嵌入网页的Javascript代码越来越庞大，越来越复杂。
>
> Javascript模块化编程，已经成为一个迫切的需求。
>
> 理想情况下，开发者只需要实现核心的业务逻辑，其他都可以加载别人已经写好的模块。但是，Javascript不是一种模块化编程语言，它不支持"类"（class），包（package）等概念。



## 模块化开发规范

### ES5模块化规范(也称CommonJS模块化规范)

> 每个文件就是一个模块，有自己的作用域。在一个文件里面定义的变量、函数、类，都是私有的，对其他文件不可见。要想被调用，需要另外设置

#### 创建es5module文件夹

#### 创建es501.js

```js
//1.创建js方法const sum = function(a,b){    return parseInt(a)+parseInt(b)//parseInt() 函数可解析一个字符串，并返回一个整数}const sub = function(a,b){    return parseInt(a)-parseInt(b);}//2.设置哪些方法可以被其他js调用module.exports = {    sum,sub}
```

#### 创建es502.js

```js
/* 注意：    ./:表示当前目录，在这里./是必须要写的    ../:表示上一级目录    *///引入模块const m = require('./01.js')//m就是引入后的对象，输出一下看看console.log(m)//调用方法console.log(m.sum(1,2))const sub = m.sub(3,2)console.log(sub)
```

#### 测试

![image-20210201121423281](./03前端技术(Vue)-image/image-20210201121423281.png)

###ES6模块化规范一

#### 创建01.js

```js
export function mul(a,b){    return parseInt(a) * parseInt(b);}export function getList(){    console.log("获取所有数据")}
```

#### 创建02.js

```js
//只取需要的方法即可，多个方法用逗号分隔import {mul,getList} from "./01.js"//.js这个后缀名可省略console.log(mul(2,3))getList()
```

> **注意：这时的程序无法运行的，因为ES6的模块化无法在Node.js中执行，需要用Babel编辑成ES5后再执行**
>
> **所以需要交给npm进行管理，之后babel进行安装**

![image-20210201125737223](./03前端技术(Vue)-image/image-20210201125737223.png)

> babel es6module1 -d es6module1Babel

![image-20210201130558264](./03前端技术(Vue)-image/image-20210201130558264.png)



### ES6模块化规范二

#### 创建01.js

```js
export default{          div(a,b){        return parseInt(a)/parseInt(b)    },//多个方法之间用逗号隔开    save(){        console.log("保存")    }}
```

#### 创建02.js

```js
//导入01.js的所有方法，赋值给mimport m from "./01.js"console.log(m.div(9,3))m.save();
```

#### 转换后的代码

![image-20210201132326270](./03前端技术(Vue)-image/image-20210201132326270.png)



# Webpack

## 什么是webpack

Webpack 是一个前端资源加载/打包工具。它能根据模块的依赖关系进行静态分析，并将这些模块按照指定的规则生成对应的静态资源。

从图中我们可以看出，Webpack 可以将多种静态资源 js、css、less 转换成一个静态文件，减少了页面的请求。 

![image-20210201145808837](./03前端技术(Vue)-image/image-20210201145808837.png)

##Webpack安装

```properties
#安装的是两个工具：webpack和webpack-clinpm install -g webpack webpack-cli
```

## 安装后查看版本号

```properties
webpack -v
```

![image-20210201153239450](./03前端技术(Vue)-image/image-20210201153239450.png)

**注意：在测试前需要将文件初始化：npm init**

## 创建src文件夹

### 创建common.js

```js
exports.add = function(a,b){    return a+b;}
```

###创建util.js

```js
exports.message = function(str){    document.write(str);//将数据输出到浏览器页面上，如果要看到效果就要使用到浏览器}
```

###创建main.js

```js
const common = require("./common")const util = require("./util")util.message("hello,webpack"+common.add(1,2))
```

## 将js文件进行打包

> 在项目的根目录下创建webpack.config.js文件，这个文件名称是固定的

> 以下配置的意思是：读取当前项目目录下src文件夹中的main.js（入口文件）内容，分析资源依赖，把相关的js文件打包，打包后的文件放入当前目录的dist文件夹下，打包后的js文件名为mainA.js

webpack.config.js

```js
const path = require("path"); //Node.js内置模块/* 可以不用记，但是要知道以下三个字符串的含义，并学会修改 */module.exports = {    entry: './src/main.js', //配置入口文件    output: {        path: path.resolve(__dirname, './dist'), //输出路径，__dirname：输出文件的路径文件夹        filename: 'mainA.js' //输出文件    }}
```

## 执行编译命令：方式一

```properties
webpack #有黄色警告
```

![image-20210201155514221](./03前端技术(Vue)-image/image-20210201155514221.png)



##执行编译命令：方式二

```properties
webpack --mode=development #没有警告执行后查看mainA.js 里面包含了上面两个js文件的内容并进行了代码压缩
```

![image-20210201155725197](./03前端技术(Vue)-image/image-20210201155725197.png)

## 测试代码

- 创建index.html文件并引入js文件

```html
<!DOCTYPE html><html lang="en"><head>    <meta charset="UTF-8">    <meta name="viewport" content="width=device-width, initial-scale=1.0">    <title>Document</title></head><body>    <!-- 引入mainA.js文件 -->    <script src="dist/mainA.js"></script>    </body></html>
```

![image-20210201160250639](./03前端技术(Vue)-image/image-20210201160250639.png)

## 测试效果

![image-20210201160127238](./03前端技术(Vue)-image/image-20210201160127238.png)

## 添加Css文件并打包测试

### 安装style-loader和 css-loader

> Webpack 本身只能处理 JavaScript 模块，如果要处理其他类型的文件，就需要使用 loader 进行转换。
>
> Loader 可以理解为是模块和资源的转换器。
>
> 首先我们需要安装相关Loader插件，css-loader 是将 css 装载到 javascript；style-loader 是让 javascript 认识css

```properties
npm install --save-dev style-loader css-loader 
```

![image-20210201161638993](./03前端技术(Vue)-image/image-20210201161638993.png)

###修改webpack.config.js

```js
const path = require("path"); //Node.js内置模块/* 可以不用记，但是要知道以下三个字符串的含义，并学会改 */module.exports = {    entry: './src/main.js', //配置入口文件    output: {        path: path.resolve(__dirname, './dist'), //输出路径，__dirname：输出文件的路径文件夹        filename: 'mainA.js' //输出文件    },    /* 添加的css相关配置 */    module: {        rules: [              {                  test: /\.css$/,    //打包规则应用到以css结尾的文件上                use: ['style-loader', 'css-loader']            }          ]      }}
```

### 在src文件夹创建style.css

```css
body{    background-color: red;}
```

![image-20210201162027851](./03前端技术(Vue)-image/image-20210201162027851.png)

###**修改main.js** 

- 引入style.css

```js
/* 引入style.css文件 */require("./style.css")//后缀名不可以省略
```

![image-20210201162317616](./03前端技术(Vue)-image/image-20210201162317616.png)

###删除mainA.js文件，调用命令生成新的mianA.js文件

![image-20210201162641615](./03前端技术(Vue)-image/image-20210201162641615.png)

### 测试效果

![image-20210201162740259](./03前端技术(Vue)-image/image-20210201162740259.png)



# 项目结构说明

- 我们做的项目一般为B/S架构的项目
- B/S结构的项目需要做**后台管理系统**和**前端用户系统**
- 我们做的讲师管理部分就是**后台管理系统**的后台部分，现在我们完成**后台管理系统**的前端部分
- **台管理系统**的前端部分我们一般会在已有的前端项目中进行修改，这里我们在**vue-element-admin**的基础上修改

# vue-admin-template

> vue-admin-template是基于element-ui 的一套后台管理系统基础模板（最少精简版），可作为模板进行二次开发。

## 安装并下载依赖

- 将**vue-admin-template-master.zip**文件解压到工作区
- 将package.json文件用终端打开，使用"npm install"命令下载依赖
- 下载成功后会出现**node_modules**文件夹
- 注意：
  - 因为网速、电脑配置等原因依赖有可能下载失败
  - 如果失败了需要将**node_modules**删掉，重新执行命令

![image-20210201175924263](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210201175924263.png)

## 启动项目

```properties
# 选中项目用终端打开，执行“npm run dev”命令# 执行后，浏览器自动弹出并访问http://localhost:9527/，则安装成功
```

![image-20210809204405706](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210809204405706.png)

![image-20210201180054303](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210201180054303.png)

![image-20210201180807393](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210201180807393.png)



# 项目的目录结构

```js
build // 构建脚本信息config // 配置文件 node_modules // 项目依赖模块src //项目源代码static // 静态资源package.jspon // 项目信息和依赖配置
```

```js
src目录    api // 各种接口：定义调用的方法    assets // 静态资源：图片等    components // 各种公共组件    icons // 放置图标    router // 存储路由表     store // 存储脚本文件    styles // 各种样式     utils // 公共工具    views // 存放具体的页面    App.vue //项目顶层组件    main.js //项目入口文件    permission.js //认证入口
```

# Eslint语法规范检查

## ESLint简介

JavaScript 是一个动态的弱类型语言，在开发中比较容易出错。因为没有编译程序，为了寻找 JavaScript 代码错误通常需要在执行过程中不断调适。

ESLint 是一个语法规则和代码风格的检查工具，可以用来保证写出语法正确、风格统一的代码。让程序员在编码的过程中发现问题而不是在执行的过程中。

## 语法规则

ESLint 内置了一些规则，也可以在使用过程中自定义规则。

本项目的语法规则包括：两个字符缩进，必须使用单引号，不能使用双引号，语句后不可以写分号，代码段之间必须有一个空行等。

## 关闭语法检查

打开 config/index.js，配置是否开启语法检查

```
useEslint: true,
```

> ***注意：因为检查过于严格，我们在本次项目中关闭检查，将值设为 false 即可***

## ESLint插件安装(该项目已经安装完毕)

vs code的ESLint插件，能帮助我们自动整理代码格式 

![image-20210201205104384](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210201205104384.png)

## 插件的扩展设置

选择vs code左下角的“设置”， 打开 VSCode 配置文件,添加如下配置

![image-20210201205148409](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210201205148409.png)

![image-20210201205210864](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210201205210864.png)

```js
"files.autoSave": "off","eslint.validate": [  "javascript",  "javascriptreact",  "vue-html",  {    "language": "vue",    "autoFix": true  }],"eslint.run": "onSave","eslint.autoFixOnSave": true
```



# 后台系统登录功能改造

## 把系统登录功能改到本地

![image-20210203143246775](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210203143246775.png)

![image-20210203143615713](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210203143615713.png)

> 修改后我们现在可以注意到：
>
> 登录地址：https://easy-mock.com/mock/5950a2419adc231f356a6636/vue-admin/user/login
>
> 修改地址：https://easy-mock.com/mock/5950a2419adc231f356a6636/vue-admin
>
> 后面还有一个是"/user/login"的请求路径

![image-20210810161706112](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210810161706112.png)



## 分析源码

登录会调用两个方法，login登录的方法和info登录后获取用户信息的方法

![image-20210810173651811](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210810173651811.png)

## 创建后端代码

> 在controller包下EduLoginCotroller类

```java
package com.bao.eduservice.controller;import com.bao.commonutils.R;import org.springframework.web.bind.annotation.*;@RestController@RequestMapping("/eduservice/user")public class EduLoginCotroller {    @PostMapping("login")//这里需要注意与前端的请求方式相同    public R login(){        return R.ok().data("token","admin");//储存前端需要的数据    }    @GetMapping("info")    public R info(){        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");//头像可以随便找，但是要注意网络上的图片有防盗链操作，不能随意访问    }}
```

> 确定了访问路径后回到前端代码修改访问路径

![image-20210810193746302](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210810193746302.png)

> 因为修改了配置文件，需要重新启动项目访问

![image-20210203155612921](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210203155612921.png)

## 出现问题

> 会发现还是不能够进行后端代码的访问，提示没有网络，通过控制台可以看到如下问题，

![image-20210203155742809](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210203155742809.png)

> 提示访问不被允许，这其实就是跨域问题

## 跨域问题

> 通过一个地址去访问另个地址，这个过程的三个要素有任意一个不一样就会产生跨域问题
>
> 访问协议、ip地址、端口号

```
前端项目：http://localhost:9528后端项目：http://localhost:8001两个项目中的端口号不一致，产生跨域问题
```

##解决跨域问题

解决跨域问题的方式有很多种

### 常见解决方法之一

在后端接口Controller上加一个注解@CrossOrigin

![image-20210203160156834](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210203160156834.png)

![image-20210203160211807](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210203160211807.png)

## 访问成功

![image-20210810193125871](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210810193125871.png)



# 前端开发过程分析

> 分析原始页面

##查看页面创建位置

![image-20210811165222492](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210811165222492.png)

## 页面内容

![image-20210811170536321](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210811170536321.png)

## 查看引入内容

![image-20210811170650869](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210811170650869.png)

## 查看引入的request

> 这里将axios的代码进行了封装

![image-20210204104306120](C:/Users/bzg/AppData/Local/kingsoft/WPS%2520Cloud%2520Files/userdata/qing/filecache/%25E5%25BF%2597%25E5%259B%25BD%255EO%255E%25E7%259A%2584%25E4%25BA%2591%25E6%2596%2587%25E6%25A1%25A3/%25E6%2595%2599%25E5%25AD%25A6/Java/08SpringBootCase/04%25E6%2590%25AD%25E5%25BB%25BA%25E5%2590%258E%25E5%258F%25B0%25E7%25B3%25BB%25E7%25BB%259F%25E7%259A%2584%25E5%2589%258D%25E7%25AB%25AF%25E7%258E%25AF%25E5%25A2%2583-image/image-20210204104306120.png)

