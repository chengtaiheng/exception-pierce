package exception.pierce.surface.application;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 程泰恒
 * @date: 2018/10/27 16:34
 */
@EnableHystrix
@EnableFeignClients
@Configuration
public class ApplicationCnfFeign {

}
