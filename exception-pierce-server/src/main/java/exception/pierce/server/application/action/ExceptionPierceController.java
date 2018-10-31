package exception.pierce.server.application.action;

import exception.pierce.common.application.ExceptionPierceException;
import exception.pierce.server.application.ExceptionServerApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exception-pierce")
public class ExceptionPierceController {

    @GetMapping("/throw")
    public void throwException() throws Exception{
         ExceptionPierceException.raise("这是异常穿透抛出的第%d个异常",1);
    }

}
