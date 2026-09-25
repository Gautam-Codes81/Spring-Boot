package in.strikes.interceptorDemo.config;

import in.strikes.interceptorDemo.interceptor.AuthenticationInterceptor;
import in.strikes.interceptorDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;

    public AuthenticationInterceptor authenticationInterceptor;

    public  WebConfig(LoggingInterceptor loggingInterceptor, AuthenticationInterceptor authenticationInterceptor){
        this.loggingInterceptor = loggingInterceptor;

        this.authenticationInterceptor = authenticationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login","api/public/**");
    }

}
