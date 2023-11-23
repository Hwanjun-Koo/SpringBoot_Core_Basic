package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//직접 실행
public class OrderApp {
    public static void main(String[] args) { // psvm으로 빠른 생성 가능

//        Appconfig appconfig = new Appconfig(); //Appconfig 생성
//        MemberService memberService = appconfig.memberService(); //Appconfig에서 생성한 memberService를 가져옴
//        OrderService orderService = appconfig.orderService(); //Appconfig에서 생성한 orderService를 가져옴

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP); //VIP인 회원 생성
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000); // 주문 생성

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
