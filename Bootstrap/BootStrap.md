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

