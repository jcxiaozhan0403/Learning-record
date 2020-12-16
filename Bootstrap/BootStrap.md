1024px 对应电脑
768px 对应paid
480px 对应手机

```html
<meta name="viewport" content="width=device-width, initial-scale=1.0">
```

桌面优先：
移动优先

媒体查询(简单响应式)
```css
/* 当屏幕宽度小于500px时 */
    @media screen and (max-width: 500px) {
        body{
            background-color: yellow;
        }
    }
```

## 栅格系统
Bootstrap的栅格系统会默认把一行，分成12列，运用栅格系统，可以做出table那样几列几行的效果
运用Bootstrap的栅格系统，首选需要准备一个class=container的div,表示整个表格
紧接着需要一个class=row的div，表示行,再挨着的div，就是列了
```html
<div class="container">
    <div class="row">
        <div class="col-xs-12 ">一共12列</div>
    </div>
</div>
<!-- 所占格数 -->
<!-- .col-xs- 超小屏幕 手机 (<768px) -->

<!-- .col-sm- 小屏幕 平板 (≥768px) -->

<!-- .col-md- 中等屏幕 桌面显示器 (≥992px) -->

<!-- .col-lg- 大屏幕 大桌面显示器 (≥1200px) -->

<!-- 偏移格数 -->
<!-- offset-md- -->

<div class="container">
    <div class="row">
        <div class="col-md-4 ">占4列</div>
        <div class="col-md-8 ">占8列</div>
    </div>
    <div class="row">
        <div class="col-md-4 ">占4列</div>
        <div class="col-md-4 offset-md-4">占4列，偏移4列</div>
    </div>

    <!-- 响应式栅格 -->
    <!-- 在不同设备下显示比例不同 -->
    <div class="row">
        <div class="col-sm-3 col-md-6 col-lg-4 col-xl-2"></div>
        <div class="col-sm-9 col-md-6 col-lg-8 col-xl-10"></div>
    </div>
</div>
```

## 列排序
```html
<!-- order -->
<!-- 数字越大越靠后，没有order属性，默认最高级 -->

<div class="col-xs-4 order-1">占4列，排第二</div>
<div class="col-xs-4">占4列，排第一</div>
<div class="col-xs-4 order-2">占4列，排第三</div>
```

## 超大文字尺寸
```html
<!-- display- 数字越小显示效果越大 -->
<p class="display-1">试试</p>
<p class="display-2">试试</p>
<p class="display-3">试试</p>
<p class="display-4">试试</p>
```

## 副标题 | 子标题
```html
<p class="small">试试</p>
```

## 文本对齐方式
```html
<p class="text-left">文本左对齐</p>
<p class="text-right">文本右对齐</p>
<p class="text-center">文本居中对齐</p>
<p class="text-justify">文本自动换行</p>
<p class="text-nowrap">文本不换行</p>
```

## 字母大小写
```html
<p class="text-lowercase">ABC字母小写</p>
<p class="text-uppercase">abc字母大写</p>
<p class="text-capitalize">abc首字母大写</p>
```

## 缩略语
```html
<abbr title="中华人民共和国">中国</abbr>
```

## 地址
```html
<address>四川信息职业技术学院</address>
```

## 列表
```html
<!-- 添加.list-unstyled类来去掉列表前的圆点 -->
<!-- 添加.list-inline类来使列表横向排列 -->

<ul class="list-unstyled list-inline">
    <li>第1个元素</li>
    <li>第2个元素</li>
    <li>第3个元素</li>
</ul>
```

## 表格
```html
<!-- 普通表格 -->
<table class="table">

<!-- 斑马表格 -->
<table class="table table-striped">

<!-- 带框线的表格 -->
<table class="table table-bordered">

<!-- 鼠标悬停高亮 -->
<table class="table table-hover">

<!-- 紧凑型表格 -->
<table class="table table-sm">

<!-- 响应式表格 -->
<!-- 默认在屏幕宽度小于992px时创建水平滚动条 -->
<table class="table table-responsive">

<!-- 在屏幕宽度小于576px时创建水平滚动条 -->
<table class="table table-responsive-sm">

<!-- 在屏幕宽度小于768px时创建水平滚动条 -->
<table class="table table-responsive-md">

<!-- 在屏幕宽度小于992px时创建水平滚动条 -->
<table class="table table-responsive-lg">

<!-- 在屏幕宽度小于1200px时创建水平滚动条 -->
<table class="table table-responsive-xl">
```

