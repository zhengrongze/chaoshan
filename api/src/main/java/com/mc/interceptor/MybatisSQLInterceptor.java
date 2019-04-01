package com.mc.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.servlet.handler.MappedInterceptor;

import java.util.Properties;

<<<<<<< HEAD
=======
/**
 * @ClassName MybatisSQLInterceptor
 * @Author ZhengRongZe
 * @Date 2019/1/26 14:02
 **/
>>>>>>> a54e1a8d53334c72395b986158e43b73a1ee0191
@Intercepts(@Signature(type = Executor.class,method = "update",
args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}))
public class MybatisSQLInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截器开始");
        System.out.println(invocation.proceed().toString());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
