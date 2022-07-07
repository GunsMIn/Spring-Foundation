package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    /*여기서 이제 왜 인터페이스를 만들었는지 알게된다
    * 첫번째는 할인금액을 적용
    * 두번째는 할인율을 적용하려고한다*/
    /*1.할인금액클래스*/
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    /*2.할인율클래스*/
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //하지만 위처럼 진행하게되면 의존성을 위반한다. 그래서 아래처럼 구현해야한다
    //추상화된 인터페이스만 의존하게된다.
    private  final DiscountPolicy discountPolicy;

    //생성자 주입
    //여기서 제일 중요한게 생성자를 통해서 어떤구현 객체가 주입할지는 오직 외부 AppConfig가 결정한다
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //주문생성로직
    //주문을 할때 회원id, 상품명, 상품가격이 필요하다 그리고 주문결과를 반환해야한다.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
