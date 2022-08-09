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

    String module() default "";

    String operation() default "";
}
