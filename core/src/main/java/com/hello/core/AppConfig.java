package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class AppConfig {

    //여기서 이제 각각 생성자 주입을 해주는 것이다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    //리펙토링 실시 --> ctrl +shift + m
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    //리펙토링 실시
    private DiscountPolicy discountPolicy() {
       // return new FixDiscountPolicy(); 여기서 구현객체만 바꿔주면된다
        return new RateDiscountPolicy();
    }

}
