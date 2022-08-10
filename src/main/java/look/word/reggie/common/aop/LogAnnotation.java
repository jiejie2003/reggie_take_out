package look.word.reggie.common.aop;

import java.lang.annotation.*;

/**
 * 日志注解
 * METHOD 方法上 type 类上
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    /**
     * 模块
     */
    String module() default "";

    /**
     * 简单描述接口的作用
     */
    String operation() default "";
}
