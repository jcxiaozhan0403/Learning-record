<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2021/9/29
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #page_navigation a{
        padding:3px;
        border:1px solid gray;
        margin:2px;
        color:black;
        text-decoration:none
    }
    .active_page{
        background:darkblue;
        color:white !important;
    }
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
    $(function(){

        //每页显示的数目
        var show_per_page = 5;
        //获取content对象里面，数据的数量
        var number_of_items = $('#content').children().size();
        //计算页面显示的数量
        var number_of_pages = Math.ceil(number_of_items/show_per_page);

        //隐藏域默认值
        $('#current_page').val(0);
        $('#show_per_page').val(show_per_page);

        var navigation_html = '<a class="previous_link" href="javascript:previous();">上一页</a>';
        var current_link = 0;
        while(number_of_pages > current_link){
            navigation_html += '<a class="page_link" href="javascript:go_to_page(' + current_link +')" longdesc="' + current_link +'">'+ (current_link + 1) +'</a>';
            current_link++;
        }
        navigation_html += '<a class="next_link" href="javascript:next();">下一页</a>';

        $('#page_navigation').html(navigation_html);

        //add active_page class to the first page link
        $('#page_navigation .page_link:first').addClass('active_page');

        //隐藏该对象下面的所有子元素
        $('#content').children().css('display', 'none');

        //显示第n（show_per_page）元素
        $('#content').children().slice(0, show_per_page).css('display', 'block');

    });

    //上一页
    function previous(){
        new_page = parseInt($('#current_page').val()) - 1;
        //if there is an item before the current active link run the function
        if($('.active_page').prev('.page_link').length==true){
            go_to_page(new_page);
        }

    }
    //下一页
    function next(){
        new_page = parseInt($('#current_page').val()) + 1;
        //if there is an item after the current active link run the function
        if($('.active_page').next('.page_link').length==true){
            go_to_page(new_page);
        }

    }
    //跳转某一页
    function go_to_page(page_num){
        //get the number of items shown per page
        var show_per_page = parseInt($('#show_per_page').val());

        //get the element number where to start the slice from
        start_from = page_num * show_per_page;

        //get the element number where to end the slice
        end_on = start_from + show_per_page;

        //hide all children elements of content div, get specific items and show them
        $('#content').children().css('display', 'none').slice(start_from, end_on).css('display', 'block');

        /*get the page link that has longdesc attribute of the current page and add active_page class to it
        and remove that class from previously active page link*/
        $('.page_link[longdesc=' + page_num +']').addClass('active_page').siblings('.active_page').removeClass('active_page');

        //update the current page input field
        $('#current_page').val(page_num);
    }

</script>
<body>
</body>
</html>
