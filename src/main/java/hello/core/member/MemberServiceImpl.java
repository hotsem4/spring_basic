package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;   // 앞에서 만들었던 MemoryMemberRepository를 연결시켜 준다.

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
}
