/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.bean.forum;

import java.util.Date;

/**
 *
 * @author king
 */
public class NetNote {
    
    //  id 号  帖子的 id 号
    private String id = null;
    
    // 帖子的 标题
    private String title = null;
    
    //帖子的日期
    private Date date = null;
    
    //帖子的分类
    private String type = null;
    
    //帖子的主人
    private String userId = null;
    
    //简述
    
    private String describe = null;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public void setType(String type){
        this.type = type;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setUserId(String userId){
        this.userId = userId;
    }
    
    public String getUserId(){
        return this.userId;
    }
    
    public void setDescribe(String describe){
        this.describe = describe;
    }
    
    public String getDescribe(){
        return this.describe;
    }
}
