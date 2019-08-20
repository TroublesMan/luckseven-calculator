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
@Table(name = "summary_article")
public class ArticleSummary {
    
    @Id
    private String id = null;
    
    @Column(name="name")
    private String name = null;
    
    @Column(name="article_id")
    private String articleId = null;
    
    @Column(name="create_time")
    private String createTime = null;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setName( String name ){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setArticleId( String articleId ){
        this.articleId = articleId;
    }
    
    public String getArticleId(){
        return this.articleId;
    }
    
    public void setCreateTime( String createTime ){
        this.createTime = createTime;
    }
    
    public String getCreateTime(){
        return this.createTime;
    }
    
}
