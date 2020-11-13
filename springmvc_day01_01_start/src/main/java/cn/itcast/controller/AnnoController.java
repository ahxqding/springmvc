package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"msg"}) //等于把msg=美美存入到session域对象中
public class AnnoController {

    /**
     * @RequestParam：当请求参数和方法参数名不一致时使用
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="name") String username){
        System.out.println("testRequestParam执行了。。。" + username);
        return "success";
    }

    /**
     * @RequestBody:用于获取请求体的内容，直接使用得到是key=value&key=value...结构的数据（get请求不适用）
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("testRequestBody执行了。。。" + body);
        return "success";
    }

    /**
     * @PathVaribale:用于绑定URL中的占位符，例如请求URL中/delete/{id},这个{id}就是url占位符
     * @param
     * @return
     */
    @RequestMapping("/testPathVaribale/{sid}")
    public String testPathVaribale(@PathVariable(name="sid") String id){
        System.out.println("testPathVaribale执行了。。。" +id);
        return "success";
    }

    /**
     * HiddentHttpMethodFilter注解：由于浏览器form表单只支持GET与POST请求，而DELETE、PUT等method并不支持，Spring3.0添加
     * 了一个过滤器，可以将浏览器请求改为指定的请求方式，发送给我们的控制器方法，使得支持GET、POST、PUT与DELETE请求；
     * 使用方法：1.在web.xml中配置该过滤器；
     *         2.请求方式必须使用POST请求；
     *         3.按照要求提供method请求参数，该参数的取值就是我们需要的请求方式；
     */


    /**
     * @RequestHeader:获取请求头信息
     * @param header
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept") String header){
        System.out.println("testRequestHeader执行了。。。" + header);
        return "success";
    }

    /**
     * @CookieValue:用于把指定cookie名称的值传入控制器方法参数
     * @param cookie
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value="JSESSIONID") String cookie){
        System.out.println("testCookieValue执行了。。。" + cookie);
        return "success";
    }

    /**
     * @ModelAttribute:该注解是SpringMVC4.3版本以后新加入的。他可以用于修饰方法和参数；
     * 出现在方法上：表示当前方法会在控制器的方法之前执行，他可以修饰没有返回值的方法，也可以修饰有具体返回值的方法；
     * 出现在参数上：获取指定的数据给参数赋值
     * 属性：value用于获取数据的key,key可以是POJO的属性名称，也可以是map结构的key
     * 应用场景：当表单提交数据不是完整的实体数据时，保证没有提交数据的字段使用数据库对象原来的数据。
     *         例如：我们在编辑一个用户时，用户有一个创建信息字段，该字段的值是不允许修改的。在提交表单数据是肯定没有此字段的内容，一旦更新会把该字段内容置为null，
     *         此时就可以使用此注解解决问题。
     * @param
     * @return
     */
    /*@RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value="JSESSIONID") String model){
        System.out.println("testModelAttribute执行了。。。" + model);
        return "success";
    }*/

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user){
        System.out.println("testModelAttribute执行了。。。" + user);
        return "success";
    }

    /**
     * 该方法会先执行
     */
/*    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了。。。");
        //通过用户名查数据
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了。。。");
        //通过用户名查数据
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("user",user);
    }

    /**
     * @SessionAttributes:用于多次执行控制器方法间的参数共享,只能作用在类上
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes执行了。。。" );
        //底层会存储到request域对象中
        model.addAttribute("msg","美美");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes执行了。。。" );
        String msg = (String)modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/removeSessionAttributes")
    public String removeSessionAttributes(SessionStatus sessionStatus){
        System.out.println("getSessionAttributes执行了。。。" );
        sessionStatus.setComplete();
        return "success";
    }

}
