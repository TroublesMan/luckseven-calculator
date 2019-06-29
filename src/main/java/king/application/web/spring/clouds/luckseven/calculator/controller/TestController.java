/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.controller;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.common.Login;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Peridocial;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.LoginRepository;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.PeridocialRepository;
import king.application.web.spring.clouds.luckseven.calculator.service.ApplicationService;
import king.application.web.spring.clouds.luckseven.calculator.service.JdbcFunctionService;
import king.application.web.spring.clouds.luckseven.calculator.service.ModelService;
import king.application.web.spring.clouds.luckseven.calculator.service.ThreadJdbcFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author king
 */
@RequestMapping("test")
@RestController
public class TestController {
    
    @Autowired
    private ModelService model;
    
    @Autowired
    private LoginRepository login;
    
    @Autowired
    private ThreadJdbcFunctionService thread_function;
    
    @Autowired
    private PeridocialRepository peridocial;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private ApplicationService application;
    
    @RequestMapping("hello")
    public Object hello(){
        return "hello";
    }
    
    @RequestMapping("model")
    public Object model(){
        return this.model.toString();
    }
    
    @RequestMapping("applicationContext")
    public Object applicationContext(){
        StringBuilder builder = new StringBuilder();
        
        for(String name : this.applicationContext.getBeanDefinitionNames()){
            builder.append("<br><h4>").append(name).append("</h4><br>");
        }
        
        builder.append("<h4>").append(this.applicationContext.getBeanDefinitionCount()).append("</h4>");
        return builder.toString();
    }
    
    @Autowired
    private JdbcFunctionService function;
    
    @RequestMapping("login/informations")
    public Object login_informations(){
        return this.model.doJdbcFunction(login,this.function.findAll(new Login()));
    }
    
    
    @RequestMapping("thread/function")
    public Object thread_function_test(Peridocial peridocial){
        return this.model.doJdbcFunction(this.peridocial,this.thread_function.findAll(peridocial));
    }
    
    
    @RequestMapping("thread/specification")
    public Object thread_specification(){
        return this.model.doJdbcFunction(this.peridocial, this.thread_function.findAll(new Specification<Peridocial>() {
            @Override
            public Predicate toPredicate(Root<Peridocial> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                
                return cb.equal(root.get("id"),"a124");
                
            }
        },Pageable.unpaged()));
    }
    

}
