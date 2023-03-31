## 概述

> Vue

Vue (读音/vju/, 类似于view)是一套用于构建用户界面的渐进式框架，发布于2014年2月。与其它大型框架不同的是，Vue被设计为可以自底向上逐层应用。Vue的核心库只关注视图层，不仅易于上手，还便于与第三方库(如: vue-router: 跳转，vue-resource: 通信，vuex:管理)或既有项目整合

官网：https://cn.vuejs.org/

> 前端三要素

- HTML (结构) :超文本标记语言(Hyper Text Markup Language) ，决定网页的结构和内容
- CSS (表现) :层叠样式表(Cascading Style sheets) ，设定网页的表现样式
- JavaScript (行为) :是一种弱类型脚本语言，其源代码不需经过编译，而是由浏览器解释运行,用于控制网页的行为

> Javascript框架

- **jQuery**: 大家熟知的JavaScript框架，优点是简化了DOM操作，缺点是DOM操作太频繁,影响前端性能;在前端眼里使用它仅仅是为了兼容IE6、7、8;

- **Angular**: Google收购的前端框架，由一群Java程序员开发，其特点是将后台的MVC模式搬到了前端并增加了模块化开发的理念，与微软合作，采用TypeScript语法开发;对后台程序员友好，对前端程序员不太友好;最大的缺点是版本迭代不合理(如: 1代-> 2代，除了名字，基本就是两个东西;截止发表博客时已推出了Angular6)

- **React**: Facebook出品，一款高性能的JS前端框架;特点是提出了新概念[虚拟DOM]用于减少真实DOM操作，在内存中模拟DOM操作，有效的提升了前端渲染效率;缺点是使用复杂，因为需要额外学习一门[JSX] 语言;

- **Vue**:一款渐进式JavaScript框架，所谓渐进式就是逐步实现新特性的意思，如实现模块化开发、路由、状态管理等新特性。其特点是综合了Angular (模块化)和React (虚拟DOM)的优点;

- **Axios** :前端通信框架;因为Vue 的边界很明确，就是为了处理DOM,所以并不具备通信能力，此时就需要额外使用一个通信框架与服务器交互;当然也可以直接选择使用jQuery提供的AJAX通信功能;

  **前端三大框架：Angular、React、Vue**

### 什么是MVVM

> MVVM (Model-View-ViewModel) 是一种软件架构设计模式，由微软WPF (用于替代WinForm，以前就是用这个技术开发桌面应用程序的)和Silverlight (类似于Java Applet,简单点说就是在浏览器上运行的WPF)的架构师Ken Cooper和Ted Peters 开发，是一种简化用户界面的事件驱动编程方式。由John Gossman (同样也是WPF和Silverlight的架构师)于2005年在他的博客上发表。

MVVM 源自于经典的MVC (ModI-View-Controller) 模式。MVVM的核心是ViewModel层，负责转换Model中的数据对象来让数据变得更容易管理和使用，其作用如下:

- 该层向上与视图层进行双向数据绑定
- 向下与Model层通过接口请求进行数据交互



![MVVM](D:\Study\Learning-record\Vue\MVVM.jpg)

### 为什么要使用MVVM

MVVM模式和MVC模式一样，主要目的是分离视图(View)和模型(Model),有几大好处：

- 低耦合:视图(View)可以独立于Model变化和修改,一个ViewModel可以绑定到不同的
  View上，当View变化的时候Model可以不变，当Model变化的时候View也可以不变。
- 可复用:你可以把一些视图逻辑放在一个ViewModel里面，让很多View重用这段视图逻辑。
- 独立开发:开发人员可以专注于业务逻辑和数据的开发(ViewModel),设计人员可以专注于页面设计。
- 可测试:界面素来是比较难于测试的，而现在测试可以针对ViewModel来写。

### Vue 是 MVVM 模式的实现者

