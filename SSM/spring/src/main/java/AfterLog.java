import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author John.Cena
 * @date 2022/8/18 19:13
 * @Description:
 */
public class AfterLog implements AfterReturningAdvice {

    /**
     * @param returnValue 返回值
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println( target.getClass().getName() + "的" + method.getName() + "方法被执行了，返回值为" + returnValue);
    }
}
