/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service.jpa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class PageableService {
    
    //获取 相对应的 数值
    public Pageable search(Pageable pageable){
        return pageable != null ? new PageRequest(pageable.getPageNumber(),pageable.getPageSize(),pageable.getSort()) : 
                new PageRequest(0 , 10 , Sort.unsorted());
    }
    
    public Pageable system(Pageable pageable){
        System.out.println(pageable.getPageNumber());
        return pageable;
    }
}
