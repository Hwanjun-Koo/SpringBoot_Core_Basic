package hello.core.member;
//회원의 저장소 역할 인터페이스
public interface MemberRepository {


    void save(Member member); //회원의 저장

    Member findById(Long memberId); //회원의 id로 찾기
}
