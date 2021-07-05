package com.mqf.consumer;

import com.mqf.consumer.server.ConsumerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConsumerApplication.class)
public class ConsumerServiceTest {

    @Resource
    private ConsumerService consumerService;
    @Test
    public void test1() {
        consumerService.test1();
    }
}