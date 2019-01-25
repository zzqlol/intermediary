package com.zlzl.intermediary;

import com.zlzl.intermediary.repository.AdministratorsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
    @Resource
    private AdministratorsRepository administratorsRepository;
    @Test
    public void test(){
        System.out.println(administratorsRepository.findAll());
    }
}
