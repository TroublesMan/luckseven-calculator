/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.bean.common;

/**
 *
 * @author king
 */
public interface Function<T,M> {
    
    public M doFunction(T target);
    
}
