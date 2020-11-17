package cn.itcast.test;

import cn.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

     @Test
    public void run1() {
         // 加载sping的配置文件
         ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
         // 获取对象
         AccountService accountService = (AccountService) app.getBean("accountService");
         // 调用方法
         accountService.findAll();

     }
}
