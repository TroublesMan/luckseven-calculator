/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service;

import com.king.wind.spring.boot.jdbc.function.JdbcFunction;
import java.util.List;
import king.application.web.spring.clouds.luckseven.calculator.model.function.ThreadJdbcFunction;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class ThreadJdbcFunctionService {

    private final ThreadJdbcFunction<JpaRepository, List, Object> find_all = new ThreadJdbcFunction<JpaRepository, List, Object>() {
        @Override
        public List doFunction(JpaRepository repository) {
            Object target = this.getTarget();
            return repository.findAll(Example.of(target));
        }
    };

    private final ThreadJdbcFunction<JpaRepository, Boolean, Object> insert = new ThreadJdbcFunction<JpaRepository, Boolean, Object>() {
        @Override
        public Boolean doFunction(JpaRepository repository) {
            Object target = this.getTarget();
            return repository.save(target) != null;
        }
    };

    private final ThreadJdbcFunction<JpaRepository, Boolean, Object> update = new ThreadJdbcFunction<JpaRepository, Boolean, Object>() {
        @Override
        public Boolean doFunction(JpaRepository repository) {
            Object target = this.getTarget();
            return repository.save(target) != null;
        }
    };

    private final ThreadJdbcFunction<JpaRepository, Boolean, Object> delete = new ThreadJdbcFunction<JpaRepository, Boolean, Object>() {
        @Override
        public Boolean doFunction(JpaRepository repository) {
            Object target = this.getTarget();
            repository.delete(target);
            return true;
        }
    };

    private final ThreadJdbcFunction<JpaRepository, Object, Object> find_one = new ThreadJdbcFunction<JpaRepository, Object, Object>() {
        @Override
        public Object doFunction(JpaRepository repository) {
            Object target = this.getTarget();
            return repository.findOne(Example.of(target)).orElse(null);
        }
    };

    private final ThreadJdbcFunction<JpaSpecificationExecutor,Page, Object[]> find_specification = new ThreadJdbcFunction<JpaSpecificationExecutor,Page, Object[]>() {

        @Override
        public Page doFunction(JpaSpecificationExecutor executor) {
            Object specificationAndPageable[] = this.getTarget();

            Specification specification = specificationAndPageable[0] != null ? (Specification) specificationAndPageable[0] : null;
            Pageable pageable = specificationAndPageable[1] != null ? (Pageable) specificationAndPageable[1] : null;
            //根据这个得到 相对应的 SpecificationAndPageable
            return executor.findAll(specification,pageable);
        }
    };

    public JdbcFunction<JpaRepository, List> findAll(Object target) {
        return this.function(find_all, target);
    }

    public JdbcFunction<JpaRepository, Object> findOne(Object target) {
        return this.function(this.find_one, target);
    }

    public JdbcFunction<JpaRepository, Boolean> insert(Object target) {
        return this.function(this.insert, target);
    }

    public JdbcFunction<JpaRepository, Boolean> update(Object target) {
        return this.function(this.update, target);
    }

    public JdbcFunction<JpaRepository, Boolean> delete(Object target) {
        return this.function(this.delete, target);
    }

    public ThreadJdbcFunction<JpaSpecificationExecutor,Page,Object[]> findAll(Specification specification, Pageable pageable) {
        //进行 相对应的 查询
        this.find_specification.setTarget(new Object[]{specification,pageable});
        return this.find_specification;
    }
    
    protected <T, R> ThreadJdbcFunction<JpaRepository, T, R> function(ThreadJdbcFunction<JpaRepository, T, R> function, R target) {
        function.setTarget(target);
        return function;
    }
}
