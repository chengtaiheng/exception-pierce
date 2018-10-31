package exception.pierce.surface.application.action;

import com.github.yingzhuo.carnival.json.Json;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import exception.pierce.common.application.ExceptionPierceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 程泰恒
 * @date: 2018/10/27 17:28
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandleAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public Json exceptionPierceExceptionhandle(HystrixBadRequestException ex, HttpServletRequest request) {

        log.debug("surface捕捉到异常");

        Throwable cause = ex.getCause();

        log.debug("cause",cause);

        if (cause instanceof ExceptionPierceException) {
            return Json.instance().code("200").errorMessage(cause.getMessage()+"[附加信息：终于等到你，遇见对的你]");
        }
        return Json.instance().code("666").errorMessage("等的不是你,遇见错的你");
    }
}
