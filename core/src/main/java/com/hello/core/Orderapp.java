package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Orderapp {
    public static void main(String[] args) {

        //ApplicationContext를 스프링 컨테이너라고 한다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;

        Member member = new Member(memberId, "김건우", Grade.VIP);
        memberService.join(member);

        Order item = orderService.createOrder(memberId, "item김건우꺼", 20000);
        System.out.println(item);


    }
}
