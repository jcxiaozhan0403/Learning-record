#1. 动画

	1. 三种方式显示和隐藏元素
		1. 默认显示和隐藏方式
			1. show([speed,[easing],[fn]])
				1. 参数：
					1. speed：动画的速度。三个预定义的值("slow","normal", "fast")或表示动画时长的毫秒数值(如：1000)
						* slow：慢的
						* normal：中的
						* fast：快的
					2. easing：用来指定切换效果，默认是"swing"，可用参数"linear"
						* swing：动画执行时效果是 先慢，中间快，最后又慢
						* linear：动画执行时速度是匀速的
					3. fn：在动画完成时执行的函数，每个元素执行一次。
	
			2. hide([speed,[easing],[fn]])
			3. toggle([speed],[easing],[fn])
		
		2. 滑动显示和隐藏方式
			1. slideDown([speed],[easing],[fn])
			2. slideUp([speed,[easing],[fn]])
			3. slideToggle([speed],[easing],[fn])
	
		3. 淡入淡出显示和隐藏方式
			1. fadeIn([speed],[easing],[fn])
			2. fadeOut([speed],[easing],[fn])
			3. fadeToggle([speed,[easing],[fn]])
##代码演示：显示或隐藏的动画

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>

        <script>
            //隐藏div
            function hideFn(){
               /*$("#showDiv").hide("normal","linear",function(){
                    alert("隐藏了...")
                });*/

                //默认方式
                // $("#showDiv").hide(1000,"swing");

                //滑动方式
                // $("#showDiv").slideUp("slow");

                //淡入淡出方式
                $("#showDiv").fadeOut("slow","swing");
            }

            //显示div
            function showFn(){
                /*$("#showDiv").show("slow","swing",function(){
                    alert("显示了...")
                });*/

                //默认方式
                // $("#showDiv").show(5000,"linear");

                //滑动方式
                $("#showDiv").slideDown("slow");

                //淡入淡出方式
                // $("#showDiv").fadeIn("slow");
            }


            //切换显示和隐藏div
            function toggleFn(){

                //默认方式
                // $("#showDiv").toggle("slow");
                
                //滑动方式
                $("#showDiv").slideToggle("slow","swing",function () {
                    alert("哈哈")
                });

                //淡入淡出方式
                // $("#showDiv").fadeToggle("slow");
            }
        </script>

    </head>
    <body>
        <input type="button" value="点击按钮隐藏div" onclick="hideFn()">
        <input type="button" value="点击按钮显示div" onclick="showFn()">
        <input type="button" value="点击按钮切换div显示和隐藏" onclick="toggleFn()">

        <div id="showDiv" style="width:300px;height:300px;background:pink">
            div显示和隐藏
        </div>
    </body>
</html>
```

#2. 遍历

	1. js的遍历方式
		* for(初始化值;循环结束条件;步长)
	2. jq的遍历方式
		1. jq对象.each(callback)
			1. 语法：
				jquery对象.each(function(index,element){});
					* index:就是元素在集合中的索引
					* element：就是集合中的每一个元素对象
	
					* this：集合中的每一个元素对象
			2. 回调函数返回值：
				* true:如果当前function返回为false，则结束循环(break)。
				* false:如果当前function返回为true，则结束本次循环，继续下次循环(continue)
		2. $.each(object, [callback])
		3. for..of: jquery 3.0 版本之后提供的方式
			for(元素对象 of 容器对象)
##代码演示：遍历

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <script src="../js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
    
                $(function () {
                    //1.获取所有的ul下的li
                    var citys = $("#city li");
                    //2.遍历li
                    /*for (var i = 0; i < citys.length; i++) {
                        if("上海" == citys[i].innerHTML){
                            //break; 结束循环
                            //continue; //结束本次循环，继续下次循环
                        }
                        //获取内容
                        alert(i+":"+citys[i].innerHTML);
    
                    }*/
    
                    //2. jq对象.each(callback)
                    /*citys.each(function () {
                        //3.1 获取li对象 第一种方式 this
                        //alert(this.innerHTML);
                        //alert($(this).html());
                    });*/
    
                    /*citys.each(function (index,element) {
                        //3.2 获取li对象 第二种方式 在回调函数中定义参数   index（索引） element（元素对象）
                        //alert(index+":"+element.innerHTML);
                        //alert(index+":"+$(element).html());
    
                        //判断如果是上海，则结束循环
                        if("上海" == $(element).html()){
                            //如果当前function返回为false，则结束循环(break)。
                            //如果返回为true，则结束本次循环，继续下次循环(continue)
                            return true;
                        }
                        alert(index+":"+$(element).html());
                    });*/
    
                    //3 $.each(object, [callback]):$指的就是citys对象
                   /* $.each(citys,function () {
                        alert($(this).html());
                    });*/
    
                   //4. for ... of:jquery 3.0 版本之后提供的方式
                    for(li of citys){
                        // li是js对象
                        alert($(li).html());
                        // alert(li.innerHTML)
                    }
                });
            
        </script>
    </head>
    <body>
        <ul id="city">
            <li>北京</li>
            <li>上海</li>
            <li>天津</li>
            <li>重庆</li>
        </ul>
    </body>
</html>
```

