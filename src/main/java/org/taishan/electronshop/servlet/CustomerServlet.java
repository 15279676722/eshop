package org.taishan.electronshop.servlet;



import org.apache.ibatis.session.SqlSession;
import org.taishan.electronshop.dao.CustomerDao;
import org.taishan.electronshop.domain.Customer;
import org.taishan.electronshop.mapper.Mapper;
import org.taishan.electronshop.util.EncryptHelper;
import org.taishan.electronshop.util.GraphicHelper;
import org.taishan.electronshop.util.MybatisUtil;
import org.taishan.electronshop.util.StringHelper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet( "/customer/*" )
public class CustomerServlet extends HttpServlet {
    SqlSession sqlSession;
    private CustomerDao customerDao = new CustomerDao();

    @Override
    protected void service(HttpServletRequest request , HttpServletResponse response )
            throws ServletException, IOException {

        String uri = request.getRequestURI() ; // 从 请求对象中获取 URI
        System.out.println( "URI : " + uri  );
        /**
         * uri : /employee           ========>  firstSlash == lastSlash
         * uri : /employee/         ========>   lastSlash == length -1
         * uri : /employee/xiaowen
         * uri : /employee/hezi/qing
         */
        int firstSlash = uri.indexOf( "/" ) ; // 获得第一个 / 对应的索引
        int lastSlash = uri.lastIndexOf( "/" ) ; // 获得最后一个 / 对应的索引
        int length = uri.length() ; // 获得 字符串的长度
        int dotIndex = uri.lastIndexOf( "." ); // 从 uri 中获得最后一个 圆点的 索引

        // 如果最后一个斜杠不是第一个斜杠、并且最后一个斜杠不是最后一个字符、并且没有圆点
        if( firstSlash != lastSlash && lastSlash != length -1 && dotIndex == -1 ){
            String m = uri.substring( lastSlash + 1 ); // 截取 最后一个斜杠之后的内容
            System.out.println( "最后一个 / 之后的内容:  " + m );
            m = m.toLowerCase() ; // 全部转小写
            // JDK 1.5  之前 switch 中允许使用 byte 、short 、char、int ，从JDK 1.5 开始支持 枚举
            switch ( m ) { // Java 7 开始支持在  switch 中使用 String
                case "sign-up" :
                    signUp( request , response ) ;
                    break;
                case "sign-in" :
                    signIn( request , response ) ;
                    break;
                case "sign-out" :
                    signOut( request , response );
                    break;
                case "identify" :
                    identify( request , response );
                    break;
                case "retrievepassword":
                    retrievepassword(request,response);
                case "updateinformation":
                    try {
                        updateInformation(request,response);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                default:
                    break;
            }

        }
    }
    private void updateInformation(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String date = request.getParameter("birthdate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate = sdf.parse(date);
        // String birthdate= request.getParameter("birthdate");

        Customer c = new Customer();
        c.setName(name);
        c.setGender(gender);
        c.setUsername(username);
        c.setBirthdate(birthdate);
        boolean b = customerDao.update(c);
        System.out.println(username);
        System.out.println(name);
        System.out.println(gender);
        System.out.println(birthdate);
        if (this.JudgeIdentify(request, response)) {
            if (b == true) {
                session.setAttribute("message", "资料修改成功。");
                response.sendRedirect("/index.jsp");
            } else {
                session.setAttribute("message", "资料修改失败。");
                response.sendRedirect("/updateinformation.jsp");
            }

        }else{
            session.setAttribute("message","验证码输入错误");
            response.sendRedirect("/updateinformation.jsp");
        }
    }
   private boolean JudgeIdentify(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
       String customerIdentifyingCode = (String)session.getAttribute( "customerIdentifyingCode" );
       String identify = request.getParameter( "identify" );
       return StringHelper.equals( customerIdentifyingCode , identify , true , true );
   }
   private boolean JudgePassword(HttpServletRequest request,HttpServletResponse response){
       HttpSession session = request.getSession();
       String password= request.getParameter("password");
       String confirm = request.getParameter( "confirm" );
       return  password.equals(confirm);
   }
    private void retrievepassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter( "username" );
        String  telephone=request.getParameter("telephone");
        String password=request.getParameter("password");
        if(this.JudgePassword(request,response)) {
            Customer c = new Customer();
            Customer load = customerDao.load(username, telephone);
            if (load != null) {
                session.setAttribute("message","密码找回成功。");
                customerDao.updatePassword(username, password);
                response.sendRedirect("/sign-in.jsp");
            } else {
                System.out.println("没找到");
                session.setAttribute("message", "电话和密码不匹配。");
                response.sendRedirect("/retrievepassword.jsp");
            }
        }
        else{
            session.setAttribute("message", "两次密码不一致。");
            response.sendRedirect("/retrievepassword.jsp");
        }

    }


    protected void signUp(HttpServletRequest request , HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        sqlSession = MybatisUtil.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        String username = request.getParameter( "username" );
        if( StringHelper.empty( username ) ){
            session.setAttribute( "message" , "你丫用户名居然是空的。"  );
            response.sendRedirect( "/sign-up.jsp" );
            return ;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        List<Customer> customers = mapper.selectAllByPage(map);
        if(customers.size()>0){
            session.setAttribute( "message" , "该用户已经存在。"  );
            response.sendRedirect( "/sign-up.jsp" );
            return ;
        }


        String password = request.getParameter( "password" );
       // String confirm = request.getParameter( "confirm" );
        String telephone = request.getParameter( "telephone" );
        String substring = telephone.substring(0, 2);
        System.out.println(substring);
        String identify = request.getParameter( "identify" );
        String customerIdentifyingCode = (String)session.getAttribute( "customerIdentifyingCode" );
        System.out.println(substring.equals("13")||substring.equals("14")||substring.equals("15"));
//        if( ! StringHelper.equals( customerIdentifyingCode , identify , true , true ) ){
//            session.setAttribute( "message" , "验证码输入错误。"  );
//            response.sendRedirect( "/jsp/sign-up.jsp" );
//            return ;
//        }
        if(!this.JudgeIdentify(request,response)){
            session.setAttribute( "message" , "验证码输入错误。"  );
            response.sendRedirect("/sign-up.jsp");
            return;
        }
        password = EncryptHelper.encrypt( password ) ;
        Customer c = new Customer();
        c.setUsername( username );
        c.setPassword( password );
        c.setTelephone( telephone );

        if(telephone.length()==11) {
            if (substring.equals("13")||substring.equals("14")||substring.equals("15")) {
                if (this.JudgePassword(request,response)) {
                    int i = mapper.insert(c);

                    System.out.println(i);
                    sqlSession.commit();
                    MybatisUtil.closeSession(sqlSession);
                    if (true) {
                        session.setAttribute("message", "注册成功。可以登录了哦。");
                        response.sendRedirect("/sign-in.jsp");

                    } else {
                        session.setAttribute("message", "该用户名已经存在。");
                        response.sendRedirect("/sign-up.jsp");
                    }
                } else {
                    session.setAttribute("message", "两次密码不一致。");
                    response.sendRedirect("/sign-up.jsp");
                }
            }
            else{
                session.setAttribute("message", "电话号码11位。以13.14.15开头！！");
                response.sendRedirect("/sign-up.jsp");
            }

        }
        else{
            session.setAttribute("message","中国大陆电话号码11位。");
            response.sendRedirect("/sign-up.jsp");
        }

    }

    protected void signIn(HttpServletRequest request , HttpServletResponse response )
            throws ServletException, IOException {
        sqlSession = MybatisUtil.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        HttpSession session = request.getSession();
        String username = request.getParameter( "username" );
        String password = request.getParameter( "password" );
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);

        List<Customer> customer = mapper.selectAllByPage(map);
        if(customer.size()==0){
            System.out.println("你输入的用户名在本系统中不存在。");
            session.setAttribute( "message" , "你输入的用户名在本系统中不存在。" );
            response.sendRedirect( "/sign-in.jsp" );
            return ;
        }else{
            if(password.length()==0){
                System.out.println("密码不能为空。");
                session.setAttribute("message","密码不能为空。");
                response.sendRedirect("/sign-in.jsp");
            }
            password = EncryptHelper.encrypt( password ) ;
            if(StringHelper.equals(customer.get(0).getPassword(),password)){
                if(this.JudgeIdentify(request,response)) {
                    session.setAttribute("username",username);
                    session.setAttribute("customer", customer.get(0));
                    response.sendRedirect("/index.jsp");
                    // request.getRequestDispatcher( "/index.jsp" ).forward( request , response );
                    return;
                }
                else{
                    System.out.println("验证码错误。");
                    session.setAttribute("message","验证码错误。");
                    response.sendRedirect("/sign-in.jsp");
                }
            } else {
                System.out.println("你输入的密码错误。");
                session.setAttribute( "username" , username );
                session.setAttribute( "message" , "你输入的密码错误。" );
                response.sendRedirect( "/sign-in.jsp" );
                return ;
            }
        }


    }

    protected void signOut(HttpServletRequest request , HttpServletResponse response )
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect( "/index.jsp" );
    }

    protected void identify(HttpServletRequest request , HttpServletResponse response )
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        response.setContentType( "image/jpeg" );

        OutputStream out = response.getOutputStream();

        String code = GraphicHelper.create( 4 , false , 200 , 48 , out , 10 );

        session.setAttribute( "customerIdentifyingCode" , code );

    }

}
