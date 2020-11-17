package cn.itcast.controller;

import cn.itcast.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * springmvc异常处理：
     *     1.编写自定义异常类（做提示信息的）
     *     2.编写异常处理器
     *     3.配置异常处理器（跳转到提示页面）
     * @return
     * @throws Exception
     */
    @RequestMapping("/testException")
    public String testException() throws Exception {
        System.out.println("testException。。。");
        //模拟异常

        try {
            int a = 10/0;
        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
            // 抛出自定义异常
            throw new SystemException("查询所有用户出现错误了");
        }
        return "success";
    }
    /**
     * 拦截器和过滤器：
     *    过滤器是servlet规范中的一部分，任何Java web工程都可以使用；
     *    拦截器是springmvc框架自己的，只有使用了springmvc框架的工程才能用；
     *    过滤器在url-pattern中配置了/*之后，可以对所有访问的资源拦截；
     *    拦截器只会拦截访问的控制器方法，如果访问的是jsp、html、css、image或者js是不会进行拦截的；
     *    拦截器也是AOP思想的具体应用；
     *    我们想要自定义拦截器，要求必须实现：handlerInterceptor接口。
     */

}