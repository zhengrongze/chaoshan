package com.mc.thinking.java.zhujie.sql;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Uniqueness {
    //原先用注解Constraints的注解unique的属性为false
    // 将unique的属性改为true，因为默认的是为False,主需要在注解的字段上面添加该注解就可以了
    Constraints constraints() default @Constraints(unique = true);
}
