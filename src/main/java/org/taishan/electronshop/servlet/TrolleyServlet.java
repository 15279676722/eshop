package org.taishan.electronshop.servlet;

import net.sf.json.JSONArray;
import org.apache.ibatis.session.SqlSession;
import org.taishan.electronshop.dao.*;
import org.taishan.electronshop.domain.*;
import org.taishan.electronshop.mapper.TrolleyMapper;
import org.taishan.electronshop.util.MybatisUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static com.sun.javafx.fxml.expression.Expression.add;

@WebServlet("/trolley/*")
public class TrolleyServlet extends HttpServlet {

    private TrolleyDao td = new TrolleyDao();
    private GoodsDao gd = new GoodsDao();
    private CustomerDao cd = new CustomerDao();
    private OrderDao od = new OrderDao();
    private OrderItemDao oid = new OrderItemDao();
    private SqlSession sqlSession= MybatisUtil.getSqlSession();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        /*换成int报错空指针异常 */
        Integer userid = (Integer) session.getAttribute("userid");
        System.out.println(userid);
        if (username == null || username.length() <= 0) {
            Customer c = cd.load(1);
            username = c.getUsername();
            userid = c.getId();
            session.setAttribute("userid", userid);
            session.setAttribute("username", username);
            session.setAttribute("customer", c);
        } else {
            Customer c = (Customer) session.getAttribute("customer");
        }
//        Customer c = session.getAttribute("customer");
//        String username=c.getUsername();
//        int userid = c.getId();
//        session.setAttribute("userid",userid);
//        session.setAttribute("username",username);
//        username = (String) session.getAttribute("username");
//        if (username == null || username.length() <=0) {
//            response.sendRedirect("/index.vm");
//            return;
//        }
        String uri = request.getRequestURI(); // 从 请求对象中获取 URI
        System.out.println("URI : " + uri);
        /**
         * uri : /employee           ========>  firstSlash == lastSlash
         * uri : /employee/         ========>   lastSlash == length -1
         * uri : /employee/xiaowen
         * uri : /employee/hezi/qing
         */
        int firstSlash = uri.indexOf("/"); // 获得第一个 / 对应的索引
        int lastSlash = uri.lastIndexOf("/"); // 获得最后一个 / 对应的索引
        int length = uri.length(); // 获得 字符串的长度
        int dotIndex = uri.lastIndexOf("."); // 从 uri 中获得最后一个 圆点的 索引

        // 如果最后一个斜杠不是第一个斜杠、并且最后一个斜杠不是最后一个字符、并且没有圆点
        if (firstSlash != lastSlash && lastSlash != length - 1 && dotIndex == -1) {
            String m = uri.substring(lastSlash + 1); // 截取 最后一个斜杠之后的内容
            System.out.println("最后一个 / 之后的内容:  " + m);
            m = m.toLowerCase(); // 全部转小写
            // JDK 1.5  之前 switch 中允许使用 byte 、short 、char、int ，从JDK 1.5 开始支持 枚举
            switch (m) { // Java 7 开始支持在  switch 中使用 String
                case "load":
                    trolleyList(request, response);
                    break;
//                case "trolley-items-buy":
//                    trolleyBuy(request, response);
//                    break;
//                case "trolley-items-update":
//                    trolleyUpdate(request, response);
//                    break;
//                case "trolley-items-delete":
//                    trolleyDelete(request, response);
//                    break;
//                case "trolley-items-add":
//                    trolleyAdd(request, response);
//                    break;
//                case "trolley-items-cut":
//                    trolleyCut(resquest, response);
//                    break;
                default:
                    break;
            }
        }
    }

    private void trolleyList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object username = request.getParameter("username");
        if(username==""){
            throw  new RuntimeException("请先登录");
        }
        HttpSession session = request.getSession();
        TrolleyMapper mapper = sqlSession.getMapper(TrolleyMapper.class);
        List<TrolleyItem> trolleyItems = mapper.querybyCostomer(username.toString());
        JSONArray jsonArray = new JSONArray();
        JSONArray json = jsonArray.fromObject(trolleyItems);
        session.setAttribute( "TrolleyList" , json);
        response.sendRedirect( "/trolley.jsp" );
        return;
    }

    /**
     *根据用户id，查找数据库，并将数据库中的该用户的购物车里的项列出来
     */
