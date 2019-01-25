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
 * 对于客户管理子页面的所有请求都进入这个页面
 * 客户管理请求都以customer开头
 * 所属页面放在custimer包下
 */
@Controller
@RequestMapping("customer")
public class CustomerManagement {
    @Resource
    private CustomerRepository customerRepository;
    @Resource
    private RegionRepository regionRepository;
    @Resource
    private StaffRepository staffRepository;
    @Resource
    private HouseBasicsRepository houseBasicsRepository;

    @RequestMapping("all.do")
    public String go(Model map){
        int page=0;
        int page1 = page+1;
        int pagesize = 5;
        Sort sort = new Sort(Sort.Direction.DESC,"cid");
        Pageable pageable = PageRequest.of(page,pagesize,sort);
        Page<Map<String, Object>> maps = customerRepository.selectAll("%%", pageable);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> maaaap :maps
             ) {
            list.add(maaaap);
        }
        long size = customerRepository.count();
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
        return "custimer/test";
    }
    @RequestMapping("condition.do")
    public String show(Model map,String uname,String sell,String lease,String time,String days,String pages){
       if ("".equals(days)||"null".equals(days)){
           days="1000";
       }
        long size =0;
        int page = 0;
        int pagesize = 5;
        Sort sort = new Sort(Sort.Direction.DESC,"cid");
        if (uname == "" || uname == null) {
            uname = "%%";
        }else{
            uname = "%"+uname+"%";
        }
        List<Map<String, Object>> list=new ArrayList<>();
        if ("false".equals(time)) {
            if ("true".equals(sell)) {
                page = 0;
                Pageable pageable = PageRequest.of(page, pagesize, sort);
                Page<Map<String, Object>> maps = customerRepository.selectAllByBuy_price(uname, pageable);
                for (Map<String, Object> maaaap : maps
                ) {
                    list.add(maaaap);
                }
            } else if ("true".equals(lease)) {
                page = 0;
                Pageable pageable = PageRequest.of(page, pagesize, sort);
                Page<Map<String, Object>> maps = customerRepository.selectAllBySeek_price(uname, pageable);
                for (Map<String, Object> maaaap : maps
                ) {
                    list.add(maaaap);
                }
                System.out.println(list);
            } else {
                if (uname != "%%" ) {
                    page = 0;
                    System.out.println(page);
                    Pageable pageable = PageRequest.of(page, pagesize, sort);
                    Page<Map<String, Object>> maps = customerRepository.selectAll(uname, pageable);
                    for (Map<String, Object> maaaap : maps
                    ) {
                        list.add(maaaap);
                    }
                } else {
                    page = Integer.parseInt(pages) - 1;
                    Pageable pageable = PageRequest.of(page, pagesize, sort);
                    Page<Map<String, Object>> maps = customerRepository.selectAll(uname, pageable);
                    for (Map<String, Object> maaaap : maps
                    ) {
                        list.add(maaaap);
                    }
                }
            }
        }
         else if("true".equals(time)){
            page=0;
            Pageable pageable = PageRequest.of(page,pagesize,sort);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR,-Integer.parseInt(days));
            Date time1 = calendar.getTime();
            String gettime = new SimpleDateFormat("yyyyMMdd").format(time1);
            if ("true".equals(sell)) {
                Page<Map<String, Object>> maps = customerRepository.selectAllByBuy_priceAndTime(uname,gettime,pageable);
                for (Map<String, Object> maaaap :maps
                ) {
                    list.add(maaaap);
                }
            } else if ("true".equals(lease)) {
                Page<Map<String, Object>> maps =customerRepository.selectAllBySeek_priceAndTime(uname,gettime,pageable);
                for (Map<String, Object> maaaap :maps
                ) {
                    list.add(maaaap);
                }
            }
            else {
                Page<Map<String, Object>> maps = customerRepository.selectAllBytime(uname,gettime,pageable);
                for (Map<String, Object> maaaap :maps
                ) {
                    list.add(maaaap);
                }
            }
        }
        size = customerRepository.count();
        int pagess = 0;
        if (size%5==0){
            pagess = (int) (size/5);
        }else{
            long sizes = size-(size%5);
            pagess =(int) ((sizes/5)+1);
        }

        int page1 = page+1;
        map.addAttribute("list",list);
        map.addAttribute("size",size);
        map.addAttribute("pages",pagess);
        map.addAttribute("page",page1);
        return "custimer/test::div1";
    }
    @RequestMapping("onetomore.do")
    public String oneToMore(Model map,String cid){
        int ccid = Integer.parseInt(cid.substring(1));
        List<Map<String, Object>> list=customerRepository.selectAllByUid(ccid);
        map.addAttribute("list",list);
        return "custimer/test::more";
    }
    @ResponseBody
    @RequestMapping("recommend.do")
    public  List<Map<String, Object>> recommend(Model map,String rname,String rentalPrice,String sellPrice,String decoration){
        double sellPrice2 = 0;
        int rentalPrice2 = 0;
        System.out.println(sellPrice+"000");
        if (sellPrice!=""&&sellPrice!=null){
            String[] sellPrice1 = sellPrice.split("-");
             sellPrice2 = Integer.parseInt(sellPrice1[1]);
        }else{
             sellPrice2 = 0;
        }
        if (sellPrice!=""&&sellPrice!=null){
            String[] rentalPrice1 = rentalPrice.split("-");
            rentalPrice2 = Integer.parseInt(rentalPrice1[1]);
        }else{
            rentalPrice2 = 0;
        }
       if ("不限".equals(rname)){
           rname = "";
       }
        List<Map<String, Object>> list=houseBasicsRepository.selectAllByMOre(rname,rentalPrice2,sellPrice2,decoration);
       if (list.size()==0){
           Map<String, Object> mapp = new HashMap<>();
               mapp.put("hbId","空");
           mapp.put("owner","空");
           mapp.put("telephone","空");
           mapp.put("registerDate","空");
           mapp.put("state","空");
           mapp.put("area","空");
           mapp.put("rname","空");
           mapp.put("vname","空");
           mapp.put("structure","空");
           mapp.put("decoration","空");
           mapp.put("uname","空");
           mapp.put("infrastructure","空");
           mapp.put("facilities","空");
           mapp.put("specificAddress","空");
           list.add(mapp);
       }
        return list;
    }


    @RequestMapping("addCust.do")
    public String addCust(){
        return "custimer/addCust";
    }

    @RequestMapping("showstaff.do")
    public String showstaff(Model map){
        List<Staff> list = staffRepository.findAll();
        map.addAttribute("list",list);
        return "custimer/staff";
    }
    @RequestMapping("getuname.do")
    public String getuname(String uid,Model map){
            uid = uid.substring(1);
            map.addAttribute("uname",uid);
            return "custimer/addCust::div1";
    }

    @RequestMapping("insertCust.do")
    public String insertCust(String telephone,String state,String uname,String purpose,String decoration,String rname,String structure,String arealow,String areabig,String infrastructure,String facilities,String cname,String leaselow,String selllow,String leasebig,String sellbig,String sell,String lease)
    {
        Customer customer = new Customer();
       int uid = staffRepository.findAllByUname(uname);
       customer.setUid(uid);
       String area = arealow+"-"+areabig;
       customer.setArea(area);
       customer.setCusState(state);
       customer.setPurpose(purpose);
       customer.setDecoration(decoration);
       int rid = regionRepository.findByRnamejie(rname);
       customer.setRid(rid);
       customer.setStructure(structure);
       customer.setInfrastructure(infrastructure);
       customer.setFacilities(facilities);
       customer.setCname(cname);
        if ("true".equals(sell)){
            String sellPrice = selllow+"-"+selllow;
            System.out.println(sellPrice);
            customer.setBuyPrice(sellPrice);
        }else{
            String sellPrice =null;
            customer.setBuyPrice(sellPrice);
        }
        if ("true".equals(lease)){
            String leasePrice = leaselow+"-"+leaselow;
            System.out.println(leasePrice);
            customer.setSeekPrice(leasePrice);
        }else{
            String leasePrice =null;
            customer.setSeekPrice(leasePrice);
        }
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        String gettime = new SimpleDateFormat("yyyyMMdd").format(time);
        customer.setInputDate(gettime);
        customer.setMobilePhone(telephone);
        customerRepository.save(customer);
        return "custimer/addCust";
    }
    @RequestMapping("frush.do")
    public String frush(Model map){
        int page = 0;
        int page1 = page+1;
        int pagesize = 5;
        Sort sort = new Sort(Sort.Direction.DESC,"cid");
        Pageable pageable = PageRequest.of(page,pagesize,sort);
        Page<Map<String, Object>> maps = customerRepository.selectAll("%%", pageable);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Map<String, Object> maaaap :maps
        ) {
            list.add(maaaap);
        }
        long size = customerRepository.count();
        int pages = (int) (size/5);
        map.addAttribute("list",list);
        map.addAttribute("size",size);
        map.addAttribute("pages",pages);
        map.addAttribute("page",page1);
        return "custimer/test::div1";
    }

    @RequestMapping("updatecust.do")
    public String updatecust(String cid,Model map){
        cid = cid.substring(1);
        int cidd = Integer.parseInt(cid);
        List<Map<String, Object>> list=customerRepository.selectAllByUid(cidd);
        System.out.println(list);
        map.addAttribute("list",list);
        return "custimer/updateCust";
    }
    @RequestMapping("updatetoCust.do")
    public String updatetoCust(String cname,String seekPrice,String buyPrice,String buyExplain,String seekExplain,String state,String uname,String purpose,String decoration,String rname,String structure,String area,String infrastructure,String facilities,String telephone,int cid){
       int uid = staffRepository.findAllByUname(uname);
       int rid = regionRepository.findByRnamejie(rname);
       int num = customerRepository.updateByCid(cname,seekPrice,buyPrice,seekExplain,buyExplain,state,uid,purpose,decoration,rid,structure,area,infrastructure,facilities,telephone,cid);
       return "custimer/test";
    }
    @RequestMapping("deletecust.do")
    public String deletecust(String cid,Model map){
        cid = cid.substring(1);
        int cidd = Integer.parseInt(cid);
        customerRepository.deleteByCid(cidd);
        return "custimer/test";
    }
    @RequestMapping("query.do")
    public String query(){
        return "custimer/query";
    }
    @RequestMapping("queryall.do")
    public String queryall(Model map,String telephone,String cid,String state,String purpose,String decoration,String rname,String structure,String cname)
    {
        String rid = null;
        if (telephone==""||telephone==null){
            telephone="%%";
        }
        if ("".equals(cid)&&"null".equals(cid)){
            cid="%%";
        }
        if ("".equals(cname)&&"null".equals(cname)){
            cname="%%";
        }
        if ("不限".equals(purpose)){
            purpose="%%";
        }
        if ("不限".equals(decoration)){
            decoration="%%";
        }
        if ("不限".equals(structure)){
            structure="%%";
        }if ("不限".equals(rname)){
            rid = "%%";
    }else{
        rid = String.valueOf(regionRepository.findByRname(rname));
    }
        List<Map<String, Object>> list= customerRepository.selectAllByThose(telephone,cid,state,purpose,decoration,rid,structure,cname);
        System.out.println(list);
        map.addAttribute("list",list);
        return "custimer/query::show";
    }
}
