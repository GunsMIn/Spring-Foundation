package com.hello.core.web;

import com.hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;
   // private final ObjectProvider<MyLogger> myLoggerProvider;
    //request를 지연싴키기위해서

    public void logic(String id) {
        //MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id =" + id);
    }
}
