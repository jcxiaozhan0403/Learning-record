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
<!-- col-xs-1 -->
<!-- 所占格数量 -->

<!-- offset-md-3 -->
<!-- 偏移格数 -->
<div class="container">
    <div class="row">
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
        <div class="col-xs-1 ">1列</div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-4 ">占4列</div>
        <div class="col-xs-4 ">占4列</div>
        <div class="col-xs-4 ">占4列</div>
    </div>
</div>
```

## 列排序
```html
<!-- order -->
<!-- 数字越大越靠后 -->
<div class="col-xs-4 order-1">占4列</div>
<div class="col-xs-4 order-2">占4列</div>
```

## 超大文字尺寸
```html
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
<table class="table table-responsive-sm">
```

## 按钮
```html
<!-- 底色 -->
<button class="btn btn-primary">提交按钮</button>

<!-- 外框颜色 -->
<button class="btn btn-outline-primary">提交按钮</button>

<!-- 大号按钮 -->
<button class="btn btn-lg">提交按钮</button>

<!-- 小号按钮 -->
<button class="btn btn-sm">提交按钮</button>

<!-- 块级按钮 -->
<button class="btn btn-block">提交按钮</button>
```

## 图片
```html
<!-- 响应式图片 -->

```
