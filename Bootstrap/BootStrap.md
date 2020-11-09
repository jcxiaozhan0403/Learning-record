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
随着视口尺寸的增加，系统会自动分为最多12份

