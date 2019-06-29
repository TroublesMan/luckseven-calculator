/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.bean.common;

/**
 *
 * @author king
 */
//服务提供者
public class Server {

    private String id = null;

    private String name = null;

    /*
    
    下面便是 与商户 相关的一系列的信息
    
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
