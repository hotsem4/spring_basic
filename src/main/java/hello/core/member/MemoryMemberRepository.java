package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository {    // interface에 대한 구현체

    private static Map<Long, Member> store = new HashMap<>();
    // 일단 HashMap을 사용했지만 사실 실무에서는 Concurrent hashmap을 사용해야한다.
    // 동시성 이슈가 있을 수 있기 때문에
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);      // put -> Map에서 값 추가
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);     // get -> HashMap에서 키 값에서 찾은 후 반환,, 만약 없다면??
    }


// 모든 코드에는 예외처리를 필수로 해야하지만 매우 기초 예제이기 때문에 예외 처리는 생략하도록 하자.
}