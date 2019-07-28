/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service.jpa;

import com.king.wind.spring.boot.jdbc.function.JdbcFunction;
import java.util.List;
import java.util.Map;
import king.application.web.spring.clouds.luckseven.calculator.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class JdbcService {
    
    @Autowired
    private JdbcTemplate template;
    
    @Autowired
    private ModelService model;
    
    /**
     * 
     * @param string 查询关键字
     * @param page 相对应的 页数 
     * @param count 相对应的 每一页的 大小
     * @return 
     */
    public List<Map<String,Object>> findPeridocialBriefOfFavorites(String string , int page , int count){
        final String  sql =  "SELECT p.* , count(p.id) FROM peridocial p ,favorites f WHERE p.id = f.peridocial_id  AND p.name LIKE ?  GROUP BY (p.id)  LIMIT ? , ?; " ;
        
        //计算 获取 相对应的 起始值 
        int start = page * count ; 
        
        //计算 获取 相对应的 
        int end = start + count;
        //开始 获取 相对应的 值 
        return this.model.doJdbcFunction(template,new JdbcFunction<JdbcTemplate ,List<Map<String,Object>>>(){
            @Override
            public List<Map<String, Object>> doFunction(JdbcTemplate template) {
                return template.queryForList(sql , string , start , end );
            }
            
        });
    }
    
    
    //暂时 先不进行 jdbcFunction的 封闭 
    /**
     * 输出 相对应的 信息 
     * 相对应的 架构为 { id : xx , favorites_count : xx }
     * 
     * @param id 相对应的 ， id号码 
     * @return 
     */
    public List<Map<String,Object>> searchFavoritesCount(List<String> id ){
        
        final String sql = "SELECT f.peridocial_id as id , count(f.id) as favorites_count FROM favorites f WHERE f.peridocial_id in ( ? )  GROUP BY f.peridocial_id" ; 
        
        return this.template.queryForList(sql , id );
    }
}
