package com.hello.core.order;

public interface OrderService {
    //주문생성로직
    //주문을 할때 회원id, 상품명, 상품가격이 필요하다 그리고 주문상품의결과를 반환해야한다.
    Order createOrder(Long memberId,String itemName,int itemPrice);
}
