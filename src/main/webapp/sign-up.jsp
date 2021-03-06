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

                <form action="/customer/sign-up" method="post" >

                    <div class="form-row x-row" >
                        <label class="x-cell-1">
                            <i class="fa fa-user"></i>
                        </label>
                        <span class="x-cell-11">
                            <input type="text" name="username" placeholder="请输入用户名">
                        </span>
                    </div>

                    <div class="form-row x-row" >
                        <label class="x-cell-1">
                            <i class="fa fa-lock"></i>
                        </label>
                        <span class="x-cell-11">
                            <input type="password" name="password" placeholder="请输入密码">
                        </span>
                    </div>

                    <div class="form-row x-row" >
                        <label class="x-cell-1">
                            <i class="fa fa-key"></i>
                        </label>
                        <span class="x-cell-11">
                            <input type="password" name="confirm" placeholder="请确认密码">
                        </span>
                    </div>

                    <div class="form-row x-row" >
                        <label class="x-cell-1">
                            <i class="fa fa-phone"></i>
                        </label>
                        <span class="x-cell-11">
                            <input type="text" name="telephone" placeholder="请输入手机号码">
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

                    <div class="form-row x-row submit" >
                        <span class="x-offset-1 x-cell-11" >
                            <input type="submit" value="注册">
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
