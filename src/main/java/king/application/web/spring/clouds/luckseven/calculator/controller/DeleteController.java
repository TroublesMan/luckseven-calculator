/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.controller;

import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Favorites;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Article;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.FavoritesRepository;
import king.application.web.spring.clouds.luckseven.calculator.service.JdbcFunctionService;
import king.application.web.spring.clouds.luckseven.calculator.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.ArticleRepository;

/**
 *
 * @author king
 */
@RestController
@RequestMapping("delete")
public class DeleteController {
    
    @Autowired
    private ModelService model;
    
    @Autowired
    private JdbcFunctionService jdbcfunction;
    
    @Autowired
    private FavoritesRepository favorites;
    
    @Autowired
    private ArticleRepository article;
    
    @RequestMapping("article")
    public Object delete_article(Article article){
        
        return this.model.doJdbcFunction(this.article, this.jdbcfunction.delete(article));
    }
    
    @RequestMapping("favorites")
    public Object delete_favorites(Favorites favorites){
        return this.model.doJdbcFunction(this.favorites, this.jdbcfunction.delete(favorites));
    }
    
}
