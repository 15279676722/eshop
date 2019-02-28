<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%

    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
    var message = '<%=session.getAttribute("message")%>';
    console.log(message)
    if (message=="null") {
        message = ""
    }
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>

<html lang="en">
<html>
<head>
    <meta charset="UTF-8">
    <title>新用户注册</title>

    <%--## 导入通用的样式库--%>
    <link rel="stylesheet" href="/styles/org.malajava.generic.css" type="text/css">
    <%--## 导入 Font Awesome 的样式库--%>
    <link rel="stylesheet" href="/font-awesome/css/font-awesome.css" type="text/css">
    <script type="text/javascript" src="/scripts/org.malajava.generic.js"></script>

    <link rel="stylesheet" href="styles/org.sign.css" type="text/css">
    <link rel="stylesheet" href="styles/org.sign.header.css" type="text/css">
    <link rel="stylesheet" href="styles/org.sign.footer.css" type="text/css">

</head>
<body>
<%@include file="/commons/header.jsp"%>
<%--#parse("/commons/header.vm")--%>
<div class="include" >
    <div class="dialog">
        <div class="dialog-title x-row">
            <div class="x-row">
                <h2 style="text-align: center ; color:  red ;">
                    <div id="test">
                        <script type="text/javascript">
                            document.getElementById("test").innerHTML=message;
                        </script>
                    </div>
                </h2>
            </div>

            <form action="/customer/updateinformation" method="post" >

                <div class="form-row x-row" >
                    <label class="x-cell-1">
                        <i class="fa fa-user"></i>
                    </label>
                    <span class="x-cell-11">
                            <input type="text" name="name" placeholder="请输入姓名">
                        </span>
                </div>

                <div class="form-row x-row" >
                    <label class="x-cell-1">
                        <i class="fa fa-lock"></i>
                    </label>
                    <span class="x-cell-11">
                            <input type="text" name="gender" placeholder="请输入性别">
                        </span>
                </div>

                <div class="form-row x-row" >
                    <label class="x-cell-1">
                        <i class="fa fa-key"></i>
                    </label>
                    <span class="x-cell-11">
                            <input type="date" name="birthdate" placeholder="请输入出生日期">
                        </span>
                </div>
                <div class="identify-row x-row" >
                    <label class="x-cell-6">
                        <input type="text" name="identify" placeholder="请输入验证码">
                    </label>
                    <span class="x-cell-6">
                            <img src="/customer/identify" onclick="X.refresh(this)">
                        </span>
                </div>

                <div class="form-row x-row" >
                        <span class="x-offset-1 x-cell-11" >
                            <input type="submit" value="确认修改">
                        </span>
                </div>

            </form>
        </div>
    </div>
</div>
<%@include file="/commons/footer.jsp"%>
<%--#parse("/commons/footer.vm")--%>

</body>
</html>

<%--<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>--%>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>

<%--<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">--%>
<%--<!DOCTYPE html>--%>

