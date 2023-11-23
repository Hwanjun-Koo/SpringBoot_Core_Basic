package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        Appconfig appconfig = new Appconfig(); //Appconfig 생성
//        MemberService memberService = appconfig.memberService(); //Appconfig에서 생성한 memberService를 가져옴

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class); //Appconfig에 있는 환경설정 정보를 가지고 스프링 컨테이너를 만들어줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//메서드 이름, 타입을 넣어서 뭘 꺼내올지 결정

        Member member = new Member(1L, "memberA", Grade.VIP); //Member 생성(Ctrl+Alt+V 애용할 것)
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName()); //JUnit 테스트 코드를 써보는건 어때?
    }
}
