/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.controller;

import com.king.wind.spring.boot.jdbc.function.JdbcFunction;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Favorites;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.FavoritesRepository;
import king.application.web.spring.clouds.luckseven.calculator.service.ModelService;
import king.application.web.spring.clouds.luckseven.calculator.service.jpa.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author king
 */
@RequestMapping("count")
@RestController
public class CountController {

    @Autowired
    private ModelService model;

    @Autowired
    private FavoritesRepository favorites;

    @Autowired
    private JpaService jpa;

    @RequestMapping("favorites/count")
    public Object favorites_count(Favorites favorites) {

        return this.model
                .doJdbcFunction(this.favorites, new JdbcFunction<FavoritesRepository, Long>() {
                    @Override
                    public Long doFunction(FavoritesRepository repository) {
                        return jpa.count(repository, favorites);
                    }
                });

    }

}
