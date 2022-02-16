package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SignUpValidator {
    @Around(value = "execution(* *..SignUpController.signUp(..))")
    public String occurred(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Into Around!");
        try {
            var result = jp.proceed();
            return "ok!";
        } catch (Exception e) {
            return "no!";
        }
    }
}
