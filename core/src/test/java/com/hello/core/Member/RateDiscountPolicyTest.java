package com.hello.core.Member;


import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    //할인률 성공 로직
    @Test
    void memberIsViP(){
    //GIVEN
    Member member = new Member(1L, "김건희", Grade.VIP);
    //WHEN
    int discountPrice = rateDiscountPolicy.discount(member, 10000);// 그럼 test상에서는 할인된 금액이 1000원이어야한다
    //THEN
    assertThat(discountPrice).isEqualTo(1000);
}

    //할인율 실패 로직
    @Test
    void memberIsBasic(){
        //given
        Member memberB = new Member(2L,"아빠",Grade.BASIC);
        //when
        int discountprices = rateDiscountPolicy.discount(memberB, 10000);
        //then
        assertThat(discountprices).isEqualTo(1000);
    }


}
