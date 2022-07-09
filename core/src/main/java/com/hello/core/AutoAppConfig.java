package com.hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters =@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class))
public class AutoAppConfig {
// @Component 가 붙은 클래스를 찾아서 자동으로 스프링 빈으로 등록해준다!
//() 안에 있는것을 스프링빈으로 등록을 막을때 사용한다 . 안그러면 충돌난다 둘다 설정이라서
}
