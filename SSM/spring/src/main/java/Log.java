import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author John.Cena
 * @date 2022/8/18 19:15
 * @Description:
 */
public class Log implements MethodBeforeAdvice {

    /**
     *
     * @param method 要执行的目标对象的方法
     * @param args 被调用的方法的参数
     * @param target 目标对象
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println( target.getClass().getName() + "的" + method.getName() + "方法被执行了");
    }
}
