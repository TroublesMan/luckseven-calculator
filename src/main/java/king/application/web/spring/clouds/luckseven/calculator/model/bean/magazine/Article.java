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
@Table(name = "article")
public class Article {

    //这本期刊的书 id
    @Id
    private String id = null;

    @Column(name = "_describe")
    private String describe = null;

    //这本杂志的封面主题
    private String name = null;

    //这本杂志的更新日期
    @Column(name = "_date")
    private Date date = null;
    //页数

    //本期的杂志封面
    @Column(name = "_image")
    private String image = null;

    @Column(name = "belongto")
    private String belongto = null;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return this.date;
    }

    public void setImage(String href) {
        this.image = href;
    }

    public String getImage() {
        return this.image;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return this.describe;
    }

    public void setBelongto(String belongto) {
        this.belongto = belongto;
    }

    public String getBelongto() {
        return this.belongto;
    }

}
