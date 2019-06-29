/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.controller;

import javax.servlet.http.HttpServletRequest;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.common.Login;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.common.User;
import king.application.web.spring.clouds.luckseven.calculator.model.bean.magazine.Peridocial;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.LoginRepository;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.PeridocialRepository;
import king.application.web.spring.clouds.luckseven.calculator.model.repository.UserRepository;
import king.application.web.spring.clouds.luckseven.calculator.service.ApplicationService;
import king.application.web.spring.clouds.luckseven.calculator.service.JdbcFunctionService;
import king.application.web.spring.clouds.luckseven.calculator.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author king
 */

@RestController
@RequestMapping("show")
public class ShowController {
    
    @Autowired
    private PeridocialRepository peridocial;
    
    @Autowired
    private LoginRepository login;
    
    @Autowired
    private UserRepository user;
    
    @Autowired
    private JdbcFunctionService function;
    
    @Autowired
    private ModelService model;
    
    @Autowired
    private ApplicationService application;
    
    //获取 目前的相对应信息
    @RequestMapping("peridocial")
    public Object show_peridocial(HttpServletRequest request , Peridocial peridocial){
        System.out.println(request.getParameterMap());
        
        System.out.println(peridocial.getId());
        return this.model.doJdbcFunction(this.peridocial, this.function.findOne(peridocial));
    }
    
    @RequestMapping("user")
    public Object show_user(User user){
        return this.model.doJdbcFunction(this.user,this.function.findOne(user));
    }
    
    /**
     * 
     * 根据 相对应的 login  来获取 相对应的 User 信息
     * 
     * @param login
     * @param user
     * @param request
     * @return 
     */
    @RequestMapping("login")
    public User login(Login login , User user){
        
        //这里 或许 还需要 更上层的 修改 ， 比如说

        //这里切记 ， 不能让 login, id , 与 password ， 其中一项为空
        
        //获取 相对应的 信息 来确定是否登录成功
        Login _login = this.model.doJdbcFunction(this.login,this.function.findOne(login));
        
        System.out.println("this is a hello");
        
        System.out.println(new StringBuilder().append(this.application.json(login)).append("\n")
        .append(this.application.json(user)).toString());
        
        if(_login == null){
            //倘若 _login 信息 为空， 则登录失败
            return null;
        }
        
        //否则返回 相对应的 User 信息 ，
        //PS ， 其实 不应该单单 只能返回 相对应的 _login , 但是 目前 ， 我们暂时 设定 相对应的 信息
        
        //这时候才能使用 相对应的 方法 来获取 相对应的 信息
        return this.model.doJdbcFunction(this.user ,this.function.findOne(user));
    }
    
}
