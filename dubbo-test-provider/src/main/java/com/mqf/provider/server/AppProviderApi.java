package com.mqf.provider.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

/**
 * Api方式启动
 * api的方式调用不需要其他的配置（将 xml 的配置搬过来），只需要下面的代码即可。
 * 但是需要注意，官方建议：
 * Api方式用于测试用例使用，推荐xml的方式
 * <p>
 * 其他 API
 * org.apache.dubbo.config.ServiceConfig
 * org.apache.dubbo.config.ReferenceConfig
 * org.apache.dubbo.config.ProtocolConfig
 * org.apache.dubbo.config.RegistryConfig
 * org.apache.dubbo.config.MonitorConfig
 * org.apache.dubbo.config.ApplicationConfig
 * org.apache.dubbo.config.ModuleConfig
 * org.apache.dubbo.config.ProviderConfig
 * org.apache.dubbo.config.ConsumerConfig
 * org.apache.dubbo.config.MethodConfig
 * org.apache.dubbo.config.ArgumentConfig
 */
public class AppProviderApi {
    public static void invoke() {
        // 服务实现
        ProviderService providerService = new ProviderServiceImpl();
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("provider");
        application.setOwner("sihai");
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://localhost:2181");
        //        registry.setUsername("aaa");
//        registry.setPassword("bbb");
// 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);
        //protocol.setThreads(200);
// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
// 服务提供者暴露服务配置
        ServiceConfig<ProviderService> service = new ServiceConfig<>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(ProviderService.class);
        service.setRef(providerService);
        service.setVersion("1.0.0");
// 暴露及注册服务
        service.export();
    }
}
