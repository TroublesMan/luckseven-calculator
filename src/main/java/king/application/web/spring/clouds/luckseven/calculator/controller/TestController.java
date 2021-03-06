/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.common.Login;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Article;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.FavoritesRepository;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.LoginRepository;
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
import king.application.web.spring.clouds.luckseven.calculator.model.repository.ArticleRepository;

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
    private ArticleRepository article;
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private ApplicationService application;
    
    @Autowired
    private FavoritesRepository favorites;
    
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
    public Object thread_function_test(Article article){
        return this.model.doJdbcFunction(this.article,this.thread_function.findAll(article));
    }
    
    
    @RequestMapping("thread/specification")
    public Object thread_specification(){
        return this.model.doJdbcFunction(this.article, this.thread_function.findAll(new Specification<Article>() {
            @Override
            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                
                return cb.equal(root.get("id"),"a124");
                
            }
        },Pageable.unpaged()));
    }
    
    
    //相对应的 输出 信息 
    
    //为相对应的 方式 测试 一下 输出的 方式
    
    @RequestMapping("article/favorites")
    public List<Map<String, Object>> searchFavoritesCountTest() {
        List<String> list_id = new ArrayList<>();

        list_id.add("a123");
        list_id.add("a124");
        return this.favorites.searchFavoritesCount(list_id);
        
    }


}
