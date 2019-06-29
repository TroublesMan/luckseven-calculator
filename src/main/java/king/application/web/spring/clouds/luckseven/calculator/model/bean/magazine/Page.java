/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine;

/**
 *
 * @author king
 */

//可能会不需要

public class Page {
    
    //属于那一本杂志
    private String id = null;
    
    //第 n 页
    //private int index;
    private Integer index = null;
    
    //相对应的页面地址
    private String href = null;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public int getIndex(){
        return this.index;
    }
    
    public void setHref(String href){
        this.href = href;
    }
    
    public String getHref(){
        return this.href;
    }
}
