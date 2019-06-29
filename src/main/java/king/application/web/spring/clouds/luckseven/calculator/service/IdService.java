/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service;

import java.util.Map;
import javax.annotation.Resource;
import king.application.web.spring.clouds.luckseven.calculator.function.id.IdFunction;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class IdService {
    
    @Resource(name="id_function_map")
    private Map<Class,IdFunction> id_function_map;
    
    public String create(Object target){
        IdFunction function = this.id_function_map.get(target.getClass());
        
        return function != null ? function.doFunction(target).toString() : null;
    }
    
}
