package exception.pierce.surface.application.action;

import exception.pierce.surface.application.ExceptionPierceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 程泰恒
 * @date: 2018/10/27 16:31
 */
@Slf4j
@Controller
@RequestMapping("/exception-pierce")
public class ExceptionPierceSurfaceController {

    @Autowired
    private ExceptionPierceClient exceptionPierceClient;

    @GetMapping("/")
    public void exceptionPierceTest(){
        log.debug("进入了该方法");
        exceptionPierceClient.throwException();

    }
}
