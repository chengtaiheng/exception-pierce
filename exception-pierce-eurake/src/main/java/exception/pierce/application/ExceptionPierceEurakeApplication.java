package exception.pierce.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: 程泰恒
 * @date: 2018/10/26 13:44
 */

@EnableEurekaServer
@SpringBootApplication
public class ExceptionPierceEurakeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionPierceEurakeApplication.class,args);
    }
}
