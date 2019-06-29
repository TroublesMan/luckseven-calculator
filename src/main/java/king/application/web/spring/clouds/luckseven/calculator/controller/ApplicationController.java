/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.controller;

import king.application.web.spring.clouds.luckseven.calculator.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author king
 */
@RequestMapping("application")
@RestController
public class ApplicationController {
    
    @Autowired
    private ApplicationService application ; 
    
    @RequestMapping("most")
    public Object most(){
        return this.application.most();
    }
    
}