//    protected void trolleyList(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("username");
//        int userid = (Integer) session.getAttribute("userid");
//        List<TrolleyItem> trolleyItems = new ArrayList<>();
//        trolleyItems = td.list(userid);
//        session.setAttribute("trolleyItems", trolleyItems);
//        response.sendRedirect("/trolley.vm");
//        return;
//    }
//
//    /**
//     *将这一行的购物车的数据，提交到订单，创建订单，和订单项，然后把购物车中的这项删除
//     */
//    protected void trolleyBuy(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        int id =Integer.parseInt(request.getParameter("nowid"));
//        Customer c = (Customer)session.getAttribute("customer");
//        String username = (String) session.getAttribute("username");
//        TrolleyItem t= td.load(id);
//        Order o = new Order();
//        OrderItem oi = new OrderItem();
//        String UUID = java.util.UUID.randomUUID().toString().replaceAll("-","");
//        o.setId(UUID);
//        o.setName(username);
//        o.setAddress(c.getAddress());
//        o.setTelephone(c.getTelephone());
//        //获取当前时间作为订单产生的时间
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        java.util.Date ct = new Date(System.currentTimeMillis());
////        try {
////            ct = dateFormat.parse(dateFormat.format(System.currentTimeMillis()));
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
//        o.setCreateTime(ct);
//        o.setState("未付款");
//        o.setOperate("付款");
//        o.setCustomer(c);
//        oi.setGoods(t.getGoods());
//        oi.setName(t.getName());
//        oi.setPrice(t.getPrice());
//        oi.setNumber(t.getNumber());
//        o.setTotal(Double.parseDouble(request.getParameter("onetol")));
//        oi.setOrder(o);
//        od.save(o);
//        oid.save(oi);
//        session.setAttribute("noworder",o);
//        session.setAttribute("noworderitems",oi);
////        td.delete(id);
//        response.sendRedirect("/order-confirm.vm");
//        return;
//    }
//    /*
//    修改输入框的值
//     */
//    protected void trolleyUpdate(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        int number = Integer.parseInt(request.getParameter("goods-number"));
//
//        //int number = Integer.parseInt(request.getParameter("number"));
//        int id =Integer.parseInt(request.getParameter("nowid"));
//        if(number <=0){
//            session.setAttribute("nowid",id);
//            response.sendRedirect("/trolley/trolley-items-delete");
//            return;
//        }
//        TrolleyItem t = td.load(id);
//        t.setnumber(number);
//        System.out.println(td.update(t));
//        System.out.println(number);
//        response.sendRedirect("/trolley/trolley-items-list");
//
//
//        return;
//    }
//
//     /*
//    通过点减号，改变input框的值
//     */
//
//    protected void trolleyAdd(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        int number = Integer.parseInt(request.getParameter("add"));
//        System.out.println(number);
//        //int number = Integer.parseInt(request.getParameter("number"));
//        int id = Integer.parseInt(request.getParameter("nowid"));
//        if (number <= 0) {
//            session.setAttribute("nowid", id);
//            response.sendRedirect("/trolley/trolley-items-delete");
//            return;
//        }
//        TrolleyItem t = td.load(id);
//        t.setnumber(number);
//        System.out.println(number);
//        System.out.println(td.update(t));
//
//        response.sendRedirect("/trolley/trolley-items-list");
//
//
//        return;
//
//
//    }
//    /*
//    删除数据库中一条购物车记录
//     */
//    protected void trolleyDelete(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        String nowid =request.getParameter("nowid");
//        if(nowid == null || nowid.length() <= 0){
//            int snowid = (Integer) session.getAttribute("nowid");
//            session.removeAttribute("trolleyItems");
//            session.removeAttribute("nowid");
//            System.out.println(snowid);
//            System.out.println(td.delete(snowid));
//
//            response.sendRedirect("/trolley/trolley-items-list");
//            return;
//        }
//
//
//        int id =Integer.parseInt(nowid);
//        session.removeAttribute("trolleyItems");
//        session.removeAttribute("nowid");
//        System.out.println(id);
//        System.out.println(td.delete(id));
//
//        response.sendRedirect("/trolley/trolley-items-list");
//        return;
//    }
//
//    /*
//    通过点减号，改变input框的值
//     */
//    protected void trolleyCut(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        int number = Integer.parseInt(request.getParameter("cut"));
//
//        //int number = Integer.parseInt(request.getParameter("number"));
//        int id =Integer.parseInt(request.getParameter("nowid"));
//        if(number <=0){
//            session.setAttribute("nowid",id);
//            response.sendRedirect("/trolley/trolley-items-delete");
//            return;
//        }
//        TrolleyItem t = td.load(id);
//        t.setnumber(number);
//        System.out.println(td.update(t));
//        System.out.println(number);
//        response.sendRedirect("/trolley/trolley-items-list");
//        return;
//    }
//}
//
}