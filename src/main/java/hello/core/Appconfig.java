package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class Appconfig { //전체 애플리케이션의 구성

    public MemberService memberService() { //회원 서비스 객체 생성
        return new MemberServiceImpl(new MemoryMemberRepository()); //MemoryMemberRepository를 생성자를 통해 넣어줌(생성자 주입)
    }

    public OrderService orderService() { //주문 서비스 객체 생성
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy()); //생성자 주입
    }
}
