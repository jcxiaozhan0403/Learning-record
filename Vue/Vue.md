## vue是什么
vue是前端的一种开发框架，它主要解决前端开发中的核心痛点——复杂的DOM操作

## vue的特点
- 渐进式
- 组件化
- 响应式

## 环境搭建
1. 安装node.js
2. 下载淘宝镜像源代替npm
```
npm install -g cnpm -registry=https://registry.npm.taobao.org
```
3. 下载vue脚手架
```
卸载
cnpm uninstall --global vue-cli

2.x版本
cnpm install --global vue-cli

3.x版本
cnpm install --global @vue/cli
```
4. 创建项目
```
vue init webpack 项目名称(不可中文，不可大写)

创建过程报错
Ctrl+C结束任务，切换到项目目录内
执行如下命令
cnpm install
```
5. 运行项目
```
npm start
```

## 第一个vue程序
```html
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<body>
<div id="app">
    <!-- 法一 -->
  <p>{{ message }}</p>
    <!-- 法二 -->
  <p v-text="message"></p>
</div>

<script>
new Vue({
    // el挂载点用于锁定元素,相当于css选择器
  el: '#app',
    //data对象用于存放键值对数据，可用直接用键名获取数据
  data: {
    message: 'Hello Vue.js!'
  }
})
</script>
</body>
```

## 指令
v-text
```html
<!-- 法一 -->
<p>{{ message }}</p>
<!-- 法二 -->
<p v-text="message"></p>
<!-- 还可以是使用字符串的拼接 -->
<p v-text="message + '!!!'"></p>
```

v-html
```html
<!-- v-html用于存放内容为html标签的情况下 -->
<p v-html="message"></p>
```

v-on
```html
<!-- v-on用于事件触发 -->
<!-- 法一 -->
<input type="button" value="单击" @click="dolt">
<!-- 法二 -->
<input type="button" value="单击" v-on:dblclick="dolt">
```

v-show
```html
<!-- 布尔值判断，如果为true就显示为false就隐藏，本质是为元素加上一个display:none的css属性 -->
<!-- 法一：直接使用布尔值 -->
<img src="路径" v-show="true">
<!-- 法二：使用data中存放的布尔值 -->
<img src="路径" v-show="isShow">
<!-- 法三：通过判断得到布尔值 -->
<img src="路径" v-show="age>=18">
```

v-if
```html
<!-- 布尔值判断，如果为true就显示为false就隐藏，本质是在DOM树上直接增加或者删除元素 -->
<!-- 法一：直接使用布尔值 -->
<img src="路径" v-if="true">
<!-- 法二：使用data中存放的布尔值 -->
<img src="路径" v-if="isShow">
<!-- 法三：通过判断得到布尔值 -->
<img src="路径" v-if="age>=18">
```

v-bind
```html
<!-- v-bind用于设置元素属性值,属性值可存放在data中 -->
<!-- 法一 -->
<img v-bind:class="imgClass">
<!-- 法二：简写 -->
<img :class="imgClass">
```

v-model
```html
<!-- v-model用于表单元素的双向数据绑定(表单值改变会同步到data中，data中值改变会同步到表单中) -->
<input type="text" v-model="message">
```

## 事件修饰符
```
.stop 阻止冒泡
.prevent 阻止默认行为
.self 只监听自己触发的事件，不关心事件冒泡带来的事件
.once 只执行一次特定事件
```

## VueCli开发项目的方式
```
一切皆组件，组件是以.vue结尾的文件，其中的内容由js代码，html代码，css代码组成

1.VueCli开发方式是在项目中开发一个一个组件对应一个业务功能模块，日后可以将多个组件组合到一起形成一个前端系统

2.日后在使用vue Cli进行开发时不再书写html文件,编写的是一个个组件(组件后缀，vue结尾的文件)，日后打包时vue cli会将组件编译成运行的html文件
```

## Vue Cli中引入Axios异步
1. 下载axios
```
cnpm install axios --save-dev
```
2. 在main.js中引入axios
```javascript
import axios from 'axios'
```
3. main.js中添加语句
```javascript
Vue.prototype.$http=axios
```

## Axios请求
```javascript
this.$http.get("https://api.vvhan.com/api/ian").then((res)=>{

});
```

## Axios并发请求
```javascript
axios.add([axios.get(""),axios.post("",{})]).then(){
  axios.spread(function(res1,res2){

  })
}
```

## 路由
1. 在index.js中引入Vue组件
```javascript
import HelloWorld from '../components/HelloWorld'
```
2. 在index.js配置项中添加
```javascript
{path: '/',name: 'HelloWorld',component: HelloWorld} //name可选，不重要
```
3. 在Vue组件中添加标签来使用路由
```html
<!-- 专用标签 -->
<router-link to="/foo">foo</router-link>
<!-- a标签 -->
<a href="#/page2">page2</a>
```

## 子路由
1. 在index.js中引入Vue组件
```javascript
import Page2 from "../components/Page2"
import Page2Child from "../components/Page2Child"
```
2. 在index.js配置项中添加
```javascript
{
  path: '/page2',
  component: Page2,
  // 子页面
  children:[
    {path: 'child',component: Page2Child}
  ]
}
```
3. 在Vue组件中添加标签来使用路由
```html
<!-- 专用标签 -->
<router-link to="/page2/child">子页面</router-link>

<!-- a标签 -->
<a href="#/page2/child">子页面</a>
```

## Vue Cli中引入ElementUI
1. 下载
```
cnpm i element-ui -S
```
2. 在main.js中引入
```javascript
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
```
3. 在main.js中添加语句
```javascript
Vue.use(ElementUI)
```

## Vue与Springboor项目的整合
1. Vue项目打包
```
npm run build
```
2. 打包会的到一个dist文件夹，将dist文件内的东西(一个文件夹+一个index.html文件)赋值到Springboot项目下的resources/static中，完成整合

