package com.hello.core.web;

import com.hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoCotroller {
    //지금이것을 하는것에 핵심은 동시에 여러 요청이 들어오더라고 각각 처리를 해주는 것이다.
    private final LogDemoService logDemoService;
    private  final MyLogger myLogger;
   // private final ObjectProvider<MyLogger> myLoggerProvider; // requser요청이 실제 일어났을때 까지 지연시키기 위해서
    //밑에서 이녀석을 꺼내주어야한다
    //ObjectProvider 덕분에 ObjectProvider.getObject() 를 호출하는 시점까지 request scope 빈의
    //생성을 지연할 수 있다

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        //MyLogger myLogger = myLoggerProvider.getObject();
        //이 위 여기서 mylogger를 받는거다
        String requsetURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requsetURL);

        myLogger.log("여기는 컨트롤러야");
        logDemoService.logic("testid");
        return "ok";
    }
}
