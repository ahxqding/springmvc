package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString...");
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(23);
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 返回值类型是void
     * 请求转发是一次请求，不需要写项目的名称
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid...");
        // 编写请求转发的程序
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        //直接进行相应
        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("hello");
        return;
    }

    /**
     * 返回值是modelAndView对象
     * modelAndView对象是Spring提供的一个对象，可以用来调整具体的SP视图
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView...");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(23);
        //把user存储到mv中，mv底层也会把user对象存入到request对象中
        mv.addObject("user",user);
        //跳转路径，会走xml文件中配置的视图解析器
        mv.setViewName("success");
        return mv;
    }

    /**
     * 关键字的方式进行请求转发和重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect...");
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向:重定向不能访问WEB-INF目录下的内容
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求和相应
     * @ResponseBody: 将响应的数据转成json格式
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        // 服务器端将body封装到实体类中，需要引入jackson相关的jar包
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user中
        System.out.println("testAjax..." + user);
        // 响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        return user;
    }
}
