package com.mqf.provider.server;


/**
 * xml方式服务提供者实现类
 * dubbo 暴露的 url
 * dubbo://192.168.234.1:20880/com.sihai.dubbo.provider.service.ProviderService?
 * anyhost=true
 * &application=provider
 * &bean.name=com.sihai.dubbo.provider.service.ProviderService
 * &bind.ip=192.168.234.1
 * &bind.port=20880
 * &dubbo=2.0.2
 * &generic=false
 * &interface=com.sihai.dubbo.provider.service.ProviderService
 * &methods=SayHello
 * &owner=sihai
 * &pid=8412
 * &qos.accept.foreign.ip=false
 * &qos.enable=true
 * &qos.port=55555
 * &side=provider
 * &timestamp=1562077289380
 */

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 注解方式实现类
 * 此处不是 spring 的注解，是dubbo 的注解
 */
@Service(timeout = 500000)
public class ProviderServiceImpl implements ProviderService {
    public String SayHello(String word) {
        return word;
    }
}
