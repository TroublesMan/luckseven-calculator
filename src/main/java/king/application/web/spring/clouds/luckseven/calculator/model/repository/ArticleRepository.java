/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.repository;

import java.util.List;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Article;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.annotation.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author king
 */
@Model(bean = Article.class)
public interface ArticleRepository extends JpaRepository<Article, String>, JpaSpecificationExecutor<Article> {

    @Query(value = "select p.* from article p where p.id in ( select f.article_id from favorites f where f.user_id = :userId  order by f._time desc) limit :start , :end ", nativeQuery = true)
    public List<Article> favorites(@Param("userId") String user_id, @Param("start") int start, @Param("end") int end);

    /**
     * 可以 根据 目标用户的 某一个 时间 ， 来返回 相对应的 目标 订阅的 图书 更新的 了 基本 图书
     *
     * 那么 我们 就需要 几个 元素的 东西
     *
     * 订阅 表 peridocial 表
     *
     * @param user_id
     * @param start
     * @param end
     * @return 
     */

}
