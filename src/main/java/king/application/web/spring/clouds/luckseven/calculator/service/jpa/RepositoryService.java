/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service.jpa;

import com.king.wind.spring.boot.jdbc.function.JdbcFunction;
import king.application.web.spring.clouds.luckseven.calculator.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

/**
 *
 * @author king
 */
@Service
public class RepositoryService {

    @Autowired
    private ApplicationContext application_context;

    @Autowired
    private ModelService model;

    public <T extends JpaRepository> T getRepository(Class<T> repository_class) {
        return application_context.getBean(repository_class);
    }

    public <R> R doJdbcFunction(JdbcFunction<RepositoryService, R> function) {
        //输出 相对应的 信息
        return this.model.doJdbcFunction(this, function);
    }
}
