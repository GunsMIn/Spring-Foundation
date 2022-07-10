package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy") // Qualifier가 Primary보다는 우선권이 더 높다 !
@Primary // 이것을 설정해주면 다른거 다무시한다. 이거가 붙은애가 우선순윅가 최상위라서 !
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;

    //할인 금액을 리턴
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent /100;
        }
        else{
            return 0;
        }
    }
}
