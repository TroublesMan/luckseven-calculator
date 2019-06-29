/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.aop;

import king.application.web.spring.clouds.luckseven.calculator.service.ApplicationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author king
 */
@Aspect
//@Component
public class SystemAspectComponent {
    
    @Autowired
    private ApplicationService application;
    
    @Around("")
    public Object aop_system(ProceedingJoinPoint joinPoint) throws Throwable{
        Object result = joinPoint.proceed();
        
        Object args[] = joinPoint.getArgs();
        
        StringBuilder builder = new StringBuilder();
        
        for(Object arg : args){
            builder.append(this.application.json(arg)).append("\t");
        }
        
        System.out.println(builder.toString());
        return result;
    }

    
}
