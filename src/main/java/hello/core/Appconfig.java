package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //설정 정보
public class Appconfig { //전체 애플리케이션의 구성

    @Bean //스프링 컨테이너에 등록
    public MemberService memberService() { //회원 서비스 객체 생성
        return new MemberServiceImpl(memberRepository()); //MemoryMemberRepository를 생성자를 통해 넣어줌(생성자 주입)
    }

    @Bean
    public MemberRepository memberRepository() {//회원 저장소 객체 생성
        return new MemoryMemberRepository(); //나중에 DB로 바꾸고 싶다면 여기만 바꾸면 됨
    }

    @Bean
    public OrderService orderService() { //주문 서비스 객체 생성
        return new OrderServiceImpl(memberRepository(), discountPolicy()); //생성자 주입
    }

//    public DiscountPolicy discountPolicy() { //할인 정책 객체 생성
//        return new FixDiscountPolicy(); //나중에 할인 정책을 변경하고 싶다면 여기만 바꾸면 됨
//    }
    @Bean
    public DiscountPolicy discountPolicy() { //할인 정책 객체 생성
        return new RateDiscountPolicy(); //바뀐 할인 정책
    }
}
