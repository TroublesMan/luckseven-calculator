/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.controller;

import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Favorites;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Peridocial;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.FavoritesRepository;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.PeridocialRepository;
import king.application.web.spring.clouds.luckseven.calculator.service.JdbcFunctionService;
import king.application.web.spring.clouds.luckseven.calculator.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private PeridocialRepository peridocial;
    
    @RequestMapping("peridocial")
    public Object delete_peridocial(Peridocial peridocial){
        
        return this.model.doJdbcFunction(this.peridocial, this.jdbcfunction.delete(peridocial));
    }
    
    @RequestMapping("favorites")
    public Object delete_favorites(Favorites favorites){
        return this.model.doJdbcFunction(this.favorites, this.jdbcfunction.delete(favorites));
    }
    
}
