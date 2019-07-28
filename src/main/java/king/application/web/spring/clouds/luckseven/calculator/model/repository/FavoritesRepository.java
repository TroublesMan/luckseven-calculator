/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.repository;

import java.util.List;
import java.util.Map;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Favorites;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.annotation.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author king
 */
@Model(bean = Favorites.class)
public interface FavoritesRepository extends JpaRepository<Favorites,String> ,JpaSpecificationExecutor<Favorites> {
    
    // 根据 目标的 id 来获取 获取 相对应的 favorites 的 信息
    
    @Query(value = "SELECT f.peridocial_id as id , count(f.id) as favorites_count FROM favorites f WHERE f.peridocial_id in ( :id  )  GROUP BY f.peridocial_id" , nativeQuery = true)
    public  List<Map<String,Object>> searchFavoritesCount(@Param("id") List<String> id );
    
}