- Model : 模型层，在这里表示JavaScript对象
- View : 视图层,在这里表示DOM (HTML操作的元素)
- ViewModel : 连接视图和数据的中间件，Vue.js就是MVVM中的ViewModel层的实现者在MVVM架构中，是不允许数据和视图直接通信的，只能通过ViewModel来通信，而ViewModel就是定义了一个Observer观察者
- ViewModel 能够观察到数据的变化，并对视图对应的内容进行更新
- ViewModel 能够监听到视图的变化，并能够通知数据发生改变

至此，我们就明白了，Vue.js 就是一个MVVM的实现者，他的核心就是实现了**DOM监听**与**数据绑定**

## 第一个Vue程序

在线CDN

```html
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.21/dist/vue.min.js"></script>
```

```html
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>Document</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.21/dist/vue.min.js"></script>
<body>
    <div id='app'>
        {{msg}}
    </div>
    <script>
        const app = new Vue({
            el: '#app',
            data: {
                msg: 'Hello Vue！'
            }
        })
</script>
</body>
</html>
```

## Vue生命周期

<img src="D:\Study\Learning-record\Vue\Vue生命周期.jpg" alt="Vue生命周期" style="zoom:40%;" />

## Vue目录结构

![Vue-Cli目录结构](D:\Study\Learning-record\Vue\Vue-Cli目录结构.jpg)

## Vue基础语法

> v-bind 或 :

数据绑定，将一些属性值与后台数据进行绑定，实时改变

```html
<div id='app'>
    <span v-bind:title="msg">鼠标悬停几秒钟查看此处动态绑定的提示信息！</span><br>
    <span :title="msg">鼠标悬停几秒钟查看此处动态绑定的提示信息！</span><br>
    <span>{{msg}}</span>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            msg: 'Hello Vue！'
        }
    })
</script>
```

> v-if v-else

```html
<div id='app'>
    <h1 v-if="type==='A'">A</h1>
    <h1 v-else-if="type==='B'">B</h1>
    <h1 v-else>C</h1>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            type: 'A'
        }
    })
</script>
```

> v-show

布尔值判断，如果为true就显示为false就隐藏，本质是为元素加上一个display:none的css属性

```html
<!-- 法一：直接使用布尔值 -->
<img src="路径" v-show="true">
<!-- 法二：使用data中存放的布尔值 -->
<img src="路径" v-show="isShow">
<!-- 法三：通过判断得到布尔值 -->
<img src="路径" v-show="age>=18">
```

> v-for

```html
<div id='app'>
    <li v-for="item in arr">
        {{item.msg}}
    </li>
    <br>
    <!-- 遍历的同时也可以获取下标 -->
    <li v-for="(item,index) in arr">
        第{{index+1}}条信息：{{item.msg}}
    </li>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            arr: [
                {msg: 'aaaaa'},
                {msg: 'bbbbb'},
                {msg: 'ccccc'},
                {msg: 'ddddd'}
            ]
        }
    })
</script>
```

> v-on或@

事件绑定

```html
<div id='app'>
    <button v-on:click="showMsg()">点击</button>
    <button @click="showMsg()">点击</button>
    <!--触发带参函数需要先传入一个$event对象-->
    <button @click="showMsg($event,b,a)">点击</button>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            msg: 'Hello Vue！'
        },
        methods: {
            showMsg(){
                alert(this.msg);
            }
        },
    })
</script>
```

> v-once

该指令表示元素和组件只渲染一次，不会随着数据的改变而改变

```html
<div id='app'>
    <input type="text" v-model="msg">
    <h2 v-once>{{msg}}</h2>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            msg: '你好'
        }
    })
</script>
```

> v-html

```html
<div id='app'>
    <h2 v-html="url"></h2>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            url: '<a href="www.baidu.com">百度</a>'
        }
    })
</script>
```

> v-text

该指令在渲染页面时，如果数据是一个html标签，不会对其进行解析，会原封不动以字符串的形式渲染到页面上

```html
<div id='app'>
    <h2 v-text="url"></h2>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            url: '<a href="www.baidu.com">百度</a>'
        }
    })
</script>
```

