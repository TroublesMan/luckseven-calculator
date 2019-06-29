/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.bean.common;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author king
 */

//一般用户
@Entity
@Table(name = "user")
public class User {
    @Id
    private String id = null;
    
    private String username = null;
    
    /*
    
    下面便是 与用户 相关的一系列的信息
    
    */
    
    public void setId(String id){
        this.id = id ;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setUsername(String name){
        this.username = name;
    }
    
    public String getUsername(){
        return this.username;
    }
    
}
