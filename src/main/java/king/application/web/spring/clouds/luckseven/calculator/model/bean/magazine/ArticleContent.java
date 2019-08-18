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
@Table(name = "article_content")
public class ArticleContent {
    
    @Id
    private String id = null;
    
    @Column(name="content")
    private String content = null;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }    
    
    public void setContent(String content ){
        this.content = content;
    }
    
    public String getContent(){
        return this.content;
    }
}
