package exception.pierce.surface.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import exception.pierce.common.application.ExceptionPierceException;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

/**
 * @author: 程泰恒
 * @date: 2018/10/27 16:39
 */
@Slf4j
public class FeignConfig implements ErrorDecoder {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Bean
    public ContentTypeRequestInterceptor contentTypeRequestInterceptor() {
        return new ContentTypeRequestInterceptor();
    }

    /**
     * 处理异常穿透
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            return createException(methodKey, response);
        } catch (IOException e) {
            return new ErrorDecoder.Default().decode(methodKey, response);
        }
    }

    private Exception createException(String methodKey, Response response) throws IOException {
        Reader reader = response.body().asReader();

        final String bodyString = IOUtils.toString(reader);

        log.debug("body的内容为" + bodyString);
        Map<String, Object> map = OBJECT_MAPPER.readValue(bodyString, Map.class);

        String type = (String) map.get("type");
        System.out.println(type);
        if (ExceptionPierceException.class.getName().equals(type)) {
            String message = (String) map.get("message");
            ExceptionPierceException ex = new ExceptionPierceException(message);
            //包装一个异常
            return new HystrixBadRequestException(ex.getMessage(), ex);
        }
        return new ErrorDecoder.Default().decode(methodKey, response);
    }

    //在非get方法请求头加入编码方式
    public static class ContentTypeRequestInterceptor implements RequestInterceptor {

        @Override
        public void apply(RequestTemplate template) {
            if (!"get".equalsIgnoreCase(template.method())) {
                template.header("Content-Type", "application/json;charset=UTF-8");
            }
        }
    }
}
