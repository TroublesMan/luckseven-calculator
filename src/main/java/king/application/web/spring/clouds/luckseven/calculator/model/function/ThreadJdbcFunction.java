/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.function;

import com.king.wind.spring.boot.jdbc.function.JdbcFunction;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author king
 * @param <Parameter>
 * @param <Result>
 */
public abstract class ThreadJdbcFunction<Parameter,Result,T> implements JdbcFunction<Parameter,Result>{
    
    private final ConcurrentHashMap<Thread,T> map = new ConcurrentHashMap<>();
    
    public void setTarget(T target){
        this.map.put(Thread.currentThread(), target);
    }
    
    public T getTarget(){
        return this.map.get(Thread.currentThread());
    }
    
}