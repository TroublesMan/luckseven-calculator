/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service.bean;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.ArticleContent;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.ArticleContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class ArticleContentService {
    
    @Autowired
    private ArticleContentRepository article_content;
    
    public List<ArticleContent> findByLike( String string ){
        
        return this.article_content.findAll( new Specification<ArticleContent>() {
            @Override
            public Predicate toPredicate(Root<ArticleContent> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                
                return cb.like(root.get("content"), string);
                
            }
        });
        
    }
    
}