## 按钮
```html
<!-- 底色 -->
<button class="btn btn-primary">按钮</button>

<!-- 外框颜色 -->
<button class="btn btn-outline-primary">按钮</button>

<!-- 大号按钮 -->
<button class="btn btn-lg">按钮</button>

<!-- 小号按钮 -->
<button class="btn btn-sm">按钮</button>

<!-- 块级按钮 | 宽屏按钮 -->
<button class="btn btn-block">按钮</button>

<!-- 激活的按钮 -->
<button class="btn btn-primary active">按钮</button>

<!-- 禁用的按钮 -->
<button class="btn btn-primary disabled">按钮</button>
```

## 图片
```html
<!-- 响应式图片 -->
<img class="img-fluid">

<!-- 圆角 -->
<img class="rounded">

<!-- 椭圆图片 -->
<img class="rounded-circle">

<!-- 带边框的图片 -->
<img class="img-thumbnail">
```

## 表单
Bootstrap 提供了3种类型的表单布局：垂直表单（默认）、内联表单和水平表单。
```html
<!-- 基本结构 -->

<form role="form">
    <div class="form-group">
        <label for="username">账号</label>
        <input type="text" id="username" placeholder="请输入账号" class="form-control">
    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="text" id="password" placeholder="请输入密码" class="form-control">
    </div>
    <button type="submit" class="btn btn-default">提交</button>
</form>

<!-- 表单元素显示在同一行 -->
<form role="form" class="form-inline"></form>

<!-- 使用 .form-check-inline 类可以让选项显示在同一行 -->
<div class="form-check form-check-inline">
    <label class="form-check-label">
    <input type="checkbox" class="form-check-input" value="">Option 1
    </label>
</div>

<!-- 如果表单元素被包含在fieldset中，且fieldset被禁用，则里面的所有表单元素将被全部禁用。-->
<fieldset disabled></fieldset>
```

## 输入框组
```html
<form role="form">
    <!-- 在输入框前面添加内容 -->
    <div class="input-group">
    <div class="input-gruop-prepend">
        <span class="input-group-text">@</span>
    </div>
    <input type="text" class="form-control">
    </div>

    <!-- 在输入框后面添加内容 -->
    <div class="input-group">
    <input type="text" class="form-control">
    <div class="input-gruop-append">
        <span class="input-group-text">@</span>
    </div>
    </div>
</form>
```

## 组件

下拉菜单
```html
<!-- dropdown-menu-right和dropdown-menu-left控制菜单对齐方式，添加在ul上 -->
<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">选择网站</button>
<div class="dropdown-menu dropdown-menu-right">
    <a href="" class="dropdown-item">淘宝</a>
    <a href="" class="dropdown-item">京东</a>
    <a href="" class="dropdown-item">百度</a>
    <a href="" class="dropdown-item">阿里</a>
</div>

<!-- .dropdown-header加在li上可以给菜单添加小标题，.divider加在div上用作菜单分割线 -->
<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">打开菜单</button>
<div class="dropdown-menu">
    <p class="dropdown-header">菜单1</p>
    <a href="" class="dropdown-item">选项1</a>
    <a href="" class="dropdown-item">选项2</a>
    <div class="dropdown-divider"></div>
    <p class="dropdown-header">菜单2</p>
    <a href="" class="dropdown-item">选项1</a>
    <a href="" class="dropdown-item">选项2</a>
</div>

<!-- 给菜单div添加.dropup和.dropright和.dropleft可以控制菜单弹出的位置 -->
<button class="btn btn-primary dropdown-toggle" data-toggle="dropdown">选择网站</button>
<div class="dropdown-menu dropdown-menu-right .dropup">
    <a href="" class="dropdown-item">淘宝</a>
    <a href="" class="dropdown-item">京东</a>
    <a href="" class="dropdown-item">百度</a>
    <a href="" class="dropdown-item">阿里</a>
</div>
```

按钮组
```html
<div class="btn-group btn-group-vertical">
    <button class="btn btn-primary">第1个按钮</button>
    <button class="btn btn-primary">第2个按钮</button>
    <button class="btn btn-primary">第3个按钮</button>
</div>

<!-- 用btn-group-vertical来定义一个垂直排列的按钮组 -->
<div class="btn-group-vertical">
    <button class="btn btn-primary">第1个按钮</button>
    <button class="btn btn-primary">第2个按钮</button>
    <button class="btn btn-primary">第3个按钮</button>
</div>
```

