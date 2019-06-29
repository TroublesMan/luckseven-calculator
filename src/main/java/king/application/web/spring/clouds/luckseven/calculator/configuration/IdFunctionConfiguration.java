/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.configuration;

import king.application.web.spring.clouds.luckseven.calculator.function.id.IdFunction;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Favorites;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Peridocial;
import king.application.web.spring.clouds.luckseven.calculator.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author king
 */
@Configuration
public class IdFunctionConfiguration {
    
    @Autowired
    private ApplicationService application;
    
    @Bean("id_function_peridocial")
    public IdFunction<Peridocial> id_function_peridocial(){
        return new IdFunction<Peridocial>(){
            @Override
            public String doFunction(Peridocial target) {
                
                StringBuilder builder = new StringBuilder();
                
                //进行 获取 相对应的 数据
                builder.append("f").append(System.currentTimeMillis()).append(Math.floor(Math.random()));
                
                return builder.toString();
                
            }
        };
    }
    
    @Bean("id_function_favorites")
    public IdFunction<Favorites> id_function_favorites(){
        return new IdFunction<Favorites>() {
            @Override
            public String doFunction(Favorites target) {
                
                StringBuilder builder = new StringBuilder();
                
                builder.append("f").append(System.currentTimeMillis()).append(Math.floor(Math.random()));
                
                return builder.toString();
                
            }
        };
    }
}
