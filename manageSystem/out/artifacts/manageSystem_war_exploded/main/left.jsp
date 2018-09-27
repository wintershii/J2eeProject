<%--
  Created by IntelliJ IDEA.
  User: wintershii
  Date: 2018/9/27
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="../js/jquery.js"></script>

    <script type="text/javascript">
        $(function(){
            //导航切换
            $(".menuson .header").click(function(){
                var $parent = $(this).parent();
                $(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();

                $parent.addClass("active");
                if(!!$(this).next('.sub-menus').size()){
                    if($parent.hasClass("open")){
                        $parent.removeClass("open").find('.sub-menus').hide();
                    }else{
                        $parent.addClass("open").find('.sub-menus').show();
                    }


                }
            });

            // 三级菜单点击
            $('.sub-menus li').click(function(e) {
                $(".sub-menus li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function(){
                var $ul = $(this).next('ul');
                $('dd').find('.menuson').slideUp();
                if($ul.is(':visible')){
                    $(this).next('.menuson').slideUp();
                }else{
                    $(this).next('.menuson').slideDown();
                }
            });
        })
    </script>
</head>

<body style="background:#fff3e1;">
<div class="lefttop"><span></span>功能目录</div>

<dl class="leftmenu">

    <dd>
        <div class="title">
            <span><img src="../images/leftico01.png" /></span>管理信息
        </div>
        <ul class="menuson">

            <li>
                <div class="header">
                    <cite></cite>
                    <a href="" target="">首页模版</a>
                    <i></i>
                </div>
                <ul class="sub-menus">
                    <li><a href="javascript:;">文件管理</a></li>
                    <li><a href="javascript:;">模型信息配置</a></li>
                    <li><a href="javascript:;">基本内容</a></li>
                    <li><a href="javascript:;">自定义</a></li>
                </ul>
            </li>

            <li>
                <div class="header">
                    <cite></cite>
                    <a href="" target="">数据列表</a>
                    <i></i>
                </div>
                <ul class="sub-menus">
                    <li><a href="javascript:;">文件数据</a></li>
                    <li><a href="javascript:;">学生数据列表</a></li>
                    <li><a href="javascript:;">我的数据列表</a></li>
                    <li><a href="javascript:;">自定义</a></li>
                </ul>
            </li>

        </ul>
    </dd>


</dl>

</body>
</html>