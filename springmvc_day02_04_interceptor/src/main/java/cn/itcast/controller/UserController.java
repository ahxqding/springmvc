package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 拦截器和过滤器：
     *    过滤器是servlet规范中的一部分，任何Java web工程都可以使用；
     *    拦截器是springmvc框架自己的，只有使用了springmvc框架的工程才能用；
     *    过滤器在url-pattern中配置了/*之后，可以对所有访问的资源拦截；
     *    拦截器只会拦截访问的控制器方法，如果访问的是jsp、html、css、image或者js是不会进行拦截的；
     *    拦截器也是AOP思想的具体应用；
     *    我们想要自定义拦截器，要求必须实现：handlerInterceptor接口。
     *
     *    编写拦截器的步骤：
     *       1.编写拦截器类，实现HandlerInterceptor接口；
     *       2.配置拦截器
     */
    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("testInterceptor。。。");

        return "success";
    }


}
