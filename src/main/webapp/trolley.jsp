
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.io.Console" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<script type="text/javascript">
    var TrolleyList = '<%=session.getAttribute("TrolleyList")%>';
    console.log(TrolleyList)
    TrolleyList =JSON.parse(TrolleyList)
    console.log(TrolleyList)
    window.onload=function(){
        //js循环读取json数据
        var table=document.getElementById("table");
        for(var i=0;i<TrolleyList.length;i++){
            // var row=table.insertRow(table.rows.length);
            // var c1=row.insertCell(0);
            // c1.innerHTML=TrolleyList[i].goods_name;
            // var c2=row.insertCell(1);
            // c2.innerHTML=TrolleyList[i].goods_image;
            // var c3=row.insertCell(2);
            // c3.innerHTML=TrolleyList[i].goods_price;
            // var c4=row.insertCell(3);
            // c4.innerHTML=TrolleyList[i].goods_number;
            // var c5=row.insertCell(4);
            // c5.innerHTML=TrolleyList[i].goods_id;
            // var c6=row.insertCell(5);
            // c6.innerHTML=TrolleyList[i].goods_price;

        }
    }

</script>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>

<html lang="en">

    <link rel="stylesheet" href="/styles/org.malajava.generic.css" type="text/css">


    <link rel="stylesheet" href="styles/org.sign.css" type="text/css">
    <link rel="stylesheet" href="styles/org.sign.header.css" type="text/css">
    <link rel="stylesheet" href="styles/org.sign.footer.css" type="text/css">
    <link rel="stylesheet" href="/font-awesome/css/font-awesome.css" type="text/css">


</head>
<body>
<!-- 页面顶部-->
<%@include file="/commons/header.jsp"%>
<!-- 购物车主体-->
<div class="trolley-main ">

    <div class="trolley-all">
        <div class="trolley-tol" >
            <%--<table id="table">--%>
                <%--<tr>--%>
                    <%--<th>商品</th>--%>
                    <%--<th>图片</th>--%>
                    <%--<th>单价</th>--%>
                    <%--<th>数量</th>--%>
                    <%--<th>金额</th>--%>
                    <%--<th>操作</th>--%>
                <%--</tr>--%>
            <%--</table>--%>

        <span class="title x-cell-6" >
            <o >购物车</o>

        </span>

                <span class="tol x-cell-6">
            <o >总价</o>
        </span>
        </div>
        <div class="imfor_top x-row">

                <div class=" x-cell-2"><i name="goods_name" >商品</i></div>
                <div class=" x-cell-2"><i name="goods_image" >图片</i></div>
                <div class="x-cell-1"><i name="goods_name" >单价(元)</i></div>
                <div class=" x-cell-1"><i name="goods_name" >数量</i></div>
                <div class=" x-cell-2"><i name="goods_name" >金额</i></div>
                <div class=" x-cell-3"><i name="goods_name" >操作</i></div>
        </div>
        <!--  trolleyItems里面存的是 trolleyItem对象,不是map集合-->
        <%--#foreach( $element in ${TrolleyList} )--%>
        <div class="trolley-one x-row">
            <div style="color: #7256ff ;font-size:20px;display: flow-root;border: 2px solid #6fff75;text-align: center">
            <div id="div1"  class=" x-cell-3"><i name="goods_name" >商品</i></div>
            <div id="div2" class=" x-cell-2"><i name="goods_image" >图片</i></div>
            <div id="div3" class="x-cell-1"><i name="goods_price" >单价(元)</i></div>
            <div id="div4" class=" x-cell-1"><i name="goods_number" >数量</i></div>
            <div id="div5" class=" x-cell-2"><i name="goods_name" >金额</i></div>
            <div id="div6"class=" x-cell-3"><i name="goods_name" >操作</i></div>
            </div>
            <div id="list" style="text-align: center;line-height: 70px">
            </div>

        </div>
        <%--#end--%>
<%--suppress JSAnnotator --%>
        <script>

            onload = function() {
                for (var i = 0; i < TrolleyList.length; i++) {
                    var div = document.createElement("div");
                    var goods_number = TrolleyList[i].goods_number;
                    // String name=request.getParameter("name");
                    div.innerHTML ="<div class='x-cell-3'><i name='goods_name' >"+TrolleyList[i].goods_name+"</i></div>"
                    +  "<div class='x-cell-2' ><img style='width: 70px'src="+TrolleyList[i].goods_image+" href='' name='goods_image'></div>"
                    +  "<div class='x-cell-1'><i name='goods_price'>"+TrolleyList[i].goods_price+"</i></div>"
                    +  "<div class='x-cell-1'>"
                    +  " <input style='width:100%;text-align: center;margin-top:25px' type='text' name='goods_number' id='num' value="+TrolleyList[i].goods_number +">"
                    +  "</div>"
                    +  " <div class='x-cell-2'><i>"+TrolleyList[i].goods_price*TrolleyList[i].goods_number+"</i> </div>"
                    +  "<div class='x-cell-1'><input type=\"submit\" value=\"修改\" onclick=\"Update("+${"num"}.val()+")\"></div>"
                    +  "<div class='x-cell-1'><a href='/trolley/trolley-items-delete'  name='delete'>删除</a></div>"
                    +  "<div class='x-cell-1'><a href='/trolley/trolley-items-add'  name='buy'>购买</a></div>"
                    ;
                    div.style.display="flow-root"
                    div.style.border="2px solid #98ffd0"
                    list.appendChild(div);
                }
            }
            Update=function (a) {
                console.log(a)
            }
        </script>
    </div>
    <div class="trolley-last">
            <div class="imfor_top x-row"></div>
    </div>
</div>



<!-- 页面底部-->
<%@include file="/commons/footer.jsp"%>

</body>
</html>