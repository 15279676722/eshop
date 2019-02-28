package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

@org.springframework.stereotype.Controller
@RequestMapping("/customer/*")
public class CustomerController implements Controller {
    @RequestMapping("sign-up")
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("URI"+uri);
               
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
                    updateInformation(request,response);


                default:
                    break;
            }

        }
                 return null;
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("杨强");
    }

    private void signIn(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("杨强");
    }
    private void signOut(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("杨强");
    }
    private void identify(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("杨强");
    }
    private void retrievepassword(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("杨强");
    }
    private void updateInformation(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("杨强");
    }
}
