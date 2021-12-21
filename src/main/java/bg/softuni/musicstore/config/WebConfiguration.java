package bg.softuni.musicstore.config;

import bg.softuni.musicstore.web.interceptor.IPAddressInterceptor;
import bg.softuni.musicstore.web.interceptor.StatsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final StatsInterceptor statsInterceptor;
    private final IPAddressInterceptor ipAddressInterceptor;

    public WebConfiguration(StatsInterceptor statsInterceptor, IPAddressInterceptor ipAddressInterceptor) {
        this.statsInterceptor = statsInterceptor;
        this.ipAddressInterceptor = ipAddressInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(statsInterceptor);
        registry.addInterceptor(ipAddressInterceptor);
    }
}
