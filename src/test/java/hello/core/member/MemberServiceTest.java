package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join() {
        //given    ->   이런 이런 환경, 이런 이런게 주어졌을 때
        Member member = new Member(1L, "memberb2", Grade.VIP);

        //when    ->    이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then     ->   요렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember);
        // 현대적인 코드를 작성하려면 트랜드는 무조건 테스트코드를 작성해야 한다. 이건 필수다.
        // 실무에서도 코딩 전체의 60%가 다 테스트케이스 작성이다.
    }
}
