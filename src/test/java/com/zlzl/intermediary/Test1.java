package com.zlzl.intermediary;

import com.zlzl.intermediary.entity.HouseBasics;
import com.zlzl.intermediary.repository.AdministratorsRepository;
import com.zlzl.intermediary.repository.HouseBasicsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
    @Resource
    private HouseBasicsRepository houseBasicsRepository;
    @Test
    public void test(){
        int page=0;
        int pageSize=5;
        Sort sort=new Sort(Sort.Direction.DESC,"registerDate");
        Pageable pageable= PageRequest.of(page,pageSize,sort);
        String time="";
        Page<Map<String,Object>> page1=houseBasicsRepository.selectAllhouse("%%","%正常状态%","20170911",pageable);
        List<Map<String,Object>> list=new LinkedList<Map<String, Object>>();
        for (Map<String,Object> k:page1
             ) {
            list.add(k);
            System.out.println(k);
        }
        System.out.println(list);
//        System.out.println(houseBasicsRepository.findAll(pageable));
    }
}
