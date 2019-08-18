/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.controller;

import com.king.wind.spring.boot.jdbc.function.JdbcFunction;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Favorites;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Article;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.FavoritesRepository;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.LoginRepository;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.UserRepository;
import king.application.web.spring.clouds.luckseven.calculator.service.JdbcFunctionService;
import king.application.web.spring.clouds.luckseven.calculator.service.ModelService;
import king.application.web.spring.clouds.luckseven.calculator.service.jpa.JdbcService;
import king.application.web.spring.clouds.luckseven.calculator.service.jpa.PageableService;
import king.application.web.spring.clouds.luckseven.calculator.service.jpa.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.ArticleRepository;
import king.application.web.spring.clouds.luckseven.calculator.service.bean.ArticleContentService;

/**
 *
 * @author king
 */
@RequestMapping("search")
@RestController
public class SearchController {

    @Autowired
    private ModelService model;

    @Autowired
    private LoginRepository login;

    @Autowired
    private ArticleRepository article;

    @Autowired
    private ArticleRepository article_brief;

    @Autowired
    private ArticleContentService article_content_service;

    @Autowired
    private FavoritesRepository favorites;

    @Autowired
    private UserRepository user;

    @Autowired
    private JdbcFunctionService function;

    @Autowired
    private SpecificationService specification;

    @Autowired
    private PageableService pageable;

    @Autowired
    private JdbcService jdbc;

    /**
     *
     *
     * 第一个为 当前的 页数 第二份 页面的 大小 第三个为 正序倒序
     *
     *
     *
     * @param string
     * @param page_index
     * @param page_size
     * @return
     */
    @RequestMapping("article/brief")
    public Object find_all_article(String string, Integer page_index, Integer page_size) {

        //切记 ， 这个 article 也可以当做 相对应的 string
        // 需要 相对应的 默认 配置
        Pageable pageable = new PageRequest(page_index != null ? page_index : 0, page_size != null ? page_size : 10);

        //return this.model.doJdbcFunction(this.article,this.function.findAll(article));
        Page<Article> page = this.model
                .doJdbcFunction(this.article_brief,
                        this.function.findAll(this.specification.specification(new Specification<Article>() {
                            // 进行 相对应的 判定
                            @Override
                            public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                                //暂时 ， 设定为这样  ， 实际情况 ， 应该可以 让客户端自己设定 ， 减轻 相对应的 工作

                                //目前 只是 进行 相对应的 id 进行 搜索
                                String id = new StringBuilder().append("%").append(string).append("%").toString();
                                Predicate predicate = cb.like(root.get("id"), id);
                                return predicate;
                            }
                        }), pageable));

        return page.getContent();
    }

    // 输出 相对应的 Favorites 的 数量 
    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("article/favorites")
    public List<Map<String, Object>> searchFavoritesCount(@RequestBody List<String> id) {
        return this.model.doJdbcFunction(this.favorites, new JdbcFunction<FavoritesRepository, List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> doFunction(FavoritesRepository favorites) {
                return favorites.searchFavoritesCount(id);
            }
        });
    }

    //对于 favorites  并没有 许多的 操作 ， 因此 ， 我们 就可以直接 使用 findAll ,target 方法 来完成 ， 我们想要的效果
    @RequestMapping("favorites")
    public Object find_all_favorites(Favorites favorites, Integer page_index, Integer page_size) {
        Pageable pageable = new PageRequest(page_index != null ? page_index : 0, page_size != null ? page_size : 10);

        //return this.model.doJdbcFunction(this.article,this.function.findAll(article));
        return this.model.doJdbcFunction(this.favorites, this.function.findAll(favorites, pageable));
    }

    @RequestMapping("favorites/article/brief")
    public Object find_all_favorites_article(Favorites favorites, Integer page_index, Integer page_size) {
        //由于 逻辑 比较 复杂 ， 因此  ，我们 需要 将 结构 进一步的 细分
        //我们 生成 相对应的 function
        JdbcFunction<ArticleRepository, List<Article>> _function = new JdbcFunction<ArticleRepository, List<Article>>() {
            @Override
            public List<Article> doFunction(ArticleRepository repository) {

                //我们 得到 目标 信息 id;
                String user_id = favorites.getUserId();

                System.out.println("user id is :\n " + user_id);
                //相对应的 进行数据
                int start = page_index * page_size;
                int end = start + page_size;

                //进行 输入 相对应的 信息
                return repository.favorites(user_id, start, end);
            }
            //相对应 进行 修饰 其他的 东西
        };
        //相对应的 进行  输入 方法 
        System.out.println("hello");
        return this.model.doJdbcFunction(this.article_brief, _function);
    }

    /*
    @RequestMapping("subscribe/article/brief")
    public Object find_all_subscribe_article(Subscribe subscribe, Integer page_index, Integer page_size) {
        return this.model.doJdbcFunction(this.article_brief, new JdbcFunction<articleBriefRepository, List<articleBrief>>() {
            @Override
            public List<articleBrief> doFunction(articleBriefRepository repository) {
                int start = page_index * page_size;
                int end = start + page_size;
                return repository.subscribe(subscribe.getUserId(), start, end);
            }

        });

    }
     */
    
    
    @RequestMapping("article/content")
    public Object like_article_content( String text){
        
        StringBuilder builder = new StringBuilder();
        
        for(int index = 0 ; index < text.length(); index++ ){
            
            char word = text.charAt(index);
            
            builder.append("%")
                    .append(word);
        }
        
        builder.append("%");
        
        return this.article_content_service.findByLike(builder.toString());
        
    }
    
}
