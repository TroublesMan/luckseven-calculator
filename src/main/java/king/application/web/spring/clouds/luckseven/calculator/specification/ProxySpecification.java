/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.specification;

import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author king
 */
public abstract class ProxySpecification<T> implements Specification<T>{

        private final Specification<T> specification;
        
        public ProxySpecification (Specification<T> specification){
            this.specification = specification;
        }
        
        public Specification<T> specification(){
            return this.specification;
        }
        
    }