package com.zlzl.intermediary.contraller;

import com.zlzl.intermediary.entity.Staff;
import com.zlzl.intermediary.repository.HistoryRepository;
import com.zlzl.intermediary.repository.StaffRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 对于统计报表子页面的所有请求都进入这个页面
 * 统计报表请求都以statist开头
 * 所属页面放在statist下
 */
@Controller
@RequestMapping("statist")
public class StatisticalReport {
    @Resource
   private StaffRepository staffRepository;
    @Resource
    private HistoryRepository historyRepository;
    @RequestMapping("profitFromMonth")
    public String profitFromMonth(){
        return "statistical/profitFromMonth";
    }
    @ResponseBody
    @RequestMapping("delete.do")
    public Object profitFromMonth(String time){
        if(time==null)
            time="2018";
        List<Staff> staff=staffRepository.findAll();
        List<Object> list=new ArrayList<>();
        Map<String,int[]> map=new HashMap<>();
        list.add(staff);

        for (Staff s:staff
        ) {
            int[] date=new int[12];
            date[0]=historyRepository.findbysatff(time+"0101",time+"0131",s.getUid());
            date[1]=historyRepository.findbysatff(time+"0201",time+"0228",s.getUid());
            date[2]=historyRepository.findbysatff(time+"0301",time+"0331",s.getUid());
            date[3]=historyRepository.findbysatff(time+"0401",time+"0430",s.getUid());
            date[4]=historyRepository.findbysatff(time+"0501",time+"0531",s.getUid());
            date[5]=historyRepository.findbysatff(time+"0601",time+"0630",s.getUid());
            date[6]=historyRepository.findbysatff(time+"0701",time+"0731",s.getUid());
            date[7]=historyRepository.findbysatff(time+"0801",time+"0831",s.getUid());
            date[8]=historyRepository.findbysatff(time+"0901",time+"0930",s.getUid());
            date[9]=historyRepository.findbysatff(time+"1001",time+"1031",s.getUid());
            date[10]=historyRepository.findbysatff(time+"1101",time+"1130",s.getUid());
            date[11]=historyRepository.findbysatff(time+"1201",time+"1231",s.getUid());
            map.put(s.getUname(),date);
        }
            list.add(map);
        return list;
    }

    @RequestMapping("tradeFromMonth")
    public String tradeFromMonth(){
        return "statistical/tradeFromMonth";
    }
    @ResponseBody
    @RequestMapping("update.do")
    public Object tradeFromMonth(String time){
        if(time==null)
            time="2018";
        List<Staff> staff=staffRepository.findAll();
        List<Object> list=new ArrayList<>();
        Map<String,double[]> map=new HashMap<>();
        list.add(staff);

        for (Staff s:staff
        ) {
            double[] date=new double[12];
            date[0]=historyRepository.findbyprice(time+"0101",time+"0131",s.getUid());
            date[1]=historyRepository.findbyprice(time+"0201",time+"0228",s.getUid());
            date[2]=historyRepository.findbyprice(time+"0301",time+"0331",s.getUid());
            date[3]=historyRepository.findbyprice(time+"0401",time+"0430",s.getUid());
            date[4]=historyRepository.findbyprice(time+"0501",time+"0531",s.getUid());
            date[5]=historyRepository.findbyprice(time+"0601",time+"0630",s.getUid());
            date[6]=historyRepository.findbyprice(time+"0701",time+"0731",s.getUid());
            date[7]=historyRepository.findbyprice(time+"0801",time+"0831",s.getUid());
            date[8]=historyRepository.findbyprice(time+"0901",time+"0930",s.getUid());
            date[9]=historyRepository.findbyprice(time+"1001",time+"1031",s.getUid());
            date[10]=historyRepository.findbyprice(time+"1101",time+"1130",s.getUid());
            date[11]=historyRepository.findbyprice(time+"1201",time+"1231",s.getUid());
            map.put(s.getUname(),date);
        }
        list.add(map);
        return list;
    }
}
