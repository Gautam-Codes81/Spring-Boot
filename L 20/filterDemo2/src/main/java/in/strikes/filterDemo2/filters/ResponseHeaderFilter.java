package in.strikes.filterDemo2.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;
//@Component
public class ResponseHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletrequest,
                         ServletResponse servletresponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

     HttpServletRequest httpServletRequest =
             (HttpServletRequest) servletrequest;

     HttpServletResponse httpServletResponse =
             (HttpServletResponse) servletresponse;


       String requestId = UUID.randomUUID().toString();
       httpServletResponse.setHeader("x-request-id", requestId);

       filterChain.doFilter(servletrequest,servletresponse);


    }
}
