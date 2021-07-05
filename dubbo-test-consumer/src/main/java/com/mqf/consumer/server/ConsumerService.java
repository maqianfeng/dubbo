package com.mqf.consumer.server;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mqf.provider.server.ProviderService;
import org.springframework.stereotype.Component;

/**
 * 注解方式的service
 * 如果这里找不到 ProviderService 类，请在服务端先把服务端工程用 Maven intall 一下
 * 服务端的依赖需要放到消费端的 pom 中
 */
@Component("consumerService")
//@Service
public class ConsumerService {
    //    @Resource
    //使用 dubbo 的注解
    @Reference
    private ProviderService providerServiceDD;

    public void test1() {
        String hello = providerServiceDD.SayHello("哈哈哈");
        System.err.println(hello);
    }


    public static void main(String[] args) {
         int i=4%7;
         int u=i/3;
        System.out.println(i);
        System.out.println(u);
    }
}
