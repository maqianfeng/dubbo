package com.mqf.provider;

import com.mqf.provider.server.AppProviderApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(/*locations = {"classpath:provider.xml"}*/)
public class ProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvideApplication.class, args);
//        AppProviderApi.invoke();
        //自己启动的话使用以下方法：
//        //加载xml配置文件启动
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/provider.xml");
//        context.start();
//        System.in.read(); // 按任意键退出


    }

}
