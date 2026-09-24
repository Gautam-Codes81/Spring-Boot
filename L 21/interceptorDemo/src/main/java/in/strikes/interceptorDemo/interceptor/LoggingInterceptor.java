package in.strikes.interceptorDemo.interceptor;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request ,
                             HttpServletResponse response,
                             Object handle){

        System.out.println("PreHandle called");
        return  true;

    }
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handle,
                           ModelAndView modelAndView){
        System.out.println("postHandle called");

    }
     @Override
    public void  afterCompletion(HttpServletRequest request,
                                 HttpServletResponse response,
                                 Object handle,
                                 Exception ex) throws Exception{

        System.out.println("afterCompletion called");

    }

}
