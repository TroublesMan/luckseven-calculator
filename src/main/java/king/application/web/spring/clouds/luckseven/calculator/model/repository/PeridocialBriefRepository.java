/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.repository;

import java.util.List;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.PeridocialBrief;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.annotation.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author king
 */
@Model(bean = PeridocialBrief.class)
public interface PeridocialBriefRepository extends JpaRepository<PeridocialBrief, String>, JpaSpecificationExecutor<PeridocialBrief> {

    @Query(value = "select p.* from peridocial p where p.id in ( select f.peridocial_id from favorites f where f.user_id = :userId  order by f._time desc) limit :start , :end ", nativeQuery = true)
    public List<PeridocialBrief> favorites(@Param("userId") String user_id, @Param("start") int start, @Param("end") int end);

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
    @Query(value = "select p.* from peridocial p WHERE p.magazine_id in ( select s.magazine_id  from subscribe s where s.user_id = :userId ) order by p._date limit :start , :end ", nativeQuery = true)
    public List<PeridocialBrief> subscribe(@Param("userId") String user_id, @Param("start") int start, @Param("end") int end);

}
