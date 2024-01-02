package hello.core.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // TYPE: class level annotation
@Retention(RetentionPolicy.RUNTIME) // RUNTIME: annotation을 언제까지 유지할 것인가?
@Documented // javadoc에도 포함
public @interface MyIncludeComponent {
}
