package bg.softuni.musicstore.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class IPAddressInterceptor implements HandlerInterceptor {

    private final Logger LOGGER = LoggerFactory.getLogger(IPAddressInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ip = request.getHeader("X-Forward-For");

        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        LOGGER.info("Client IP address: " + ip);

        return true;
    }
}
