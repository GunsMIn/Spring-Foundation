package com.hello.core.singleton;

public class StatefulService {

    //private int price; // StatefulService에서 나의 목표는 10000이 나온는것이었느데 20000이 나왔다 . 그래서
    //필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다

    //이렇게 하는 것은 지역변수는 공유되는것이 아니기때문에!
    public int order(String name, int price){
        System.out.println("name = " + name + "price = "+price);
        //this.price = price; // 여기가 문제!
        return price;
    }

/*    public int getPrice() {
       // return price;
    }*/
}
