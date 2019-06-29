/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.configuration;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.annotation.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author king
 */
@Configuration
public class JpaConfiguration {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Bean("jpa_repository_map")
    public Map<Class,JpaRepository> jpa_repository_map(){
        
        Map<String,JpaRepository> beans = this.applicationContext.getBeansOfType(JpaRepository.class);
        Map<Class,JpaRepository> map = new ConcurrentHashMap<>();
        
        for(JpaRepository  repository : beans.values()){
            //获取 相对应的 model
            Model model = repository.getClass().getAnnotation(Model.class);
            
            if(model == null){
                continue;
            }
            
            map.put(model.bean(), repository);
        }
        
        return map;
    }
    
}
