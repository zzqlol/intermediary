package com.zlzl.intermediary;

import com.zlzl.intermediary.entity.HouseBasics;
import com.zlzl.intermediary.repository.AdministratorsRepository;
import com.zlzl.intermediary.repository.HouseBasicsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {
    @Resource
    private AdministratorsRepository administratorsRepository;
    @Resource
    private HouseBasicsRepository houseBasicsRepository;
    @Test
    public void test(){
        int page=0;
        int pageSize=10;
        Sort sort=new Sort(Sort.Direction.DESC,"hbId");
        Pageable pageable= PageRequest.of(page,pageSize,sort);
        Page<Map<String,Object>> pages=houseBasicsRepository.selectAll(pageable);
        Iterator<Map<String,Object>> lists=pages.iterator();
        while (lists.hasNext()){
            System.out.println(lists.next());

        }
//        System.out.println(administratorsRepository.findAll());
//        System.out.println(houseBasicsRepository.selectAll());
    }
}
