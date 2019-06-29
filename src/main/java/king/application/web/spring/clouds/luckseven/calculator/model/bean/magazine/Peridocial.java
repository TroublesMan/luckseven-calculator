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

//确定的是期刊的一本杂志
@Entity
@Table(name = "peridocial")
public class Peridocial{
    
    //这本期刊的书 id
    @Id
    private String id = null;
    
    //相对应的封面
    @Column(name="magazine_id")
    private String magazineId = null;
    
    @Column(name="_describe")
    private String describe = null;
    
    //这本杂志的封面主题
    private String name = null;
    
    //这本杂志的更新日期
    @Column(name="_date")
    private Date date = null;
    //页数
    //private int count;
    @Column(name = "_count")
    private Integer count = null;
    //第几期
    
    private Integer number = null;
    //private int number ;
    
    //本期的杂志封面
    @Column(name="_image")
    private String image = null;
    
    @Column(name="_href")
    private String href = null;
    
    public void setId( String id ){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setMagazineId(String peridocialId){
        this.magazineId = peridocialId;
    }
    
    public String getMagazineId(){
        return this.magazineId;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public Date getDate(){
        return this.date;
    }
    
    public void setCount(Integer count){
        this.count = count;
    }
    
    public Integer getCount(){
        return this.count;
    }
    
    public void setNumber(Integer number){
        this.number = number;
    }
    
    public Integer getNumber(){
        return this.number;
    }
    
    public void setImage(String href){
        this.image= href;
    }
    
    public String getImage(){
        return this.image;
    }
    
    public void setHref(String href){
        this.href = href;
    }
    
    public String getHref(){
        return this.href;
    }
    
    public void setDescribe(String describe){
        this.describe = describe;
    }
    
    public String getDescribe(){
        return this.describe;
    }
    
}
