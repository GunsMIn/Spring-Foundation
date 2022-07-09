package com.hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {
    @Test
    void statefulService(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //threadA 사용자가 10000원을주문
        int userA_price = statefulService1.order("userA", 10000);
        //threadB 사용자가 20000원을주문
        int userB_price = statefulService2.order("userB", 20000);

        //A의 주문 금액 조회

        System.out.println("priceA = " + userA_price);
        System.out.println("priceB = " + userB_price);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
