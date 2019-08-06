package com.chinaunicom.management.config;

import com.chinaunicom.management.constant.CommonConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Aspect 注解表示这是一个切面类
 */
@Component
@Aspect
public class LogAspectConfig {

    private Logger logger = LogManager.getLogger();

    /**
     * execution中的第一个*表示方法返回任意值
     * 第二个*表示service包下的任意类
     * 第三个*表示类中的任意方法
     * 括号中的两个点表示方法参数任意
     * 这里描述的切入点为service包下所有类中的所有方法
     */
    @Pointcut("execution(* com.chinaunicom." + CommonConstant.PROJECT_NAME + ".controller.*.*(..))")
    public void pc1() {
    }

    /**
     * 这是一个前置通知，该方法在目标方法执行之前执行
     * @param jp 通过JoinPoint参数可以获取目标方法的方法名、修饰符等信息
     */
    @Before(value="pc1()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        logger.info(name + "方法开始执行...");
    }

    /**
     * 后置通知，该方法在目标方法执行之后执行
     * @param jp
     */
    @After(value="pc1()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        logger.info(name + "方法执行结束...");
    }

    /**
     * 返回通知，在该方法中可以获取目标方法的返回值
     * @param jp
     * @param result 方法返回值的变量名，Object表示目标方法的返回值可以是任意类型，如果result参数的类型为Long,
     *               则该方法只能处理目标方法返回值为Long的情况
     */
    @AfterReturning(value="pc1()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        logger.info(name + "方法返回值为:" + result);
    }

    /**
     *
     * @param jp
     * @param e 异常通知，即当目标方法发生异常时，该方法会被调用，异常类型为Exception表示所有的异常都会进入该方法中执行，
     *          若异常类型为ArithmeticException，则表示只有目标方法抛出的ArithmeticException
     */
    @AfterThrowing(value = "pc1()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        logger.info(name + "方法抛出了异常，异常是："  + e.getMessage());
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}