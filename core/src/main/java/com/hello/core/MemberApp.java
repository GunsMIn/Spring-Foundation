package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
      /*  AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/
     /*   MemberService memberService = new MemberServiceImpl();*/

        //이 친구가 congiuration에 있는 @bean객체들을 관리해준다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
                                    //첫번째는 메소드의 이름이고 두번째는 타입이다
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
 
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);

        System.out.println(memberA.getName());
        System.out.println(findMember.getName());


    }
}
