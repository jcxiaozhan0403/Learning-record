## DTD(文档类型定义)
HTML4.01和XHTML1.0的三种模式
- 严格模式 strict
- 过渡模式 loose
- 框架集 frameset

HTML5的DTD`<!DOCTYPE html>`

## 编码设置
HTML4.01
```
<meta http-equiv="content-type" content="text/html;charset=utf-8">
```
HTML5
```
<meta charset="utf-8">
```
ANSI：扩展的ASCII编码
gb2312：中文的一种编码，兼容win，在ANSI的基础上增加汉字
gbk：在gb2312的基础上扩展

避免网页乱码：网页设置的编码格式与网页编码相同

**格式化:以一定规则输出或者显示内容**

```html
<!-- 加在头部，相当于总链接 -->
<base href="https://www.baidu.com">

<!--  定义文字方向 -->
<!-- direct 方向 -->
<bdo dir="ltr"></bdo>

<!-- 缩写 -->
<abbr title="中华人民共和国">中国</abbr>

<!-- 地址 -->
<address></address>

<!-- 表格标题(放在tabale和tr之间) -->
<caption></caption>

<!-- cloumn定义单元格宽度 -->
<colgroup>
<col>
</colgroup>

<!-- 导航 -->
<nav></nav>

<!-- 进度条 -->
<progress max="" value=""></progress>

<!-- 音频 -->
<audio></audio>

<!-- 视频 -->
<video></video>
```

## 表单相关元素和属性
```
form表单默认提交格式为get

name=22&grsdeCode=33&class=44

pattern //input属性，放正则表达式

novalidate //form属性，有true or false两种值，控制表单数据验证
```

## 弹性布局
```css
/* 设置对外层包裹容器display:flex */
/* 子元素自动成为容器成员 */

/* 横向对齐方式 */
/* 居中对齐 */
justify-content:center;
/* 靠右对齐 */
justify-content:flex-end;
/* 左右两端对齐，每个子项间距相等 */
justify-content:space-between;
/* 项目之间的间距为左右两端项目到容器间距的两倍 */
justify-content:space-around;
/* 所有间距相等 */
justify-content:space-evenly;

/* 垂直方向对齐方式 */
/* 默认位置(靠上对齐) */
align-items:flex-start;
/* 居中对齐 */
align-items:center;
/* 靠下对齐 */
align-items:flex-end;

/* 项目排列方向 */
/* 自左向右(默认) */
flex-direction:row;
/* 自右向左 */
flex-direction:row-reverse;
/* 自上向下 */
flex-direction:column;
/* 自下向上 */
flex-direction:column-reverse;

/* 换行方式 */
/* 不换行，按照容器大小自动压缩子元素(默认) */
flex-wrap:nowrap;
/* 换行 */
flex-wrap:wrap;
```

## 拖放
```
drapstart

dragover

drop
```

## 画布
```html
<!-- 新建画布 -->
<canvas id="myCanvas" width="200" height="100"></canvas>
```

```css
td[lang]{

}

```
