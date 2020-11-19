package cn.itcast.controller;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    public String findAll(Model model) {
        System.out.println("controller:findAll...");
        // 调用service方法
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("controller:save...");
        // 调用service方法
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return;
    }
}
