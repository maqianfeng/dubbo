package com.mqf.consumer;

import com.mqf.consumer.server.AppCustomerApi;
import com.mqf.provider.server.AppProviderApi;
import com.mqf.provider.server.ProviderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = {"com.mqf"})
//@ImportResource(locations = {"classpath:consumer.xml"})
public class ConsumerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class, args);
        ProviderService providerService = (ProviderService) context.getBean("providerServiceDD");
        String hello = providerService.SayHello("哈哈哈");
        System.err.println(hello);

//        AppCustomerApi.invoke();
//另一种启动方式：
//        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
//        context.start();
//        ProviderService providerService = (ProviderService) context.getBean("providerService");
//        String str = providerService.SayHello("hello");
//        System.out.println(str);
//        System.in.read();

    }

}
