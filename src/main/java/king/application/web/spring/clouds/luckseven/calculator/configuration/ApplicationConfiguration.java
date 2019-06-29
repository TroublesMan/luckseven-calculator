/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import king.application.web.spring.clouds.luckseven.calculator.function.id.IdFunction;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Favorites;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Peridocial;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author king
 */
@Configuration
public class ApplicationConfiguration {
    
    @Resource( name = "id_function_peridocial")
    private IdFunction id_function_peridocial;
    
    @Resource(name = "id_function_favorites")
    private IdFunction id_function_favorites;
    
    @Bean("id_function_map")
    public Map<Class,IdFunction> id_function_map(){
        Map<Class,IdFunction> map = new ConcurrentHashMap<>();
        
        map.put(Peridocial.class,this.id_function_peridocial);
        map.put(Favorites.class, this.id_function_favorites);
        
        return map;
    }
    
}
