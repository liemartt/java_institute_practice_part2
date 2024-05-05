package edu.mirea.pr_18.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around("allServiceMethods()")
    public Object logParameters(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long timeTaken = System.currentTimeMillis() - startTime;
            log.info("Execution time of {} is {} ms", joinPoint.getSignature(), timeTaken);
        }
    }
    @Pointcut("execution(* edu.mirea.pr_18.services.*.*(..)))")
    public void allServiceMethods() {}
}
