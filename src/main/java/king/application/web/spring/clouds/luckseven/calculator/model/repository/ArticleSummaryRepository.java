/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.repository;

import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author king
 */
public interface ArticleSummaryRepository extends JpaRepository<Favorites,String> ,JpaSpecificationExecutor<Favorites> {
    
}
