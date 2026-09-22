package in.strikes.filterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        HttpServletRequest httpRequest =
                (HttpServletRequest)  servletRequest;

        HttpServletResponse httpResponse =
                (HttpServletResponse)  servletResponse;

        String requestId = UUID.randomUUID().toString();
        httpResponse.setHeader("X-Request-Id", requestId);

        // Request log
        System.out.println("Incoming Request : " + httpRequest.getMethod() + " "
        + httpRequest.getRequestURI());

        try{
            filterChain.doFilter(servletRequest,servletResponse);
        }
        finally {
            long duration = System.currentTimeMillis() - startTime;

            // Response status log
            System.out.println("response status : " + httpResponse.getStatus());

            System.out.println("API RESPONSE TIME :" + duration);

        }


    }
}
