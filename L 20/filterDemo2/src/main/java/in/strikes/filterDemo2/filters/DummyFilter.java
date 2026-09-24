package in.strikes.filterDemo2.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
//@Component
public class DummyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletrequest,
                         ServletResponse servletresponse,
                         FilterChain filterChain)
            throws IOException, ServletException {


        HttpServletRequest httpServletRequest =
                (HttpServletRequest) servletrequest;

        String uri = httpServletRequest.getRequestURI();

        if(!uri.startsWith("/api/")){

            filterChain.doFilter(servletrequest,servletresponse);
        }


        System.out.println("Dummy filter called");

        filterChain.doFilter(servletrequest,servletresponse);

    }
}
