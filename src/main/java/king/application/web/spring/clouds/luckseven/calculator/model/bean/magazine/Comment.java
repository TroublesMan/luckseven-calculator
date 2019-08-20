/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author king
 */

@Entity
@Table(name = "comment")
public class Comment {
    
    @Id
    private String id = null;
    
    @Column(name="user_id")
    private String userId = null;
    
    @Column(name="content")
    private String content = null;
    
    @Column(name="create_time")
    private String createTime = null;
    
    @Column(name="belongto")
    private String belongto = null;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setUserId( String userId ){
        this.userId = userId;
    }
    
    public String getUserId(){
        return this.userId;
    }
    
    public void setContent( String content ){
        this.content = content;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public void setCreateTime( String createTime ){
        this.createTime = createTime;
    }
    
    public String getCreateTime(){
        return this.createTime;
    }
    
    public void setBelongto( String belongto ){
        this.belongto = belongto;
    }
    
    public String getBelongto(){
        return this.belongto;
    }
    
}
