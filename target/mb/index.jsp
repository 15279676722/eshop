<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>>">
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>

<html lang="en">
<script type="text/javascript">
    var username = '<%=session.getAttribute("username")%>';
    username=username =="null"?"":username
    var message = '<%=session.getAttribute("message")%>';
    message=message =="null"?"":message
</script>
<head>
    <meta charset="UTF-8">
    <title>泰山电子商城</title>
    <link rel="stylesheet" href="/styles/org.index.css">

</head>
<body>
<div class="header" name="top">
    <div class="header-part">
        <div class="header-part1">

            <span><a href="/customer/sign-out" >注销</a></span>
            <span><a href="/sign-up.jsp" >注册</a></span>
            <span><a href="/sign-in.jsp" >登录</a></span>
            <span><a href="trolley/load?username=${username}">查看购物车</a> </span>
            <span><a href="/updateinformation.jsp">资料</a></span>
            <h1 id="test">  <script type="text/javascript">
                document.getElementById("test").innerHTML="欢迎您"+username;
            </script>
            </h1>

        </div>
        <div class="header-part2">
            <div class="navigator">
                <ul>

                    <li> 手机
                        <ul>
                            <li><a href="">华为</a></li>
                            <li><a href="">锤子</a></li>

                        </ul>
                    </li>

                    <li> 电脑
                        <ul>
                            <li><a href="">戴尔</a></li>
                            <li><a href="">小米</a></li>
                        </ul>
                    </li>

                    <li> 电视 盒子
                        <ul>
                            <li><a href="">创维</a></li>
                            <li><a href="">小米</a></li>
                        </ul>
                    </li>

                    <li> 数码
                        <ul>
                            <li><a href="">佳能</a></li>
                            <li><a href="">索尼</a></li>
                            <li><a href="">松下</a></li>
                            <li><a href="">尼康</a></li>
                        </ul>
                    </li>
                </ul>

            </div>
        </div>
    </div>
    <div class="header-part3"></div>
</div>



#*戴尔电脑*#
<div class="wrapper">
    <div class="title"><span><img src="/img/comp1.png" alt=""><span>电脑优选</span></span></div>
    <div class="container">
        <div  class="container-part1">
            <a href=""><img src="/img/dell1.jpg" alt="戴尔 XPS 13 微边框 银色"></a>
            <span>戴尔 XPS 13 微边框 银色</span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">5499</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div class="container-part2">
            <a href=""><img src="/img/dell2.jpg" alt="戴尔 Vostro 成就 14 5000商务办公本"></a>
            <span>戴尔 Vostro 成就5000商务办公本</span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">15999</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div class="container-part3 xiaomicom">
            <a href=""><img src="/img/xiaomicom.jpg" alt="Xiaomi/小米 笔记本Air i5 "></a>
            <span>Xiaomi/小米 笔记本Air i5 </span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">5299</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div  class="container-part4 dell4">
            <a href=""><img src="/img/dell4.jpg" alt="戴尔 Inspiron 灵越 15 7000系列"></a>
            <span>戴尔 Inspiron 灵越7000系列 </span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">8399</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

    </div>

    <div class="title"><span><img src="/img/phone2.png" alt=""><span>锤子 华为</span></span></div>

    #*锤子华为手机*#
    <div class="container">
        <div  class="container-part1">
            <a href="" class="huawei" ><img src="/img/smartisan1.png" alt="坚果3 "></a>
            <span>坚果3 </span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">1299</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div class="container-part2">
            <a href="" class="huawei" ><img src="/img/smartisan2.png" alt="坚果 Pro2 "></a>
            <span>坚果 Pro2 </span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">1799</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div class="container-part3">
            <a href="" class="huawei" ><img src="/img/huawei1.png" alt="HUAWEI P20 "></a>
            <span>HUAWEI P20</span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">3788</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div  class="container-part4 ">
            <a href=""  class="huawei" ><img src="/img/huawei1.png" alt=" HUAWEI Mate RS 保时捷设计 "></a>
            <span>HUAWEI Mate RS 保时捷设计 </span>
            <div class="price " >
                <span class="unit">¥</span>
                <span class="amount">9999</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

    </div>

    <div class="title"><span><img src="/img/cam1.png" alt=""><span>数码潮品</span></span></div>

    #*数码相机*#
    <div class="container">
        <div  class="container-part1">
            <a href="" class="camera"><img src="/img/camera1.jpg" alt="佳能 700D套机(EF-S 18-55mm "></a>
            <span>松下700D套机(EF-S 18-55mm </span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">3588</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div class="container-part2">
            <a href=""class="camera"><img src="/img/camera2.jpg" alt="全幅微单索尼ILCE-7RM2代 "></a>
            <span>全幅微单尼康ILCE-7RM2</span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">14799</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div class="container-part3">
            <a href="" class="camera"><img src="/img/camera3.jpg" alt="佳能（Canon） EOS 100D "></a>
            <span>佳能（Canon） EOS 100D </span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">3000</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div  class="container-part4">
            <a href="" class="camera"><img src="/img/camera4.jpg" alt="索尼（SONY）a7R/ILCE-7R "></a>
            <span>索尼（SONY）a7R/ILCE-7R </span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">11288</span>
            </div>
            <div class="buy" class="camera"><a href=""><button>立即购买</button></a></div>
        </div>

    </div>

    <div class="title"><span><img src="/img/tv1.png" alt=""><span>电视盒子</span></span></div>

    #*电视盒子*#
    <div class="container">

        <div  class="container-part1">
            <a href="" class="camera"><img src="/img/box1.jpg" alt="创维（Skyworth）4核智能网络电视机顶盒"></a>
            <span>Skyworth 4核智能网络电视机顶盒 </span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">159</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div class="container-part2">
            <a href=""class="camera"><img src="/img/box2.jpg" alt="创维Skyworth企鹅极光T2机顶盒 "></a>
            <span>创维Skyworth企鹅极光T2机顶盒</span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">199</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div class="container-part3">
            <a href="" class="camera"><img src="/img/box3.jpg" alt="创维Skyworth企鹅极光1s 电视盒子 "></a>
            <span>  小米电视盒子  </span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">309</span>
            </div>
            <div class="buy"><a href=""><button>立即购买</button></a></div>
        </div>

        <div  class="container-part4">
            <a href="" class="camera"><img src="/img/box4.jpg" alt="创维（Skyworth）π盒 智能网络电视机顶盒"></a>
            <span>创维π盒智能网络电视机顶盒</span>
            <div class="price">
                <span class="unit">¥</span>
                <span class="amount">499</span>
            </div>
            <div class="buy" class="camera"><a href=""><button>立即购买</button></a></div>
        </div>

    </div>
</div>
#*购物车图标*#
<div class="shopping-cart" ><a href="">
    <img src="/img/cart.png" alt="购物车">
</a></div>
<div class="top"><a href="#top"><img src="/img/top.png" alt="回到顶部"></a></div>


</body>

</html>