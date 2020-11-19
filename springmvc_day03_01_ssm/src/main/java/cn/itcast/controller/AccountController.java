package cn.itcast.controller;

import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * spring整合springmvc：启动Tomcat时，需要加载spring的配置文件
     *   服务器启动的时候创建ServletContext对象，服务器关闭时销毁，监听器监听ServletContext域对象创建和销毁的，
     *   用监听器去加载Spring的配置文件，创建WEB版本工厂，存储ServletContext对象
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll() {
        System.out.println("controller:findAll...");
        // 调用service方法
        accountService.findAll();
        return "list";
    }
}
