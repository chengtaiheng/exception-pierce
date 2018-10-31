package exception.pierce.surface.application;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "exception-pierce-server",
        path = "/exception-pierce",
        configuration = {FeignConfig.class}
)

public interface ExceptionPierceClient {

    @GetMapping("/throw")
    public void throwException();

}