> pre

```html
<div id='app'>
    <h2 v-pre>{{msg}}</h2>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            msg: '你好'
        }
    })
</script>
```



## 双向绑定

### 什么是双向绑定

 Vue.js是一个MVVM框架，即数据双向绑定,即当数据发生变化的时候,视图也就发生变化，当视图发生变化的时候，数据也会跟着同步变化。这也算是Vue.js的精髓之处了。

 值得注意的是，我们所说的数据双向绑定，一定是对于UI控件来说的，非UI控件不会涉及到数据双向绑定。单向数据绑定是使用状态管理工具的前提。如果我们使用vuex，那么数据流也是单项的，这时就会和双向数据绑定有冲突。

### 为什么要实现双向绑定

在Vue.js 中，如果使用vuex ，实际上数据还是单向的，之所以说是数据双向绑定，这是用的UI控件来说，对于我们处理表单，Vue.js的双向数据绑定用起来就特别舒服了。即两者并不互斥，在全局性数据流使用单项,方便跟踪;局部性数据流使用双向，简单易操作。

### 示例

使用`v-model`来进行双向绑定

==v-model会忽略所有元素的value、checked、selected特性的初始值而总是将Vue实例的数据作为数据来源，你应该通过JavaScript在组件的data选项中声明。==

> 输入框

```html
<div id='app'>
    <input type="text" v-model="input"><br>
    <p>以下是你输入的内容：</p>
    <p>{{input}}</p>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            input: ''
        }
    })
</script>
```

> 单选框

```html
<div id='app'>
    <input type="radio" name="gender" v-model="checked" value="男">男
    <input type="radio" name="gender" v-model="checked" value="女">女
    <p>你选择的是：{{checked}}</p>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            checked: '',
            select: ''
        }
    })
</script>
```

> 下拉框

```html
<div id='app'>
    <select v-model="select">
        <option value="" disabled>---请选择---</option>
        <option value="唱">唱</option>
        <option value="跳">跳</option>
        <option value="rap">rap</option>
        <option value="篮球">篮球</option>
    </select>
    <p>你选择的是：{{select}}</p>
</div>
<script>
    const app = new Vue({
        el: '#app',
        data: {
            select: ''
        }
    })
</script>
```

## 组件

组件是可复用的 Vue 实例，且带有一个名字

==组件必须是单根的==

==data必须是一个函数，这样所有的模板使用的数据才是彼此隔离的==

```html
<div id='app'>
    <div id="components-demo">
        <button-counter></button-counter>
        <button-counter></button-counter>
        <button-counter></button-counter>
    </div>
</div>
<script>
    // 定义一个名为 button-counter 的新组件
    Vue.component('button-counter', {
        data: function () {
            return {
                count: 0
            }
        },
        template: '<button v-on:click="count++">你点击了我 {{ count }} 次</button>'
    })

    const app = new Vue({
        el: '#app',
        data: {

        }
    })
</script>
```

> props

使用props定义自定义属性，用于给template传递参数

```html
<div id='app'>
    <blog-post
        v-for="(post,index) in posts"
        :No="post.id"
        :Title="post.title"
     ></blog-post>
</div>
<script>
    const vc =Vue.component('blog-post', {
        props: ['No','Title'],
        template: '<h3>{{ No }} {{Title}}</h3>'
    })

    const app = new Vue({
        el: '#app',
        data: {
            posts: [
                { id: 1, title: 'My journey with Vue' },
                { id: 2, title: 'Blogging with Vue' },
                { id: 3, title: 'Why Vue is so fun' }
            ]
        }
    })
</script>
```

## Axios异步通信

在线CDN

```html
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
```

- 创建json数据文件

```json
{
    "name":"张三",
    "url": "http://baidu.com",
    "page": "1",
    "isNonProfit":"true",
    "address": {
      "street": "中信大道",
      "city":"四川成都",
      "country": "中国"
    },
    "links": [
      {
        "name": "B站",
        "url": "https://www.bilibili.com/"
      },
      {
        "name": "4399",
        "url": "https://www.4399.com/"
      },
      {
        "name": "百度",
        "url": "https://www.baidu.com/"
      }
    ]
}
```

