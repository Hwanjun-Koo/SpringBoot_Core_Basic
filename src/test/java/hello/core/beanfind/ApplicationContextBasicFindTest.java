package hello.core.beanfind;

import hello.core.Appconfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    }

    @Test
    @DisplayName("빈 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean( MemberService.class); // 타입으로만 조회하면 같은 타입이 두 개 이상이면 오류가 발생한다.
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }


}
