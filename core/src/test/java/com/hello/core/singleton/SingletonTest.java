package com.hello.core.singleton;

import com.hello.core.AppConfig;
import com.hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체사용")
    void singletonServiceTEST(){
        /*이렇게 만들면 SINGLETON오류 발생*/
        /* new SinlgtonService();*/

        SinlgtonService sinlgtonService1 = SinlgtonService.getInstance();
        SinlgtonService sinlgtonService2 = SinlgtonService.getInstance();

        System.out.println("sinlgtonService1 = " + sinlgtonService1);
        System.out.println("sinlgtonService2 = " + sinlgtonService2);

        assertThat(sinlgtonService1).isSameAs(sinlgtonService2);

    }
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        //스프림컨테이너는 자동으로 실글톤!
        //스프링 컨테이너 덕분에 고객의 요청이 올 때 마다 객체를 생성하는 것이 아니라, 이미 만들어진 객체를
        //공유해서 효율적으로 재사용할 수 있다
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