- 使用axios完成通信

```html
<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>Document</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/vue@2.5.21/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<body>
    <div id='app'>
    </div>
    <script>
        const app = new Vue({
            el: '#app',
            data() {
                return {
                    Obj: null
                }
            },
            mounted() {
                axios.get("./data.json").then((response) => {
                    this.Obj = response.data;
                    console.log(response); 
                });
            },
        })
    </script>
</body>
</html>
```

> 并发请求

```javascript
axios.add([axios.get(""),axios.post("",{})]).then(){
  axios.spread(function(res1,res2){

  })
}
```

### Vue-Cli中引入Axios

- 下载axios

```shell
npm install axios --save-dev
```

- 在`main.js`中引入axios

```shell
import axios from 'axios'

Vue.prototype.$http=axios
```

## 计算属性

计算属性的重点突出在`属性`两个字上(属性是名词)，首先它是个`属性`其次这个属性有`计算`的能力(计算是动词)，这里的计算就是个函数;简单点说，它就是一个能够将计算结果缓存起来的属性(将行为转化成了静态的属性)，仅此而已;可以想象为**缓存**！

因为它是一个`属性`，所以我们通过模板语法访问它时，不需要加`()`

通过分析可以得知计算属性的值除了第一次是调用函数以外，之后再使用时，都是直接通过缓存值进行返回的，只有在它内部的返回值有所改变时，才会刷新缓存，发起重新调用。

当methods和computed存在同名方法，methods的优先级更高

```html
<div id='app'>
    {{getMsg()}}
    {{getMsg1}}
</div>
<script>
    const app = new Vue({
        el: '#app',
        data() {
            return {

            }
        },
        methods: {
            getMsg(){
                return "Hello Vue！";
            }
        },
        computed: {
            getMsg1(){
                return "Hello Vue！";
            }
        }
    })
</script>
```

## 插槽

