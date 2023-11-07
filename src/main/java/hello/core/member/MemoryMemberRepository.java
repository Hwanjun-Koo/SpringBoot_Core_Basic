package hello.core.member;

import java.util.HashMap;
import java.util.Map;

//MemberRepository의 Memory버전 구현체
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //저장소 생성 - 원래는 concurrent 해시맵 써야 함(개인공부)
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
