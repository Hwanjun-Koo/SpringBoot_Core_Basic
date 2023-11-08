package hello.core.member;
//MemoryService의 구현체
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 저장소의 구현체 선택 인터페이스,구현체 모두에 의존하는 상태 - DIP(의존관계 역전 법칙) 위반

    @Override
    public void join(Member member) {
        memberRepository.save(member); //join에서 호출하면 다형성에 의해 위에서 선언한 구현체에서 save 동작
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
