package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器类
@Controller //把该类交给ioc容器进行管理
@RequestMapping(path="/user")
public class HelloController {

    /**
     * @RequestMapping：用于建立请求URL和处理请求方法之间的对应关系，该注解也可用于类上，便于分模块开发
     *    属性：
     *        value:等同于path：如果只有一个value和path属性，则可以省略不写
     *        method：用于指定请求的方式；
     *        params:用于指定限制请求参数的条件。它支持简单的表达式。要求请求参数的key和value必须和配置的一模一样，
     *               例如：params = {"accountName}，表示请求参数必须有accountName
     *                    params = {"money!100"}，表示请求参数中money不能是100；
     *        headers:用于指定限制请求消息头的条件。
     *    注意：以上四个属性只要出现多个的时候，之间是与的关系
     * @return
     */
    @RequestMapping(path="/hello") //将请求映射到该方法上
    public String sayHello() {
        System.out.println("Hello springMVC");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(path="/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("测试RequestMapping注解。。。");
        return "success";
    }
}
