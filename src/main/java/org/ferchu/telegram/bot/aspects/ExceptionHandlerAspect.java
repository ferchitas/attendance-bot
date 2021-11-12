package org.ferchu.telegram.bot.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.ferchu.telegram.bot.exceptions.NoAdminException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlerAspect {

    @AfterThrowing(pointcut = "execution(* *.*.*(..))", throwing = "noAdminException")
    public void isAdmin(JoinPoint joinPoint, NoAdminException noAdminException) throws Exception {

        System.out.println("");
    }
}