#3. 事件绑定

##1. jquery标准的绑定方式
	* jq对象.事件方法(回调函数)；
	* 注：如果调用事件方法，不传递回调函数，则会触发浏览器默认行为。
		* 表单对象.submit();//让表单提交
```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <script src="../js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">

            $(function () {
               //1.获取name对象，绑定click事件
               /*$("#name").click(function () {
                   alert("我被点击了...")
               });*/

               //给name绑定鼠标移动到元素之上事件。绑定鼠标移出事件
                /*$("#name").mouseover(function () {
                   alert("鼠标来了...")
                });

                $("#name").mouseout(function () {
                    alert("鼠标走了...")
                });*/

                //简化操作，链式编程
                /*$("#name").mouseover(function () {
                    alert("鼠标来了...")
                }).mouseout(function () {
                    alert("鼠标走了...")
                });*/

                //焦点事件
                $("#name").focus(function () {
                    alert("获得焦点了...")
                });//让文本输入框获得焦点

            });

        </script>
    </head>
    <body>
        <input id="name" type="text" value="绑定点击事件">
    </body>
</html>
```

##2. on绑定事件/off解除绑定
	* jq对象.on("事件名称",回调函数)
	* jq对象.off("事件名称")
		* 如果off方法不传递任何参数，则将组件上的所有事件全部解绑
```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <script src="../js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            $(function () {
               //1.使用on给按钮绑定单击事件  click
               $("#btn").on("click",function () {
                   alert("我被点击了。。。")
               }) ;

               //2. 使用off解除btn按钮的单击事件
                $("#btn2").click(function () {
                    //解除btn按钮的单击事件
                    // $("#btn").off("click");
                    $("#btn").off();//将组件上的所有事件全部解绑
                });
            });
        </script>
    </head>
    <body>
        <input id="btn" type="button" value="使用on绑定点击事件">
        <input id="btn2" type="button" value="使用off解绑点击事件">
    </body>
</html>
```



##3. 事件切换：toggle
	* jq对象.toggle(fn1,fn2...)
		* 当单击jq对象对应的组件后，会执行fn1.第二次点击会执行fn2.....
		
	* 注意：1.9版本 .toggle() 方法删除,jQuery Migrate插件可以恢复此功能。
		 <script src="../js/jquery-migrate-1.0.0.js" type="text/javascript" charset="utf-8"></script>
```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <script src="../js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
        <script src="../js/jquery-migrate-1.0.0.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            $(function () {
               //获取按钮，调用toggle方法
               $("#btn").toggle(function () {
                   //改变div背景色backgroundColor 颜色为 green
                   $("#myDiv").css("backgroundColor","green");
               },function () {
                   //改变div背景色backgroundColor 颜色为 red
                   $("#myDiv").css("backgroundColor","red");
               },function () {
                   //改变div背景色backgroundColor 颜色为 red
                   $("#myDiv").css("backgroundColor","blue");
               });
            });
        </script>
    </head>
    <body>
        <input id="btn" type="button" value="事件切换">
        <div id="myDiv" style="width:300px;height:300px;background:pink;">
            点击按钮变色
        </div>
    </body>
</html>
```



#4. 案例

##广告的自动显示与隐藏

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>广告的自动显示与隐藏</title>
        <style>
            #content{width:100%;height:500px;background:#999}
        </style>

        <!--引入jquery-->
        <script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
        <script>
            /*
                需求：
                    1. 当页面加载完，3秒后。自动显示广告
                    2. 广告显示5秒后，自动消失。
                分析：
                    1. 使用定时器来完成。setTimeout (执行一次定时器)
                    2. 分析发现JQuery的显示和隐藏动画效果其实就是控制display
                    3. 使用show/hide方法来完成广告的显示和隐藏
             */

            //入口函数，在页面加载完成之后，定义定时器，调用这两个方法
            $(function () {
               //定义定时器，调用adShow方法 3秒后执行一次
               setTimeout(adShow,3000);
               //定义定时器，调用adHide方法，8秒后执行一次
                setTimeout(adHide,8000);
            });
            //显示广告
            function adShow() {
                //获取广告div，调用显示方法
                $("#ad").show("slow");
            }
            //隐藏广告
            function adHide() {
                //获取广告div，调用隐藏方法
                $("#ad").hide("slow");
            }
        </script>
    </head>
    <body>
        <!-- 整体的DIV -->
        <div>
            <!-- 广告DIV -->
            <div id="ad" style="display: none;">
                <img style="width:100%" src="../img/adv.jpg" />
            </div>

            <!-- 下方正文部分 -->
            <div id="content">
                正文部分
            </div>
        </div>
    </body>
</html>
```

