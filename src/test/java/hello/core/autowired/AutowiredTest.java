package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) //자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안 됨
        public void setNoBean1(Member noBean1) { //Member는 스프링 빈이 아님
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Autowired(required = false) Member noBean2) { //호출은 되지만 null로 들어옴
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) { //호출은 되지만 Optional.empty로 들어옴
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
