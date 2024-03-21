package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    // 클래스 다이어그램을 살펴보면 왜 했는지 이해할 수 있다.
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 클래스 다이어그램을 살펴보면 왜 했는지 이해할 수 있다.
    private final DiscountPolicy discountPolicy;    // 이렇게 코딩을 할 경우 DIP를 철저하게 지켜 누가 들어올지 모름
    // 확률 할인 정책 관 련 주입

//    @Autowired    // Autowired가 있으면 ComponentScan으로 빈을 호출할 때 자동으로 Autowired가 있는 생성자를 주입해준다.
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 이건 설계가 진짜 잘 된거다. 그 이유는 본 코드에서 판단 과정을 거치지 않고 discountPolicy가 알아서 해주기 때문
        // 즉 단일 책임의 원칙을 진짜 잘 지킨 케이스;
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
