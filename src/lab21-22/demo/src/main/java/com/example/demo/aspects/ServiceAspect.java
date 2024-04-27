package com.example.demo.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
@Aspect
public class ServiceAspect {
    @Around("allServiceMethods()")
    public Object logExecTime(ProceedingJoinPoint call) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) call.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = call.proceed();
        stopWatch.stop();
        log.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }
    @Pointcut("within(com.example.demo.service.*)")
    public void allServiceMethods() {}

}
