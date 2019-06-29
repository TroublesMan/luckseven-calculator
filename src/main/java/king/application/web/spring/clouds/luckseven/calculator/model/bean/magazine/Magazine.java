/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author king
 */
//命名上还是有点问题，还需要后期我们再来校对一下
//并不是代表某一本数，而是代表着相对应的某一公司的一个连载期刊的定义
@Entity
@Table(name = "magazine")
public class Magazine {

    //private String id = null;
    //相对应 ISBN ，也可能是 
    @Id
    private String isbn = null;

    //期刊名
    private String name = null;

    //期刊属于哪个商户 ， 连接商户的 id 名
    private String belongto = null;

    //期刊的更新周期 , 日更，周更 ，月更 ，年更 等等等等
    private String period = null;

    //期刊的主题 
    private String title = null;

    //期刊的宣传页面
    private String image = null;

    /*期刊的一些周边信息，比如说  ，主编 ，作者 =======
       这一部分还未确定，应该，要进行一些商榷之后才能确定 
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBelongto(String belongto) {
        this.belongto = belongto;
    }

    public String getBelongto() {
        return this.belongto;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }
}