<%--<html lang="en">--%>
<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>Title</title>--%>

    <%--<link rel="stylesheet" href="/styles/org.malajava.generic.css" type="text/css">--%>

    <%--<link rel="stylesheet" href="/font-awesome/css/font-awesome.css" type="text/css">--%>
    <%--<script type="text/javascript" src="/scripts/org.malajava.generic.js"></script>--%>
    <%--<style type="text/css" >--%>
        <%--.mask{--%>
            <%--position: fixed ;--%>
            <%--width: 100% ;--%>
            <%--height: 100% ;--%>
            <%--background-color: rgba(255, 50, 199, 0.17);--%>
        <%--}--%>
        <%--.dialog {--%>
            <%--box-shadow: 3px 3px 3px 3px rgba(97, 255, 205, 0.17);--%>

            <%--background-color: #FFFFFF;--%>
            <%--position: absolute ;--%>
            <%--left: 50% ;--%>
            <%--top : 50% ;--%>
            <%--width: 400px ;--%>
            <%--margin-left: -200px ;--%>
            <%--height: 370px ;--%>
            <%--margin-top: -150px ;--%>
        <%--}--%>
        <%--.x-center-container{position: fixed ;width: 100% ;height: 100% ;background-color: rgba(255, 50, 199, 0.17);}--%>
        <%--.form-row , .identify-row { border: 1px solid transparent ; margin: 5px 5px ; }--%>
        <%--.form-row:hover , .identify-row:hover { border-color: blue ; margin: 5px 5px ; }--%>
        <%--.form-row label , .form-row span , .identify-row label , .identify-row span  { height: 50px ; line-height: 50px ; }--%>
        <%--.form-row label { text-align: center }--%>
        <%--.form-row span { text-align: left ;  }--%>
        <%--.form-row span input , .identify-row label input { border: none ; outline: none ;  line-height: 50px ; width: 95% ; }--%>
        <%--.identify-row label input { text-align: center ; }--%>
        <%--.xx{--%>

            <%--float: right;--%>
        <%--}--%>

        <%--.wlmm{--%>

            <%--position: absolute;--%>
            <%--right: 85px;--%>
            <%--bottom: 5px;--%>
        <%--}--%>
        <%--.zc{--%>

            <%--position: absolute;--%>
            <%--right: 5px;--%>
            <%--bottom: 5px;--%>
        <%--}--%>
        <%--.form-row>.x-offset-1 input[type=submit]{--%>
            <%--color: #FFFFFF;--%>
            <%--font-size: 20px;--%>
            <%--background-color: rgba(118, 255, 0, 0.68);--%>
        <%--}--%>
        <%--.xx span{--%>
            <%--color: black;--%>
        <%--}--%>

    <%--</style>--%>

<%--</head>--%>

<%--<body>--%>
<%--<%@include file="/commons/header.jsp"%>--%>
<%--<div class="mask" >--%>
    <%--<div class="dialog">--%>
        <%--<div class="dialog-title x-row">--%>
            <%--<div class="x-row">--%>
                <%--<h2 style="text-align: center ; color:  red ;">--%>
                <%--## 使用静默引用获取 session 中存储的错误提示信息--%>
                            <%--$!{session.message}--%>
                            <%--## 删除 session 中存在的错误提示信息--%>
                            <%--${session.removeAttribute( 'message' )}--%>
                <%--</h2>--%>
            <%--</div>--%>

            <%--<form action="/customer/updateinformation" method="post" >--%>

                <%--<div class="form-row x-row" >--%>
                    <%--<label class="x-cell-1">--%>
                        <%--<i class="fa fa-user"></i>--%>
                    <%--</label>--%>
                    <%--<span class="x-cell-11">--%>
                            <%--<input type="text" name="name" placeholder="请输入姓名">--%>
                        <%--</span>--%>
                <%--</div>--%>

                <%--<div class="form-row x-row" >--%>
                    <%--<label class="x-cell-1">--%>
                        <%--<i class="fa fa-lock"></i>--%>
                    <%--</label>--%>
                    <%--<span class="x-cell-11">--%>
                            <%--<input type="text" name="gender" placeholder="请输入性别">--%>
                        <%--</span>--%>
                <%--</div>--%>

                <%--<div class="form-row x-row" >--%>
                    <%--<label class="x-cell-1">--%>
                        <%--<i class="fa fa-key"></i>--%>
                    <%--</label>--%>
                    <%--<span class="x-cell-11">--%>
                            <%--<input type="date" name="birthdate" placeholder="请输入出生日期">--%>
                        <%--</span>--%>
                <%--</div>--%>
                <%--<div class="identify-row x-row" >--%>
                    <%--<label class="x-cell-6">--%>
                        <%--<input type="text" name="identify" placeholder="请输入验证码">--%>
                    <%--</label>--%>
                    <%--<span class="x-cell-6">--%>
                            <%--<img src="/customer/identify" onclick="X.refresh(this)">--%>
                        <%--</span>--%>
                <%--</div>--%>

                <%--<div class="form-row x-row" >--%>
                        <%--<span class="x-offset-1 x-cell-11" >--%>
                            <%--<input type="submit" value="确认修改">--%>
                        <%--</span>--%>
                <%--</div>--%>

            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<%@include file="/commons/footer.jsp"%>--%>
<%--</body>--%>



<%--</html>--%>