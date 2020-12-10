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

117