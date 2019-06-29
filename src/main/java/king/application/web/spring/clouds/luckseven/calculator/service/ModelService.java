/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service;

import com.king.wind.spring.boot.jdbc.function.JdbcFunction;
import com.king.wind.spring.boot.jdbc.modelassembly.DefaultModelAssembly;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class ModelService extends DefaultModelAssembly {
    @Override
    public <T extends Object, R extends Object> R doJdbcFunction(T target,JdbcFunction<T, R> function) {
        return super.doJdbcFunction(target, function);
    }
}
