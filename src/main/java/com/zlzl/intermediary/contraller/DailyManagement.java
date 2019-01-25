package com.zlzl.intermediary.contraller;

import com.zlzl.intermediary.entity.*;
import com.zlzl.intermediary.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

/**
 * 对于日常管理子页面的所有请求都进入这个页面
 * 日常管理请求都以daily开头
 * 所属页面放在daily下
 */
@Controller
public class DailyManagement {
    @Resource
    private RegionRepository regionRepository;
    @Resource
    private StaffRepository staffRepository;
    @Resource
    private HouseBasicsRepository houseBasicsRepository;
    @Resource
    private HousePhotoRepository housePhotoRepository;
    @Resource
    private HistoryRepository historyRepository;
    @RequestMapping("dailytest")
    public String test(Model map){
         int page=0;
         int pageSize=6;
        List<Region> list=regionRepository.findAll();
        //  下拉框获取区域
        map.addAttribute("list",list);

        Sort sort=new Sort(Sort.Direction.DESC,"hbId");
        Pageable pageable= PageRequest.of(page,pageSize,sort);
        //所有的房源信息
        List<HouseBasics> Alldate=houseBasicsRepository.findAll();
        //获取所有房源信息分页
        Page<Map<String,Object>> pages=houseBasicsRepository.selectAll(pageable);
        List<Map<String,Object>> num=new LinkedList<>();
        //绑定一个空对象

        for (Map<String,Object> pages1:pages)
        {
            String[] phopoadd=housePhotoRepository.selectphotoAdd((Integer)(pages1.get("hdId")));
            pages1.put("photo",phopoadd[0]);
            num.add(pages1);
        }
        List<Map<String,Object>> info=houseBasicsRepository.selectAll1((Integer)(num.get(0).get("hdId")));
        int length=Alldate.size();
        int pageindex=page+1;
        if (length%6==0){
            int pagesum=length/6;
        }
        int pagesum=length/6+1;
        //数据长度,当前页，总页数
        int flag=1;//默认为出租
        if ((Integer) (info.get(0).get("rentalPrice"))==0){
            flag=0;//房屋为出售
        }
        map.addAttribute("flag",flag);
        map.addAttribute("length",length);
        map.addAttribute("pageindex",pageindex);
        map.addAttribute("pagesum",pagesum);
        map.addAttribute("pagelist",num);
        map.addAttribute("info",info);
        return "dailymanage";
    }
    //分页
    @RequestMapping("dailytest1")
    public String turnpage(String page,Model map){
        List<Region> list=regionRepository.findAll();
        //  下拉框获取区域
        map.addAttribute("list",list);

        Sort sort=new Sort(Sort.Direction.DESC,"hbId");
        Pageable pageable= PageRequest.of(Integer.parseInt(page)-1,6,sort);
        //所有的房源信息
        List<HouseBasics> Alldate=houseBasicsRepository.findAll();
        //获取所有房源信息分页
        Page<Map<String,Object>> pages=houseBasicsRepository.selectAll(pageable);/*所有基础信息*/
        List<Map<String,Object>> num=new LinkedList<>();
        for (Map<String,Object> pages1:pages)/*遍历，为每个信息添加图片*/
        {
            String[] phopoadd=housePhotoRepository.selectphotoAdd((Integer)(pages1.get("hdId")));/*图片信息*/
            pages1.put("photo",phopoadd[0]);
            num.add(pages1);
        }
        int length=Alldate.size();
        int pageindex=Integer.parseInt(page);
        if (length%6==0){
            int pagesum=length/6;
        }
        int pagesum=length/6+1;

        //数据长度,当前页，总页数
        map.addAttribute("length",length);
        map.addAttribute("pageindex",pageindex);
        map.addAttribute("pagesum",pagesum);
        map.addAttribute("pagelist",num);
        return "dailymanage::ui_content";
    }
//    显示右侧表格信息
    @RequestMapping("dailyshowinfo")
    public String showtableinfo(int hbid,Model map){
        //通过ID获取详细数据
        List<Map<String,Object>> info=houseBasicsRepository.selectAll1(hbid);
        int flag=1;//默认为出租
        if ((Integer) (info.get(0).get("rentalPrice"))==0){
           flag=0;//房屋为出售
        }
        map.addAttribute("flag",flag);
        map.addAttribute("info",info);
        return "dailymanage::table_info";
    }
    @RequestMapping("dailyquery")
    public String test1(String page,String state,int rid,String structure,int rentalPricelow,int rentalPricehigh,Model map){
        System.out.println("page+state+rid+structure = " + page+state+rid+structure+rentalPricelow+rentalPricehigh);
        List<Region> list=regionRepository.findAll();
        //  下拉框获取区域
        map.addAttribute("list",list);

        Sort sort=new Sort(Sort.Direction.DESC,"hbId");
        Pageable pageable= PageRequest.of(Integer.parseInt(page)-1,6,sort);
        //获取查询到的所有信息
        List<Map<String,Object>> Alldate=houseBasicsRepository.selectAllBy1("%"+state+"%",rid,"%"+structure+"%",rentalPricelow,rentalPricehigh);
        //获取所有房源信息分页
        Page<Map<String,Object>> pages=houseBasicsRepository.selectAllBy(pageable,"%"+state+"%",rid,"%"+structure+"%",rentalPricelow,rentalPricehigh);/*所有基础信息*/
        System.out.println(Alldate.size());
        List<Map<String,Object>> num=new LinkedList<>();
            for (Map<String, Object> pages1 : pages)/*遍历，为每个信息添加图片*/ {
                String[] phopoadd = housePhotoRepository.selectphotoAdd((Integer) (pages1.get("hdId")));/*图片信息*/
                pages1.put("photo", phopoadd[0]);
                num.add(pages1);
            }
            int length = Alldate.size();
            int pageindex = Integer.parseInt(page);
            if (length % 6 == 0) {
                int pagesum = length / 6;
            }
            int pagesum = length / 6 + 1;

            //数据长度,当前页，总页数
            map.addAttribute("length", length);
            map.addAttribute("pageindex", pageindex);
            map.addAttribute("pagesum", pagesum);
            map.addAttribute("pagelist", num);
            return "dailymanage::ui_content";

    }
    @RequestMapping("dailyindex")
    public String toindex(){
        return "index";
    }
//    获取图片详细信息
    @RequestMapping("dailypicshow")
    public String topicshow(int hdId,Model map){
        String[] phopoadd=housePhotoRepository.selectphotoAdd((Integer)hdId);
        map.addAttribute("picshow",phopoadd);
        return "picshow";
    }
    @RequestMapping("dailygjsearch")
        public String togjsearch(ModelMap map){
        List<Region> list=regionRepository.findAll();
        //  下拉框获取区域
        map.addAttribute("list",list);
        return "gjsearch";
    }
//    点击确认，进入填写客户信息
    @RequestMapping("dailytransaction")
    public String totransaction(int hdId,ModelMap map){
        List<Staff> list= staffRepository.findAll();
        //  下拉框获取区域
        map.addAttribute("list",list);
        System.out.println(hdId);
        HouseBasics houseBasics=houseBasicsRepository.findByHbId(hdId);
        map.addAttribute("house",houseBasics);
        return "transaction";
    }
    @ResponseBody
    @RequestMapping("dailyinserthistory")
    public boolean insert(History history,String year,String month){
        if (year==null&&month==null){
            String []time=history.getNowDate().split("-");
            history.setNowDate(time[0]+time[1]+time[2]);
            History history1=historyRepository.save(history);
            if (history1!=null){
                houseBasicsRepository.updateStateByBbid1(history.getHbId());
                return true;
            }

        }else{
            String date=year+"年"+month+"月";
            history.setLeaseDate(date);
            String []time=history.getNowDate().split("-");
            history.setNowDate(time[0]+time[1]+time[2]);
            History history1=historyRepository.save(history);
            if (history1!=null){
                houseBasicsRepository.updateStateByBbid(history.getHbId());
                return true;
            }
        }
        return false;
    }
    @RequestMapping("dailytotest")
    public String totest(ModelMap map){
        List<Region> list=regionRepository.findAll();
        //  下拉框获取区域
        map.addAttribute("list",list);
        return "test";
    }
}