Vue 实现了一套内容分发的 API，这套 API 的设计灵感源自 [Web Components 规范草案](https://github.com/w3c/webcomponents/blob/gh-pages/proposals/Slots-Proposal.md)，将 `<slot>` 元素作为承载分发内容的出口。

```html
<div id='app'>
    <todo>
        <todo-title slot="todo-title" :title="title"></todo-title>
        <todo-items slot="todo-items" v-for="item in todoItems" :item="item"></todo-items>
    </todo>
</div>
<script>
    //slot 插槽 这个组件要定义在前面不然出不来数据
    Vue.component("todo", {
        template: '<div>\
<slot name="todo-title"></slot>\
<ul>\
<slot name="todo-items"></slot>\
    </ul>\
<div>'
    });

    Vue.component("todo-title", {
        //属性
        props: ['title'],
        template: '<div>{{title}}</div>'
    });

    Vue.component("todo-items", {
        props: ['item'],
        template: '<li>{{item}}</li>'
    });

    let vm = new Vue({
        el: "#app",
        data: {
            //标题
            title: "图书馆系列图书",
            //列表
            todoItems: ['三国演义', '红楼梦', '西游记', '水浒传']
        }
    });
</script>
```

## 自定义事件&内容分发

Vue提供了自定义事件函数，来用于组件中调用实例方法

```html
<div id="app">
    <todo>
        <todo-title slot="todo-title" v-bind:name="title"></todo-title>
        <todo-items slot="todo-items" v-for="(item,index) in todoItems" :item="item"
                    :index="index" @remove="removeItems(index)"></todo-items>
    </todo>
</div>
<script>
    //slot 插槽 这个组件要定义在前面不然出不来数据
    Vue.component("todo", {
        template: '<div>\
<slot name="todo-title"></slot>\
<ul>\
<slot name="todo-items"></slot>\
    </ul>\
<div>'
    });

    Vue.component("todo-title", {
        //属性
        props: ['name'],
        template: '<div>{{name}}</div>'
    });

    Vue.component("todo-items", {
        props: ['item','index'],
        template: '<li>{{index}}---{{item}} <button @click="remove">删除</button></li>',
        methods: {
            remove: function (index) {
                // this.$emit 自定义事件分发
                //$emit(自定义事件名，参数)
                this.$emit('remove',index)
            }
        }
    });

    let vm = new Vue({
        el: "#app",
        data: {
            //标题
            title: "图书馆系列图书",
            //列表
            todoItems: ['三国演义', '红楼梦', '西游记', '水浒传']
        },
        methods: {
            removeItems: function (index) {
                console.log("删除了"+this.todoItems[index]+"OK");
                this.todoItems.splice(index,1);
            }
        }
    });
</script>
```

## 事件修饰符

- 常用
  stop：阻止冒泡
  prevent：阻止默认行为
  self：只监听自己触发的事件，不关心事件冒泡带来的事件
  once：只执行一次特定事件

- 不常用
  capture：使用事件的捕获模式
  passive：事件的默认行为立即执行，无需等待事件回调执行完毕

事件修饰符可以连续使用

```vue
<!-- 例如同时阻止事件默认行为和冒泡行为 -->
<a type="button" value="单击" @click.stop.prevent="dolt">点我弹窗</a>
```



## NPM命令

- `npm install moduleName`：安装模块到项目目录下

- `npm install -g moduleName`：-g 的意思是将模块安装到全局，具体安装到磁盘的哪个位置，要看 npm config prefix的位置
- `npm install moduleName -save`：–save的意思是将模块安装到项目目录下，并在package文件的dependencies节点写入依赖，-S为该命令的缩写
- `npm install moduleName -save-dev`：–save-dev的意思是将模块安装到项目目录下，并在package文件的devDependencies节点写入依赖，-D为该命令的缩写

## Vue-Cli

 vue-cli 官方提供的一个脚手架,用于快速生成一个 vue 的项目模板;

 预先定义好的目录结构及基础代码，就好比咱们在创建 Maven 项目时可以选择创建一个骨架项目，这个骨架项目就是脚手架,我们的开发更加的快速;

> 主要功能

- 统一的目录结构
- 本地调试
- 热部署
- 单元测试
- 集成打包上线

> 安装

```shell
卸载
cnpm uninstall --global vue-cli

2.x版本
cnpm install --global vue-cli

3.x版本
cnpm install --global @vue/cli
```

> 构建项目

- 初始化项目

```shell
vue init webpack myvue
```

- 下载依赖

```shell
npm install
```

- 启动项目

```shell
npm run dev
```

## WebPack

WebPack 是一款**模块加载器兼打包工具**，它能把各种资源，如 JS、JSX、ES6、SASS、LESS、图片等**都作为模块来处理和使用。**

> 安装

```shell
npm install webpack -g
npm install webpack-cli -g
```

> 测试

- 在`modules`文件夹下创建`hello.js`文件

```javascript
//暴露一个方法
exports.sayHi = function () {
    document.write("<h1>狂神说ES6</h1>>")
}
```

- 在`modules`文件夹下创建`main.js`文件，此文件是默认入口

```javascript
var hello = require("./hello");
hello.sayHi()
```

- 在根目录创建webpack配置文件`webpack.config.js`

```javascript
module.exports = {
    entry: './modules/main.js',
    output: {
        filename: './js/bundle.js'
    }
}
```

- 在根路径运行打包命令

```shell\
webpack
```

- 可以查看到生成好的打包文件`.\js\bundle.js`

## Vue-Router

 Vue Router是Vue.js官方的**路由管理器**（路径跳转）。它和Vue.js的核心深度集成，让构建单页面应用变得易如反掌。

- 安装

```shell
npm install vue-router@3.1.3 --save-dev
```

- 创建子页面

`Page1.vue`

```vue
<template>
  <h1>子页面1</h1>
</template>

<script>
    export default {
        name: "Page1"
    }
</script>

<style scoped>

</style>
```

`Page2.vue`

```vue
<template>
  <h1>子页面2</h1>
</template>

<script>
    export default {
        name: "Page2"
    }
</script>

<style scoped>

</style>
```

- 创建vue-router配置文件`src\router\index.js`

```javascript
import Vue from "vue";
import VueRouter from "vue-router";
import Page1 from "../components/Page1";
import Page2 from "../components/Page2";

//安装路由
Vue.use(VueRouter);

//配置导出路由
export default new VueRouter({
  routes: [
    {
      //路由路径
      path: '/page1',
      name: 'page1',
      //跳转的组件
      component: Page1
    },
    {
        //路由路径
        path: '/page2',
        name: 'page2',
        //跳转的组件
        component: Page2
    }
  ]
})
```

- 修改`main.js`

```javascript
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router' //自动扫描里面的路由配置

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  router,
  template: '<App/>'
})
```

- 修改`App.vue`

```vue
<template>
  <div id="app">
    <h1>Vue-Router</h1>

    <router-link to="/page1">子页1</router-link>
    <router-link to="/page2">子页2</router-link>
    <router-view></router-view>

  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
```

- 启动测试

### 路由嵌套

- 安装并配置ElementUI，`mian.js`

```javascript
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router' //自动扫描里面的路由配置
import ElementUI from "element-ui"
//导入element css
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false

Vue.use(router);
Vue.use(ElementUI);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  router,
  render: h => h(App),//ElementUI规定这样使用
})
```

- 创建`Login.vue`

```vue
<template>
  <div>
    <el-form ref="loginForm" :model="form" :rules="rules" label-width="80px" class="login-box">
      <h3 class="login-title">欢迎登录</h3>
      <el-form-item label="账号" prop="username">
        <el-input type="text" placeholder="请输入账号" v-model="form.username"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" placeholder="请输入密码" v-model="form.password"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" v-on:click="onSubmit('loginForm')">登录</el-button>
      </el-form-item>
    </el-form>

    <el-dialog
      title="温馨提示"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <span>请输入账号和密码</span>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        form: {
          username: '',
          password: ''
        },

        // 表单验证，需要在 el-form-item 元素中增加 prop 属性
        rules: {
          username: [
            {required: true, message: '账号不可为空', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '密码不可为空', trigger: 'blur'}
          ]
        },

        // 对话框显示和隐藏
        dialogVisible: false
      }
    },
    methods: {
      onSubmit(formName) {
        // 为表单绑定验证功能
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 使用 vue-router 路由到指定页面，该方式称之为编程式导航
            this.$router.push("/main");
          } else {
            this.dialogVisible = true;
            return false;
          }
        });
      }
    }
  }
</script>

<style lang="scss" scoped>
  .login-box {
    border: 1px solid #DCDFE6;
    width: 350px;
    margin: 180px auto;
    padding: 35px 35px 15px 35px;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    box-shadow: 0 0 25px #909399;
  }

  .login-title {
    text-align: center;
    margin: 0 auto 40px auto;
    color: #303133;
  }
</style>
```

- 创建`Main.vue`

```vue
<template>
  <div>
    <el-container>
      <el-aside width="200px">
        <el-menu :default-openeds="['1']">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-caret-right"></i>用户管理</template>
            <el-menu-item-group>
              <el-menu-item index="1-1">
                <!--插入的地方-->
                <router-link to="/user/profile">个人信息</router-link>
              </el-menu-item>
              <el-menu-item index="1-2">
                <!--插入的地方-->
                <router-link to="/user/list">用户列表</router-link>
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-caret-right"></i>内容管理</template>
            <el-menu-item-group>
              <el-menu-item index="2-1">分类管理</el-menu-item>
              <el-menu-item index="2-2">内容列表</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="text-align: right; font-size: 12px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-header>
        <el-main>
          <!--在这里展示视图-->
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script>
  export default {
    name: "Main"
  }
</script>
<style scoped>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  .el-aside {
    color: #333;
  }
</style>
```

- 创建两个子页

`List.vue`

```vue
<template>
  <h1>用户列表</h1>
</template>
<script>
  export default {
    name: "UserList"
  }
</script>
<style scoped>
</style>
```

`Profile.vue`

```vue
<template>
  <h1>个人信息</h1>
</template>
<script>
  export default {
    name: "UserProfile"
  }
</script>
<style scoped>
</style>
```

- 编写路由配置文件

```javascript
import Vue from "vue";
import VueRouter from "vue-router";
import Main from "../components/Main";
import Login from "../components/Login";
import Profile from "../components/user/Profile";
import List from "../components/user/List";

//安装路由
Vue.use(VueRouter);

//配置导出路由
export default new VueRouter({
  routes: [
    {
      path: '/main',
      component: Main,
      //路由嵌套
      children: [
        {path: '/user/profile',component: Profile},
        {path: '/user/list',component: List}
      ]
    },
    {
      path: '/login',
      component: Login
    }
  ]
})
```

- 测试

### 参数传递

- 修改`<router-link>`标签中的`to`属性为对象值

```vue
<router-link v-bind:to="{name: 'Profile', params: {id: 1}}">个人信息</router-link>
```

- 修改路由配置，添加`props：true`属性

```javascript
{
  path: '/user/profile/:id',
  name: 'Profile',
  component: Profile,
  props:true
}
```

- 在要展示的组件Profile.vue中接收参数

```vue
<template>
  <div>
    个人信息
    {{ id }}
  </div>
</template>
<script>
    export default {
      props: ['id'],
      name: "UserProfile"
    }
</script>
<style scoped>
</style>
```

### 组件重定向

直接通过路由就可完成重定向

```javascript
{
  path: '/main',
  name: 'Main',
  component: Main
},
{
  path: '/goHome',
  redirect: '/main'
}
```

### 路由模式

- hash：路径带 # 符号，如 http://localhost/#/login
- history：路径不带 # 符号，如 http://localhost/login

修改路由配置，代码如下：

```javascript
export default new Router({
  mode: 'history',
  routes: [
  ]
});
```

### 404页面

- 创建`NotFound.vue`

```vue
<template>
    <div>
      <h1>404,你的页面走丢了</h1>
    </div>
</template>
<script>
    export default {
        name: "NotFound"
    }
</script>
<style scoped>
</style>
```

- 添加路由配置

```javascript
import NotFound from '../views/NotFound'
{
   path: '*',
   component: NotFound
}
```

### 路由守卫（钩子函数）

`beforeRouteEnter`：在进入路由前执行
`beforeRouteLeave`：在离开路由前执行

```javascript
export default {
    name: "Profile",
    beforeRouteEnter: (to, from, next) => {
        console.log("准备进入个人信息页");
        next();
    },
    beforeRouteLeave: (to, from, next) => {
        console.log("准备离开个人信息页");
        next();
    }
}
```

> 参数

- to：路由将要跳转的路径信息
- from：路径跳转前的路径信息
- next：路由的控制参数
- next() 跳入下一个页面
- next(’/path’) 改变路由的跳转方向，使其跳到另一个路由
- next(false) 返回原来的页面
- next((vm)=>{}) 仅在 beforeRouteEnter 中可用，vm 是组件实例

==可以在beforeRouteEnter函数里使用Axios，页面加载前异步请求数据==

## ElementUI

官网：https://element.eleme.cn/

> 使用

- 安装

```shell
npm i element-ui -S
# 安装 SASS 加载器
cnpm install sass-loader@7.3.1 --save-dev
```

- 配置

```javascript
import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';

Vue.use(ElementUI);

new Vue({
  el: '#app',
  render: h => h(App)
});
```

## Vue与Springboot项目的整合

打包会得到一个dist文件夹，将dist文件内的东西(一个文件夹+一个index.html文件)复制到Springboot项目下的resources/static中，完成整合

```shell
npm run build
```

