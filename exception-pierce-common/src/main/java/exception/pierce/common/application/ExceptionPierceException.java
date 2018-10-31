package exception.pierce.common.application;



import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ExceptionPierceException extends RuntimeException {

    private static final long serialVersionUID = 2755873677662160081L;

    //自动抛出一个异常，并且格式化异常信息到message里面
    public static void raise(String format, Object... args) {
        throw new ExceptionPierceException(format, args);
    }

    public ExceptionPierceException(String format, Object... args) {
        this(String.format(format, args));
    }

    public ExceptionPierceException(String msg) {
        super(msg);
        System.out.println("调用了异常的信息构造函数");
    }

    //把异常信息存入一个map，包括message和type，返回一个不可更改的map
    public Map<String, Object> asMap(boolean includeType) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", getMessage());
        if (includeType) {
            map.put("type", getClass().getName());
        }
        return Collections.unmodifiableMap(map);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
