package exception.pierce.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: 程泰恒
 * @date: 2018/10/26 13:48
 */
@Configuration
public class ExceptionPierceCnfMvc implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addRedirectViewController("/","/dashboard");
        registry.addRedirectViewController("/index","/dashboard");
        }

}
