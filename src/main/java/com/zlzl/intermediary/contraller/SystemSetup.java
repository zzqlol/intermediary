package com.zlzl.intermediary.contraller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zlzl.intermediary.entity.Customer;
import com.zlzl.intermediary.entity.Staff;
import com.zlzl.intermediary.repository.CustomerRepository;
import com.zlzl.intermediary.repository.HouseBasicsRepository;
import com.zlzl.intermediary.repository.RegionRepository;
import com.zlzl.intermediary.repository.StaffRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 对于系统设置子页面的所有请求都进入这个页面
 * 系统设置请求都以system开头
 * 所属页面放在system下
 */
@Controller
@RequestMapping("system")
public class SystemSetup {
    @Resource
    private StaffRepository staffRepository;
    @RequestMapping("all.do")
    public String go(Model map){
        int page=0;
        int page1 = page+1;
        int pagesize = 5;
        Sort sort = new Sort(Sort.Direction.DESC,"uid");
        Pageable pageable = PageRequest.of(page,pagesize,sort);
        Page<Map<String, Object>> maps = staffRepository.selectAll(pageable);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> maaaap :maps
        ) {
            list.add(maaaap);
            System.out.println(maaaap);
        }
        long size = staffRepository.count();
        int pages = 0;
        if (size%5==0){
            pages = (int) (size/5);
        }else{
            long sizes = size-(size%5);
            pages =(int) ((sizes/5)+1);
        }

        map.addAttribute("list",list);
        map.addAttribute("size",size);
        map.addAttribute("pages",pages);
        map.addAttribute("page",page1);
        return "system/main";
    }
    @ResponseBody
    @RequestMapping("deletestaff.do")
    public int deletestaff(Model map,String uuid){
        int uid = Integer.parseInt(uuid.substring(1));
        int num = staffRepository.deleteByUid(uid);
        return num;
    }
    @RequestMapping("toaddstaff.do")
    public String toaddstaff(){
        return "system/addstaff";
    }
    @ResponseBody
    @RequestMapping("addstaff.do")
    public int addstaff(Model map, String uname, String sex, String telephone, String time, String deptno)
    {
        String newtime = "";
        Staff staff = new Staff();
        String[] times = time.split("-");
        for (int i=0;i<times.length;i++){

            newtime = newtime+times[i];
        }
        int deptno1 = Integer.parseInt(deptno);
        staff.setDid(deptno1);
        staff.setSex(sex);
        staff.setStaffDate(newtime);
        staff.setTelephone(telephone);
        staff.setUname(uname);
        Staff save = staffRepository.save(staff);
        int num =1;
        if ("".equals(save)||"null".equals(save)){
            num=0;
        }
        return num;
    }

    @RequestMapping("toupdatestaff.do")
    public String  toupdatestaff(Model map,String uuid){
        int uid = Integer.parseInt(uuid.substring(1));
        List<Map<String,Object>> list= staffRepository.selectAllByUid(uid);
        map.addAttribute("list",list);
        return "system/updatestaff";
    }
    @ResponseBody
    @RequestMapping("updatestaff.do")
    public int updatestaff(Model map,String uuid,String uname,String sex,String telephone,String deptno,String time){
        int uid = Integer.parseInt(uuid);
        int did = Integer.parseInt(deptno);
        System.out.println(uid);
        String newtime = "";
        String[] times = time.split("-");
        for (int i=0;i<times.length;i++){
            newtime = newtime+times[i];
        }
        int num = staffRepository.updateByThose(uname,sex,telephone,did,newtime,uid);
        System.out.println(num);
        return num;
    }
}
