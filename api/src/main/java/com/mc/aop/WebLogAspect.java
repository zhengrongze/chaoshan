package com.mc.aop;

<<<<<<< HEAD
import com.mc.utils.Logger;
=======
>>>>>>> a54e1a8d53334c72395b986158e43b73a1ee0191
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
<<<<<<< HEAD
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> a54e1a8d53334c72395b986158e43b73a1ee0191
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Aspect
@Component
public class WebLogAspect {

<<<<<<< HEAD
    private final Logger logger = Logger.getLogger(this.getClass());
=======
    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
>>>>>>> a54e1a8d53334c72395b986158e43b73a1ee0191

    @Pointcut("execution(public * com.mc.controller.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("sssss:" + joinPoint);

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }

}
