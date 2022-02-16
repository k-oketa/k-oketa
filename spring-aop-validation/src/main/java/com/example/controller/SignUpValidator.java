package com.example.controller;

import com.example.controller.response.CreatedResponseEntity;
import com.example.controller.response.InternalServerErrorResponseEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SignUpValidator {
    @Around(value = "execution(* *..SignUpController.signUp(..))")
    public ResponseEntity<?> occurred(ProceedingJoinPoint jp) {
        try {
            return (CreatedResponseEntity) jp.proceed();
        } catch (Throwable throwable) {
            return new InternalServerErrorResponseEntity(throwable);
        }
    }
}
