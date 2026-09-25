package in.strikes.interceptorDemo.interceptor;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.method;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request ,
                             HttpServletResponse response,
                             Object handler){

        System.out.println("Incoming Request --------");
        System.out.println("HTTP Method:" + request.getMethod());
        System.out.println("Request Parameter: " + request.getRequestURI());
        System.out.println("Request Parameters :"  + request.getQueryString() );
        System.out.println("client IP:" + request.getRemoteAddr());
        System.out.println("Token Header:" + request.getHeader("token"));

        if(handler instanceof  HandlerMethod handlerMethod){

            System.out.println("Controller :" + handlerMethod.getBeanType().getName());
            System.out.println("Controller method" + handlerMethod.getMethod().getName());

        }
        return true;

    }


    public void  afterCompletion(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Object handle,
                                 Exception ex) throws Exception{

        System.out.println("Response status:" + response.getStatus());



    }

}
