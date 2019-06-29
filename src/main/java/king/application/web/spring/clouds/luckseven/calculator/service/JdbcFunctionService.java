/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.service;

import com.king.wind.spring.boot.jdbc.function.JdbcFunction;
import java.util.List;
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
public class JdbcFunctionService {

    //查找全部
    public <T, C extends JpaRepository<T, ?>> JdbcFunction<C, List<T>> findAll(T target, Pageable pageable) {
        return new JdbcFunction<C, List<T>>() {
            @Override
            public List<T> doFunction(C repository) {
                return repository.findAll(Example.of(target), pageable).getContent();
            }
        };
    }

    public <T, C extends JpaRepository<T, ?>> JdbcFunction<C, List<T>> findAll(T target) {
        return this.findAll(target, Pageable.unpaged());
    }

    /**
     *
     * 第二次 findAll , 改进 ， 因为 ， 在显示 业务中 ， 我们几乎 不可能会遇到搜寻全部
     *
     * 所以 ， 查询 都会有一定的 约束条件 ， 所以 ， 第一步 修改 ， 我们会把 相对应的 修改方式 ， 变成 ， 修改 但是 ， 约束条件有着
     * 不确定性 ， 因此 ， 我们只能通过修改 Specification 来进行 我们的 工作
     *
     * @param <T>
     * @param <C>
     * @param specification
     * @param pageable
     * @return
     */
    public <T, C extends JpaSpecificationExecutor<T>> JdbcFunction<C, Page<T>> findAll(Specification<T> specification, Pageable pageable) {
        return new JdbcFunction<C, Page<T>>() {
            @Override
            public Page<T> doFunction(C executor) {
                Page<T> page = executor.findAll(specification, pageable);
                return page;
            }

        };

    }

    public <T, C extends JpaSpecificationExecutor<T>> JdbcFunction<C, Page<T>> findAll(Specification<T> specification) {
        return this.findAll(specification, Pageable.unpaged());
    }

    //我们 开始 另一个 方法 的 策略
    
    // 查找一次
    public <T, C extends JpaRepository<T, ?>> JdbcFunction<C, T> findOne(T target) {
        return new JdbcFunction<C, T>() {
            @Override
            public T doFunction(C repository) {
                return repository.findOne(Example.of(target)).orElse(null);
            }
        };
    }

    // 更新 相对应的 数据
    public <T, C extends JpaRepository<T, ?>> JdbcFunction<C, Boolean> update(T target) {
        return new JdbcFunction<C, Boolean>() {
            @Override
            public Boolean doFunction(C repository) {
                return repository.save(target) != null;
            }
        };
    }

    //删除 相对应的 数据
    public <T, C extends JpaRepository<T, ?>> JdbcFunction<C, Boolean> delete(T target) {
        return new JdbcFunction<C, Boolean>() {
            @Override
            public Boolean doFunction(C repository) {
                repository.delete(target);
                return true;
            }
        };
    }

    //插入 相对应的 数据 
    public <T, C extends JpaRepository<T, ?>> JdbcFunction<C, Boolean> insert(T target) {
        return new JdbcFunction<C, Boolean>() {
            @Override
            public Boolean doFunction(C repository) {

                //只有当 不存在 时，才允许 进行 插入
                if (!repository.exists(Example.of(target))) {
                    return repository.save(target) != null;
                }
                return false;
            }
        };
    }
}
