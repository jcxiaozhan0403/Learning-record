## MVVM

<img src="./MVVM.jpg">

### View层
- 视图层
- 在我们前端开发中，通常就是DOM层
- 主要的作用是给用户展示各种信息

#### Model层
- 数据层
- 数据可能是我们固定的死数据，更多的是来自我们服务器，从网络上请求下来的数据
- 在我们计数器的案例中，就是后面抽取出来的obj，当然，里面的数据可能没有这么简单

### ViewModel层
- 视图模型层
- 视图模型层是View和 Model沟通的桥梁
- 一方面它实现了Data Binding，也就是数据绑定，将Model的改变实时的反应到View中
- 另一方面它实现了DOM Listener，也就是DOM监听，当DOM发生一些事件(点击、滚动、 touch等)时，可以监听
到，并在需要的情况下改变对应的Data

## 向Vue实例传入的options
所有选项：[https://cn.vuejs.org/v2/api/](https://cn.vuejs.org/v2/api/)

三个常用选项
- el:
    类型：string | HTMLElement
    作用：指定Vue实例接管的DOM
- data:
    类型：Object | Function(在vue组件中data必须是一个函数)
    作用：Vue实例对应的数据对象
- methods:
    类型：Function
    作用：定义属于Vue的一些方法，可以在其他地方调用

## 生命周期

<img src="./Vue生命周期.jpg">

## 基础语法
> v-once

该指令表示元素和组件只渲染一次，不会随着数据的改变而改变
```html
<h2 v-once>{{msg}}</h2>

data: {
    msg: '你好'
}
```

> v-html

该指令在渲染页面时，如果数据是一个html标签，会对其进行解析
```html
<h2 v-html="url"></h2>

data: {
    url: '<a href="www.baidu.com">百度</a>'
}
```

> v-text

该指令在渲染页面时，如果数据是一个html标签，不会对其进行解析，会原封不动以字符串的形式渲染到页面上
```html
<h2 v-html="url"></h2>

data: {
    url: '<a href="www.baidu.com">百度</a>'
}
```

> v-pre

该指令使标签不进行数据绑定，按照原格式输出到页面
```html
<h2 v-pre>{{msg}}</h2>

data: {
    msg: '你好'
}
```

> v-bind

该指令用于动态绑定属性值，属性值由data里面的变量来赋予
```html
<a v-bind:href="url">淘宝</a>
<!-- 简写 -->
<a :href="url2">百度一下</a>

data: {
    url: 'https://www.taobao.com/',
    url2: 'www.baidu.com'
},
```
可以用该指令来动态地控制class属性
```html
<!-- 通过data动态控制class，如果class原本定义了值，会进行合并 -->
<h2 class="demo" :class="{active: isActive, line: isLine}">{{msg}}</h2>

data: {
    msg: '你好',
    isActive: true,
    isLine: true
}
```

## 计算属性
当多个属性值需要处理之后再展示到页面上的时候，推荐使用计算属性，计算属性有缓存机制，比方法好一些
```html
<div id='app'>
    {{fullName}}
</div>

data: {
    msg: '你好',
    firstName: '张',
    lastName: '三'
}

computed: {
    fullName() {
        return this.firstName + ' ' + this.lastName;
    }
}
```