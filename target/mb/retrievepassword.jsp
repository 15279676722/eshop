<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>找回密码</title>
## 导入通用的样式库
    <link rel="stylesheet" href="/styles/org.malajava.generic.css" type="text/css">
## 导入 Font Awesome 的样式库
    <link rel="stylesheet" href="/font-awesome/css/font-awesome.css" type="text/css">
    <script type="text/javascript" src="/scripts/org.malajava.generic.js"></script>



    <style type="text/css">
        body{
            background-color: #dedede;
        }

        .dialog {
            border: 2px solid #f2f2f2 ;
            box-shadow: 3px 3px 3px 3px #f2f2f2 ;
            background-color: #FFFFFF;
            position: absolute ;
            left: 50% ;
            top : 50% ;
            width: 400px ;
            margin-left: -200px ;
            height: 370px ;
            margin-top: -150px ;
        }
        .form-row , .identify-row { border: 1px solid transparent ; margin: 5px 5px ; }
        .form-row:hover , .identify-row:hover { border-color: darkgrey; margin: 5px 5px ; }
        .form-row label , .form-row span , .identify-row label , .identify-row span  { height: 50px ; line-height: 50px ; }
        .form-row label { text-align: center }
        .form-row span { text-align: left ;  }
        .form-row span input , .identify-row label input { border: none ; outline: none ;  line-height: 50px ; width: 95% ;}
        .identify-row label input { text-align: center ; }
        .form-row>.x-offset-1 input[type=submit]{
            color: #FFFFFF;
            font-size: 20px;
            background-color: rgba(118, 255, 0, 0.68);
        }
        .dl{
            color: black;
            position: absolute;
            right: 5px;
            bottom: 5px;
            font-size: 18px;
        }
        .find{
            text-align: center;
            line-height: 100px;
            height: 50px;
            font-size: 32px;
            color: #666666;
        }

        /*按钮的悬浮*/
        .submit:hover{
            border: none;
        }
    </style>

</head>
<body>
<div class="find"><p>请填写信息找回密码</p></div>
<div class="include" >
    <div class="dialog">
        <div class="dialog-title x-row">
            <div class="x-row">
                <h2 style="text-align: center ; color:  red ;">
                ## 使用静默引用获取 session 中存储的错误提示信息
                            $!{session.message}
                            ## 删除 session 中存在的错误提示信息
                            ${session.removeAttribute( 'message' )}
                </h2>
            </div>

            <form action="/customer/Retrievepassword" method="post" >

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
                        <i class="fa fa-phone"></i>
                    </label>
                    <span class="x-cell-11">
                            <input type="text" name="telephone" placeholder="请输入手机号码">
                        </span>
                </div>
                <div class="form-row x-row" >
                    <label class="x-cell-1">
                        <i class="fa fa-lock"></i>
                    </label>
                    <span class="x-cell-11">
                            <input type="password" name="password" placeholder="请输入新密码">
                        </span>
                </div>

                <div class="form-row x-row" >
                    <label class="x-cell-1">
                        <i class="fa fa-key"></i>
                    </label>
                    <span class="x-cell-11">
                            <input type="password" name="confirm" placeholder="请确认新密码">
                        </span>
                </div>
                <div class="form-row x-row submit" >
                        <span class="x-offset-1 x-cell-11" >
                            <input type="submit" value="找回密码">
                        </span>
                </div>

            </form>
        </div>
        <div class="dl"><a href="/sign-in.sign-in.jsp">返回登录 </a></div>
    </div>
</div>

</body>
</html>