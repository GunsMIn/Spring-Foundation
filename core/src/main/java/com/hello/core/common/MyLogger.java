package com.hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
//여기가 핵심이다. proxyMode = ScopedProxyMode.TARGET_CLASS 를 추가해주자.
//적용 대상이 클래스면 TARGET_CLASS 를 선택
//적용 대상이 인터페이스면 INTERFACES 를 선택
//이렇게 하면 MyLogger의 가짜 프록시 클래스를 만들어두고 HTTP request와 상관 없이 가짜 프록시
//클래스를 다른 빈에 미리 주입해 둘 수 있다
//CGLIB라는 라이브러리로 내 클래스를 상속 받은 가짜 프록시 객체를 만들어서 주입한다.
//이 가짜 프록시 객체는 실제 요청이 오면 그때 내부에서 실제 빈을 요청하는 위임 로직이 들어있다.
//가짜 프록시 객체는 실제 request scope와는 관계가 없다. 그냥 가짜이고, 내부에 단순한 위임 로직만
//있고, 싱글톤 처럼 동작한다
//중요!!!!!!!!!!!! (가짜를 만들고 돌아간다, 원본에 영향을 미치지 않는다)
//사실 Provider를 사용하든, 프록시를 사용하든 핵심 아이디어는 진짜 객체 조회를 꼭 필요한 시점까지
//지연처리 한다는 점이다.
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }
    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scoper bean create" + this);
    }
    @PreDestroy
    public  void close(){
        System.out.println("[" + uuid + "] request scoper bean close" + this);
    }
}
