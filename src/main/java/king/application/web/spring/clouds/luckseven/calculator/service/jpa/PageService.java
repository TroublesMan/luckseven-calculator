/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class PageService {
    
    public Map<String,Object> toInformationMap(Page page){
        HashMap<String,Object> map = new HashMap<>();
        
        //全部 数值的 总数
        map.put("totalElement", page.getTotalElements());
        //页面的 总数
        map.put(null,page.getTotalPages());
        //当前 页面数字
        map.put(null,page.getNumber());
        //这个 number  里面 有 多少 elements
        map.put(null, page.getNumberOfElements());
        //页面的 大小
        map.put(null, page.getSize());
        map.put(null,page.getContent());
        return map;
    }
    
    public <T> List<T> getContext(Page<T> page){
        return page.getContent();
    }
    
}
