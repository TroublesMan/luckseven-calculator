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

/**
 *
 * @author king
 */
@Model(bean = User.class)
public interface UserRepository extends JpaRepository<User,String> ,JpaSpecificationExecutor<User>{

}
