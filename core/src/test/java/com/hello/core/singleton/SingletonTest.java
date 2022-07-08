package com.hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        Assertions.assertThat(sinlgtonService1).isSameAs(sinlgtonService2);

    }


}
