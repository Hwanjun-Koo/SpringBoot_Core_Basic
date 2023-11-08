package hello.core.discount;

import hello.core.member.Member;
//할인정책 인터페이스
public interface DiscountPolicy {
    //@return 할인 대상 금액
    int discount(Member member, int price); //할인 메서드(꿀팁 - F2누르면 오류난 곳으로 이동)
}
