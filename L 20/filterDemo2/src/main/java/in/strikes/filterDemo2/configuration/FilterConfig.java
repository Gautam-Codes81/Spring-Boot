package in.strikes.filterDemo2.configuration;

import in.strikes.filterDemo2.filters.DummyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilterBean(){

        FilterRegistrationBean<DummyFilter> registrationBean =
                new FilterRegistrationBean<>();
        registrationBean.setFilter(new DummyFilter());

        // registrationBean.setOrder(new DummyFilter());

        registrationBean.addUrlPatterns("/api/*");
        return  registrationBean;

    }
}
