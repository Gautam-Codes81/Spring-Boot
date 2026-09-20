package in.strikes.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest)  servletRequest;

        HttpServletResponse httpResponse = (HttpServletResponse)  servletResponse;

        // Request log
        System.out.println("Incoming Request : " + httpRequest.getMethod() + " "
        + httpRequest.getRequestURI());

        filterChain.doFilter(servletRequest,servletResponse);

        // Response status log
        System.out.println("response status : " + httpResponse.getStatus());




    }
}
