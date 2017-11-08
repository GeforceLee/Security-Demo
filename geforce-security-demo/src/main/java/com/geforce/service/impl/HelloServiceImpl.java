package com.geforce.service.impl;

import com.geforce.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author geforce
 * @date 2017/11/8
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello" + name;
    }
}
