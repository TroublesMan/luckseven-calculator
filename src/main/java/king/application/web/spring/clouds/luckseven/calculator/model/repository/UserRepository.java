/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.repository;

import king.application.web.spring.clouds.luckseven.calculator.model.bean.common.User;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.annotation.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author king
 */
@Model(bean = User.class)
public interface UserRepository extends JpaRepository<User,String> ,JpaSpecificationExecutor<User>{
    
    // 用 相对应 符合 sql的 方法 ， 来完成 登录操作 ， 并且 获取 相对应的 信息
    /**
     * 
     * 使用 相对应的 sql的 方法 ， 
     * 来完成 相对应的 数据 输入
     * 
     * @param id
     * @param password
     * @return 
     */
    @Query(value=" SELECT u.* FROM user u , login l WHERE u.id = l.id and l.id = :id and l.password = :password",nativeQuery=true)
    public User login(@Param("id") String id , @Param("password") String password);

}
