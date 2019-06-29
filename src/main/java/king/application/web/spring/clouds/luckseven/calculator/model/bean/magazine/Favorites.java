/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author king
 */
@Entity
@Table(name = "favorites")
public class Favorites {
    
    @Id
    private String id = null;
    
    @Column(name = "user_id")
    private String userId = null;
    
    @Column(name = "peridocial_id")
    private String peridocialId = null;
    
    @Column(name = "_time")
    private Date time = null;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setUserId(String userId){
        this.userId = userId;
    }
    
    public String getUserId(){
        return this.userId;
    }
    
    public void setPeridocialId(String peridocialId){
        this.peridocialId = peridocialId;
    }
    
    public String getPeridocialId(){
        return this.peridocialId;
    }
    
    public void setTime(Date time){
        this.time = time;
    }
    
    public Date getTime(){
        return this.time;
    }
}