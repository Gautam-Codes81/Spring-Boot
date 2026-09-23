package in.strikes.filterDemo2.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletrequest,
                         ServletResponse servletresponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
       // servlet request aur servletresponse ki casting h jo sab mai banana h
        HttpServletRequest httpServletRequest =
                (HttpServletRequest) servletrequest;

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) servletresponse;

        ContentCachingResponseWrapper wrappedResponse =
                new ContentCachingResponseWrapper(httpServletResponse);
        filterChain.doFilter(servletrequest, wrappedResponse);

     byte[] originalBodyBytes  =
             wrappedResponse.getContentAsByteArray();


       String originalBody = new String(originalBodyBytes);

       String modifiedBody =
               """
                {
                  "originalResponse" : %s,
                  "appName" : "Student Management System"
               
                }
                """.formatted(originalBody);

       wrappedResponse.resetBuffer();

         wrappedResponse.getWriter().write(modifiedBody);

         wrappedResponse.copyBodyToResponse();

    }
}
