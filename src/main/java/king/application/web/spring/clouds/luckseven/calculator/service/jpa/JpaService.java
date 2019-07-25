/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service.jpa;

import com.king.wind.spring.boot.jdbc.function.JdbcFunction;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.common.Function;
import king.application.web.spring.clouds.luckseven.calculator.service.JdbcFunctionService;
import king.application.web.spring.clouds.luckseven.calculator.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class JpaService {
    
    @Autowired
    private ModelService model;
    
    @Autowired
    private JdbcFunctionService function;
    
    @Autowired
    private RepositoryService repository;
    
     //下面 ， 我们 开始 设计 范围缩减 
    
    public <T> Optional<T> findOne(JpaRepository<T,?> repository , T target ){
        return repository.findOne(Example.of(target));
    }
    
    public <T> Page<T> findAll(JpaRepository<T, ?> repository, T target, Pageable pageable) {

        return repository.findAll(Example.of(target), pageable);
    }

    public <T> Page<T> findAll(JpaSpecificationExecutor<T> executor, Specification<T> speicification, Pageable pageable) {
        //输出 相对应的 信息
        return executor.findAll(speicification, pageable);
    }


    public <T> Boolean save(JpaRepository<T, ?> repository, T target){
        return repository.save(target) != null ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public <T> Boolean update(JpaRepository<T,?> repository , T target){
        // 相对应的 更新 相对应的 值
        return repository.exists(Example.of(target)) ? this.save(repository, target) : Boolean.FALSE;
    }
    
    public <T> Boolean insert(JpaRepository<T,?> repository , T target){
        //输出 相对应的值
        return repository.exists(Example.of(target)) ? Boolean.FALSE : this.save(repository, target);
    }
    
    
    public <T> Specification<T> specification(T target){
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Class targetClass = target.getClass();
                Field[] fields = targetClass.getDeclaredFields();
                
                ArrayList<Predicate> predicates = new ArrayList<>();
                
                for(Field field : fields){
                    
                    //通过获取 column ， 来确定 是否 这个值  ， 是不是 我们需要使用的 字段 ，且知道， 在数据库中 ， 该字段 名
                    Column column = field.getAnnotation(Column.class);
                    
                    if(column == null){
                        continue;
                    }
                    //获取 相对应的 值
                    Object value = null;
                    try{
                    value = field.get(target);
                    }catch(Exception e ){}
                    //得到相对应的 predicate
                    Predicate predicate = cb.equal(root.get(column.name()), value);
                    predicates.add(predicate);
                }
                
                //最后返回全部的 predicates
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
    
    public <T,M> List<T> oneToMany(M one,BeanFunction<M,T> function,Pageable pageable) throws Exception{
        //得到 相对应的 模板
        JpaRepository<T,?> repository = null;
        
        // 最大的 问题 ， 便是 如何 one ， 装饰相对应的 template
        
        //主要的 工作 便是将 one, 某个属性 ， 赋值到 template 中
        /**
         * 我们 在这里 使用的是 function的方法
         */
        
        T template = function.doFunction(one);
        
        //最终我们是使用 相对应的 repository , 进行 findAll 的 查询
        
        return null;
    }
    
    public <T,M> T manyToOne(M target ,BeanFunction<M,T> function){
        
        JpaRepository<T,?> repository = null;
        
        T template = function.doFunction(target);
        
        return this.model.doJdbcFunction(repository, this.function.findOne(template)).orElse(null);
    }
    
    public interface BeanFunction<T,M> extends Function<T,M>{} 
    
}
