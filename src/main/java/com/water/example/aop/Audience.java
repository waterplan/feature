package com.water.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* com.water.example.concert.Performance.perform(..))")
    public void  perform(){

    }

    @Around("perform()")
    public void watchPerFormance(ProceedingJoinPoint jp){
        try {
            System.out.println("the audience is turning off their cellphones");
            System.out.println("the audience is taking their seats.");
            jp.proceed();
            System.out.println(" the audience is appaud CLAP CLAP CLAP CLAP CLAP");
        } catch (Throwable throwable) {
            System.out.println("this audience is demandRefund Boo! We want our money back");
        }
    }

//    public void taskeSeats(){
//        System.out.println("the audience is taking their seats.");
//    }
//
//    public void turnoffCellPhones(){
//        System.out.println("the audience is turning off their cellphones");
//    }
//
//    public void applaud(){
//        System.out.println(" the audience is appaud CLAP CLAP CLAP CLAP CLAP");
//    }
//
//    public void demandRefund(){
//        System.out.println("this audience is demandRefund Boo! We want our money back");
//    }
}
