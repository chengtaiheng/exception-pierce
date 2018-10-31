package exception.pierce.server.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: 程泰恒
 * @date: 2018/10/26 14:22
 */

@EnableEurekaClient
@SpringBootApplication
public class ExceptionServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExceptionServerApplication.class,args);
    }
}