导航(默认横向排列)
```html
<!-- 简单导航 -->
<ul class="nav">
    <li class="nav-item">第1个标签</li>
    <li class="nav-item">第2个标签</li>
    <li class="nav-item">第3个标签</li>
</ul>

<!-- 导航对齐方式 -->
<!-- .justify-content-center 类设置导航居中显示 -->
<ul class="nav justify-content-center">
    <li class="nav-item">第1个标签</li>
    <li class="nav-item">第2个标签</li>
    <li class="nav-item">第3个标签</li>
</ul>
<!-- .justify-content-end 类设置导航右对齐 -->
<ul class="nav justify-content-end">
    <li class="nav-item">第1个标签</li>
    <li class="nav-item">第2个标签</li>
    <li class="nav-item">第3个标签</li>
</ul>
<!-- .flex-column 类用于创建垂直导航 -->
<ul class="nav flex-column">
    <li class="nav-item">第1个标签</li>
    <li class="nav-item">第2个标签</li>
    <li class="nav-item">第3个标签</li>
</ul>
<!-- .nav-justified 创建宽屏导航，宽度撑满父元素，等宽显示每一项 -->
<ul class="nav nav-justified">
    <li class="nav-item">第1个标签</li>
    <li class="nav-item">第2个标签</li>
    <li class="nav-item">第3个标签</li>
</ul>

<!-- 导航样式 -->
<!-- .nav-tabs 创建选项卡导航 -->
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a href="#" class="nav-link active">链接1</a>
    </li>
    <li class="nav-item">
        <a href="#" class="nav-link">链接2</a>
    </li>
    <li class="nav-item">
        <a href="#" class="nav-link">链接3</a>
    </li>
</ul>

<!-- .nav-pills 创建胶囊导航 -->
<ul class="nav nav-pills">
    <li class="nav-item">
        <a href="#" class="nav-link active">链接1</a>
    </li>
    <li class="nav-item">
        <a href="#" class="nav-link">链接2</a>
    </li>
    <li class="nav-item">
        <a href="#" class="nav-link">链接3</a>
    </li>
</ul>

<!-- .breadcrumb 创建面包屑导航 -->
<ol class="breadcrumb">
    <li class="breadcrumb-item"></li>
    <li class="breadcrumb-item"></li>
</ol>
```

导航栏(默认垂直排列)
```html
<!-- 响应式导航栏，宽屏横向排列，小屏纵向排列 -->
<nav class="navbar-nav navbar-expand-md">
    <li class="nav-item">
        <a href="#" class="nav-link active">链接1</a>
    </li>
    <li class="nav-item">
        <a href="#" class="nav-link">链接2</a>
    </li>
    <li class="nav-item">
        <a href="#" class="nav-link">链接3</a>
    </li>
</nav>

<!-- .navbar-brand 类用于高亮显示品牌/Logo -->
<img class="navbar-brand" src="./demo.png" style="width: 50px; height: 50px;">

<a class="navbar-brand" href="#">Logo</a>

<!-- 折叠导航栏 -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
   <!-- Brand  -->
  <a class="navbar-brand" href="#">Navbar</a>
 
   <!-- Toggler/collapsibe Button  -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
 
   <!-- Navbar links  -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li> 
    </ul>
  </div> 
</nav>

<!-- 导航栏使用下拉菜单 -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                Dropdown link
            </a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Link 1</a>
                <a class="dropdown-item" href="#">Link 2</a>
                <a class="dropdown-item" href="#">Link 3</a>
            </div>
        </li>
    </ul>
</nav>

<!-- 导航栏的表单 <form> 元素使用 class=“form-inline” 类来排版输入框与按钮。-->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <form class="form-inline">
    <input class="form-control" type="text" placeholder="Search">
    <button class="btn btn-success" type="button">Search</button>
  </form>
</nav>

<!-- 用navbar-text来设置导航栏上的非链接文本，文本水平对齐，颜色与内边距一致 -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item">
            <span class="navbar-text">文本</span>
        </li>
    </ul>
</nav>

<!-- 导航栏可以固定在头部或者底部 -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top"></nav>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-bottom"></nav>
```


