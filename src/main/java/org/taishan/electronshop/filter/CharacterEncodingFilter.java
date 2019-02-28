package org.taishan.electronshop.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;

public class CharacterEncodingFilter implements Filter {

    private static final String PARAM_NAME = "encoding" ;
    private static final String DEFAULT_ENCODING = "UTF-8" ;

    private String encoding ;

    static {
        System.out.println( "加载 CharacterEncodingFilter 类" );
    }

    public CharacterEncodingFilter(){
        System.out.println( "创建 CharacterEncodingFilter 类的实例" );
    }

    @Override
    public void init( FilterConfig config ) throws ServletException {
        System.out.println( "对 CharacterEncodingFilter 类的实例进行初始化" );
        this.encoding = config.getInitParameter( PARAM_NAME );
        this.encoding = ( this.encoding == null || this.encoding.trim().isEmpty() ) ? DEFAULT_ENCODING : this.encoding.trim() ;
        this.encoding = Charset.isSupported( this.encoding ) ? this.encoding : DEFAULT_ENCODING ;

    }

    @Override
    public void doFilter( ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req ;
        String uri = request.getRequestURI();
        DispatcherType type = request.getDispatcherType();
        System.out.println( "CharacterEncodingFilter类的实例正在执行过滤操作: " + uri + " , " + type);
        req.setCharacterEncoding( this.encoding );
        resp.setCharacterEncoding( this.encoding );
        chain.doFilter( req , resp );
    }

    @Override
    public void destroy() {
        System.out.println( "销毁 CharacterEncodingFilter 类的实例所占用的资源" );
    }
}
