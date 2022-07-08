package com.hello.core.singleton;

public class SinlgtonService {

    //자기 자신을 static으로 가지고있다. static으로 올리면 클래스레벨에 올라가기때문에 딱 1개만 가지고있다
    private static final SinlgtonService instance = new SinlgtonService();

    //조회하기
    public static SinlgtonService getInstance(){
        return instance;
    }
    //만약에 singleTon패턴으로 만드려고 이렇게 만들었는데 외부에서
    //객체를 생성할 수 도 있잖아 그러니까 private이 붙은 생성자를 만들어주자!!!
    //생성자를 꼭 private으로 막아주자!
    private SinlgtonService(){
        ;
    }
    public  void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
