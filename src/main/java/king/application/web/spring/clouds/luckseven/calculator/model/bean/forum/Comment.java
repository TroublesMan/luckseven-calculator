/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package king.application.web.spring.clouds.luckseven.calculator.model.bean.forum;

import king.application.web.spring.clouds.luckseven.calculator.model.bean.forum.basic.Text;

/**
 *
 * @author king
 */
public class Comment extends Text {

    // 目标帖子id
    private String message = null;

    /*
        //评论 id 名
    private String id = null;
    //目标帖子的 使用者
    private String user = null;

    //内容 
    private String content = null;

    //时间
    private Date date = null;
     */
 /*
        下面几乎是扩展的信息
        
        点赞数子类的
     */

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
