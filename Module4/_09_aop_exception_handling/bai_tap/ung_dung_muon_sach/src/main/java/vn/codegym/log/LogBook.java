package vn.codegym.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import vn.codegym.exception.NotAvailableException;

import java.util.Arrays;

@Aspect
@Component
public class LogBook {
    @AfterThrowing(pointcut = "execution(public * vn.codegym.service.BookService.*(..))", throwing = "e")
    public void logBook(JoinPoint joinPoint, NotAvailableException e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String argsName = Arrays.toString(joinPoint.getArgs());
        System.err.printf("An error has occurred at: %s.%s.%s : %s", className, methodName, argsName, e.getMessage());
    }

    @After(("execution(public * vn.codegym.service.BookService.*(..))"))
    public void logSuccess(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.err.printf("Method executed successfully at: %s.%s \n", className, methodName);
    }
}
