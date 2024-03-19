package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;   // 앞에서 만들었던 MemoryMemberRepository를 연결시켜 준다.

    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);    // 다형성에 의해 MemoryMemberRepository에 있는 save가 호출
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);  // 다형성에 의해 MemoryMemberRepository에 있는 findById가 호출
    }


    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
