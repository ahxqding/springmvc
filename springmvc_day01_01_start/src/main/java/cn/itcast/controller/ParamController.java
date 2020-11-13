package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数的绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping("/testParam")
    public String testParam(String username, String password){
        System.out.println("testParam执行了。。。" + username + "," + password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("saveAccount。。。" + account);
        return "success";
    }

    /**
     * 自定义类型转换器
     *    1.定义一个类（StringToDateConverter），实现Converter接口，该接口有两个泛型（S表示接受的类型，T表示目标类型）
     *    2.在配置文件中配置自定义类型转换器,并且在<mvc:annotation-driven conversion-service="conversionService"/>开启服务
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("saveUser。。。" + user);
        return "success";
    }

    /**
     * Servlet API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("testServlet执行了。。。");
        System.out.println(request);

        System.out.println(response);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        return "success";
    }

}
