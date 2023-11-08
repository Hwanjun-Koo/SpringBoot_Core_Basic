package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(); //MemberService
        Member member = new Member(1L, "memberA", Grade.VIP); //Member 생성(Ctrl+Alt+V 애용할 것)
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName()); //JUnit 테스트 코드를 써보는건 어때?
    }
}
