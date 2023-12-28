package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //@Component가 붙은 모든 클래스를 스프링 빈으로 등록한다. 이때 @Configuration이 붙은 클래스를 제외.
public class AutoAppConfig {
}
