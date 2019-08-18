/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service;

import com.alibaba.fastjson.JSON;
import java.util.List;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Article;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Article;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */

//并不会完全采用相对应的 ajax 的方式 ， 但也不会完全不采用 ， 按照最简单的方式入手
@Service
public class ApplicationService {
    
    private List<Article> peridocials = null;
    
    //获取 相对应 系统内的数据 的 固定数据
    
    
    public String json(Object target){
        return JSON.toJSONString(target);
    }
    
    //用来 保存 相对应的 与 系统希希 相关的 那些 东西
    
    /**
     * 
     * 最近 最多人 喜欢的 那些 东西 
     * 
     *
     * @return  */
    
    public List<Article> most(){
        //目前 ， 我们 就暂时 最后 一次 传输的 那些 数据 
        return this.peridocials;
    }
    
    public void setMost(List<Article> peridocials){
        this.peridocials = peridocials;
    }
}
