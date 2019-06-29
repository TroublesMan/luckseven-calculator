/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.aop;

import java.util.List;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.PeridocialBrief;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.PeridocialBriefRepository;
import king.application.web.spring.clouds.luckseven.calculator.service.ApplicationService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 *
 * @author king
 */
@Aspect
@Component
public class MostFavoritesAspectComponent {
    
    @Autowired
    private ApplicationService application ; 
    
    @Pointcut("execution( * king.application.web.spring.clouds.luckseven.calculator.service.ModelService.doJdbcFunction(..) )")
    public void aop_most_favorites(){}
    
    
    @Around("aop_most_favorites()")
    public Object down_resource_cache(ProceedingJoinPoint joinPoint) throws Throwable{
        
        /**
         * 测试 二 ， 
         * 判断 是不是 当前 ， result  是 什么 属性 
         * 再 判定 相对应的 第一个 参数 是不是 PeridocialBridgeRepository
         * 
         */
        
        Object result = joinPoint.proceed();
        
        //这里 相对应的 args  相对应的 参数 1
        Object repository = joinPoint.getArgs()[0];
        
        //相对应的 设置 相对应的 
        if( repository instanceof PeridocialBriefRepository && ( result instanceof Page || result instanceof List ) ){
            List<PeridocialBrief> list = result instanceof Page ? ((Page)result).getContent() : (List) result;
            this.application.setMost(list);
        }
        
        return result;
        
    }
    
    
}
