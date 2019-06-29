/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service.jpa;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class SpecificationService {

    //将 后面的 输出点 进行输出 转换
    public <T> Specification<T> specification(Specification<T> specification) {
        
        return specification;
    }
    
    public <T> Specification<T> brige(BridgeSpecification<T> bridge , Specification<T> specification){
        bridge.setSpecification(specification);
        return bridge;
    }

    private abstract class BridgeSpecification<T> implements Specification<T> {

        private Specification<T> specification = null;

        public void setSpecification(Specification<T> specification) {
            this.specification = specification;
        }

        public Specification<T> getSpecification() {
            return this.specification;
        }
        
    }
}
