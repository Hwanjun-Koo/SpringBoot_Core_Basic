package hello.core.member;
//MemoryService의 구현체
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; //인터페이스만 의존하도록 변경


    public MemberServiceImpl(MemberRepository memberRepository) { // 생성자를 통해 구현체를 선택
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member); //join에서 호출하면 다형성에 의해 위에서 선언한 구현체에서 save 동작
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
