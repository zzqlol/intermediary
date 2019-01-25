package com.zlzl.intermediary.contraller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zlzl.intermediary.Util.ReadExcelUtils;
import com.zlzl.intermediary.entity.HouseBasics;
import com.zlzl.intermediary.entity.Region;
import com.zlzl.intermediary.entity.Staff;
import com.zlzl.intermediary.entity.Village;
import com.zlzl.intermediary.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 对于房源管理子页面的所有请求都进入这个页面
 * 房源管理请求都以housing开头
 * 所属页面放在housing下
 */
@Controller
@RequestMapping("housing")
public class HousingManagement {
    //房屋查询
    @Resource
    private HouseBasicsRepository houseBasicsRepository;
    //员工查询
    @Resource
    private StaffRepository staffRepository;
    //地区查询
    @Resource
    private VillageRepository villageRepository;
    //区域查询
    @Resource
    private RegionRepository regionRepository;

    //客源查询
    @Resource
    private CustomerRepository customerRepository;
    //进入页面的请求
    @RequestMapping("start")
    public String test(Model model){
        //分页数据
        int page=0;
        int pageSize=5;
        Sort sort=new Sort(Sort.Direction.DESC,"registerDate");
        Pageable pageable= PageRequest.of(page,pageSize,sort);
        //分页及查询
        Page<Map<String,Object>> page1=houseBasicsRepository.selectAllhouse(pageable);
        //返回前台的数据
        Long pagesize=houseBasicsRepository.count();
        List<Map<String,Object>> list=new LinkedList<Map<String, Object>>();
        for (Map<String,Object> k:page1
        ) {
            list.add(k);
        }
        model.addAttribute("list",list);
        model.addAttribute("pagesize",pagesize);
        Long pagelength=pagesize/5;
        if(pagesize%5!=0){
            pagelength+=1;
        }
        model.addAttribute("pagelength",pagelength);
        model.addAttribute("pagenum",1);

        //模糊匹配客源
        String village=(String)list.get(0).get("rname");
        int area=(Integer)list.get(0).get("area");
        List<Map<String,Object>> customers=customerRepository.selectAllcustomer();
        List<Map<String,Object>> customer=new LinkedList<>();
        for (Map<String,Object> map:customers
             ) {
            if(map.get("cusState").equals("有效客户")||map.get("cusState").equals("潜在客户"))
            if(village.equals(map.get("rname"))){
                if(map.get("area").equals("不限")) {
                    customer.add(map);
                }
                else{
                    String areanum=(String)map.get("area");
                    String[] areaArray=areanum.split("-");
                    if(Integer.parseInt(areaArray[0])<=area&&area<=Integer.parseInt(areaArray[1])){
                        customer.add(map);
                    }
                }
            }
        }
        model.addAttribute("customer",customer);
        return "housing/house";
    }
    //分页及更新页面数据
    @RequestMapping(value = "pushdata.do")
    public String pushdata( String like,String sell,String lease,String state,String time,String timedata,String lose,String page,Model model) {
        //计算当前时间偏移x后的值
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-Integer.parseInt(timedata));
        Date date = calendar.getTime();
        //数据总量
        int pagesize =0;
        //分页
        int page1 = Integer.parseInt(page)-1;
        int pageSize = 5;
        Sort sort = new Sort(Sort.Direction.DESC, "registerDate");
        Pageable pageable = PageRequest.of(page1, pageSize, sort);
        if (like != "" && like != null) {
            like = "%" + like + "%";
        } else {
            like = "%%";
        }
        if ("true".equals(state)) {
            state = "%正常状态%";
        } else if ("true".equals(lose)) {
            state = "%失效%";
        } else {
            state = "%%";
        }
        if ("true".equals(time)) {
            timedata = new SimpleDateFormat("yyyyMMdd").format(date);
            System.out.println(timedata);
        } else {
            timedata = "0";
        }
        Page<Map<String, Object>> pagelist = null;
        if ("true".equals(sell)) {
            pagelist = houseBasicsRepository.selectAllhouseBySell(like, state, timedata, pageable);
             pagesize=houseBasicsRepository.selectAllhouseBySell(like, state, timedata);
        } else if ("true".equals(lease)) {
            pagelist = houseBasicsRepository.selectAllhouseByrental(like, state, timedata, pageable);
            pagesize=houseBasicsRepository.selectAllhouseByrental(like, state, timedata);
        } else {
            pagelist = houseBasicsRepository.selectAllhouse(like, state, timedata, pageable);
            pagesize=houseBasicsRepository.selectAllhouse(like, state, timedata);
        }

        List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
        for (Map<String, Object> k : pagelist
        ) {
            list.add(k);
        }
        //返回数据为空防止报错
        if(list.size()==0){
            Map<String,Object> map=new HashMap<String,Object>(){{
                put("hdId",1);put("area",0); put("rentalPrice","空"); put("owner","空");
                put("sellExplain","空"); put("specificAddress","空"); put("rname","空");
                put("uname","空"); put("purpose","空"); put("detailedAdd","空");
                put("sellPrice","空"); put("telephone","空"); put("rentalExplain","空"); put("structure","空");
                put("vname","空"); put("mobilePhone","空"); put("detailed","空");put("infrastructure","空");put("state","空");
                put("floor","空");put("facilities","空");put("decoration","空");put("floorHeight","空");put("registerDate","空");
            }};
            list.add(map);
        }
        model.addAttribute("list", list);
        model.addAttribute("pagesize", pagesize);
        int pagelength = pagesize / 5;
        if (pagesize % 5 != 0) {
            pagelength += 1;
        }
        model.addAttribute("pagelength", pagelength);
        model.addAttribute("pagenum", page);



        String village=(String)list.get(0).get("rname");
        int area=(Integer)list.get(0).get("area");
        List<Map<String,Object>> customers=customerRepository.selectAllcustomer();
        List<Map<String,Object>> customer=new LinkedList<>();
        for (Map<String,Object> map:customers
        ) {
            if(map.get("cusState").equals("有效客户")||map.get("cusState").equals("潜在客户"))
            if(village.equals(map.get("rname"))){
                if(map.get("area").equals("不限")) {
                    customer.add(map);
                }
                else{
                    String areanum=(String)map.get("area");
                    String[] areaArray=areanum.split("-");
                    if(Integer.parseInt(areaArray[0])<=area&&area<=Integer.parseInt(areaArray[1])){
                        customer.add(map);
                    }
                }
            }
        }
        model.addAttribute("customer",customer);

        return "housing/house::div1";
    }
    //更新下方数据
    @RequestMapping("updataId.do")
    public String updatePage(Model model,String num){
        int hdid=Integer.parseInt(num);
        List<Map<String,Object>> list=houseBasicsRepository.selectAllhouse(hdid);
        model.addAttribute("list",list);
        String village=(String)list.get(0).get("rname");
        int area=(Integer)list.get(0).get("area");
        List<Map<String,Object>> customers=customerRepository.selectAllcustomer();
        List<Map<String,Object>> customer=new LinkedList<>();
        for (Map<String,Object> map:customers
        ) {
            if(map.get("cusState").equals("有效客户")||map.get("cusState").equals("潜在客户"))
            if(village.equals(map.get("rname"))){
                if(map.get("area").equals("不限")) {
                    customer.add(map);
                }
                else{
                    String areanum=(String)map.get("area");
                    String[] areaArray=areanum.split("-");
                    if(Integer.parseInt(areaArray[0])<=area&&area<=Integer.parseInt(areaArray[1])){
                        customer.add(map);
                    }
                }
            }
        }
        model.addAttribute("customer",customer);
        return "housing/house::div2";
    }
   //页面跳转
    @RequestMapping("update1.do")
    public String updateFromPage(Model model,String num){
        int hdid=Integer.parseInt(num);
        List<Map<String,Object>> list=houseBasicsRepository.selectAllhouse(hdid);
        String structures=(String)list.get(0).get("structure");
        List<String> structure=new LinkedList<String>();
        for (int i = 0; i < 8; i+=2) {
            structure.add(structures.substring(i,i+1));
        }
        String date=(String)list.get(0).get("registerDate");
        date=date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6);
        list.get(0).put("registerDate",date);
        List<Village> villages=villageRepository.findAll();
        List<Staff> staff=staffRepository.findAll();
        List<Region> regions=regionRepository.findAll();
        model.addAttribute("list",list);
        model.addAttribute("villages",villages);
        model.addAttribute("staff",staff);
        model.addAttribute("regions",regions);
        model.addAttribute("structure",structure);
        return "housing/picshow";
    }

    //接受数据并更改
    @RequestMapping("updateTable.do")
    public String updateFromTable(Model model,HouseBasics houseBasics,String first,String second,String third,String fourth){
        houseBasics.setStructure(first+"室"+second+"厅"+third+"卫"+fourth+"阳");
        String[] date=houseBasics.getRegisterDate().split("-");
        houseBasics.setRegisterDate(date[0]+date[1]+date[2]);
        houseBasicsRepository.save(houseBasics);
        List<Map<String,Object>> list=houseBasicsRepository.selectAllhouse(houseBasics.getHbId());
        String structures=(String)list.get(0).get("structure");
        List<String> structure=new LinkedList<String>();
        for (int i = 0; i < 8; i+=2) {
            structure.add(structures.substring(i,i+1));
        }
        list.get(0).put("registerDate",date[0]+"-"+date[1]+"-"+date[2]);
        List<Village> villages=villageRepository.findAll();
        List<Staff> staff=staffRepository.findAll();
        List<Region> regions=regionRepository.findAll();
        model.addAttribute("list",list);
        model.addAttribute("villages",villages);
        model.addAttribute("staff",staff);
        model.addAttribute("regions",regions);
        model.addAttribute("structure",structure);
        model.addAttribute("success","success");
        return "housing/picshow";
    }
     //小区数据查询
     @RequestMapping("village")
    public String addVillagePage(Model model){
        List<Village> villages=villageRepository.findAll();
        model.addAttribute("villages",villages);
        return "housing/updatevillage";
    }
    //小区姓名查询
    @ResponseBody
    @RequestMapping("findvname.do")
    public String findVname(String vname){
        Village village=villageRepository.findByVname(vname);
        if(village!=null){
            return "error";
        }
        return "success";
    }
    //添加小区数据
    @RequestMapping("addvillage.do")
    public String addVillage(Model model,Village village){
        villageRepository.save(village);
        List<Village> villages=villageRepository.findAll();
        model.addAttribute("villages",villages);
        model.addAttribute("success","success");
        return "housing/updatevillage";
    }
    //地区数据查询
    @RequestMapping("regions")
    public String addRegionPage(Model model){
        List<Region> region=regionRepository.findAll();
        model.addAttribute("region",region);
        return "housing/updateRegion";
    }
    //地区姓名查询
    @ResponseBody
    @RequestMapping("findrname.do")
    public String findRname(String rname){
        Region region=regionRepository.findByRname(rname);
        if(region!=null){
            return "error";
        }
        return "success";
    }
    //添加地区数据
    @RequestMapping("addregion.do")
    public String addRegion(Model model,Region region){
        regionRepository.save(region);
        List<Region> regions=regionRepository.findAll();
        model.addAttribute("region",regions);
        model.addAttribute("success","success");
        return "housing/updateRegion";
    }
    //更改原来页面的数据
    @RequestMapping("updataVillageSelect.do")
    public String updateVillage(Model model,int hbId){
        List<Map<String,Object>> list=houseBasicsRepository.selectAllhouse(hbId);
        List<Village> villages=villageRepository.findAll();
        List<Region> regions=regionRepository.findAll();
        model.addAttribute("list",list);
        model.addAttribute("regions",regions);
        model.addAttribute("villages",villages);
        return "housing/picshow::div1";
    }
    //跳转到增加页面
    @RequestMapping("insert")
    public String insertFromPage(Model model){
        List<Village> villages=villageRepository.findAll();
        List<Staff> staff=staffRepository.findAll();
        List<Region> regions=regionRepository.findAll();
        model.addAttribute("villages",villages);
        model.addAttribute("staff",staff);
        model.addAttribute("regions",regions);
        return "housing/addHouse";
    }
    //增加house数据
    @RequestMapping("insertHouse.do")
    public String insertFromTable(Model model,HouseBasics houseBasics,String first,String second,String third,String fourth){
        houseBasics.setStructure(first+"室"+second+"厅"+third+"卫"+fourth+"阳");
        String[] date=houseBasics.getRegisterDate().split("-");
        houseBasics.setRegisterDate(date[0]+date[1]+date[2]);
        houseBasicsRepository.save(houseBasics);
        List<Village> villages=villageRepository.findAll();
        List<Staff> staff=staffRepository.findAll();
        List<Region> regions=regionRepository.findAll();
        model.addAttribute("villages",villages);
        model.addAttribute("staff",staff);
        model.addAttribute("regions",regions);
        model.addAttribute("success","success");
        return "housing/addHouse";
    }
    @ResponseBody
    @RequestMapping("delete.do")
    public String delete(Model model,int num){
        Optional<HouseBasics> houseBasics=houseBasicsRepository.findById(new Integer(num));
        houseBasics.get().setState("失效");
        houseBasicsRepository.save(houseBasics.get());
        return "success";
    }
        //文件上传请求
    @ResponseBody
    @RequestMapping("daoru")
    public String daoru(@RequestParam("userUploadFile") MultipartFile file) throws IOException {
        String fileName = null;

        ReadExcelUtils readExcelUtils=new ReadExcelUtils();
        List <HouseBasics> list = new ArrayList<>();
        fileName ="E:\\mytable\\"+file.getOriginalFilename();
        InputStream is=new FileInputStream(fileName);
        list=readExcelUtils.read2003Xls(is);
        for (int i=0;i<list.size();i++) {
            houseBasicsRepository.savea(list.get(i).getRegisterDate(),list.get(i).getState(),list.get(i).getStructure(),list.get(i).getArea(),list.get(i).getFloor(),list.get(i).getFloorHeight(),
                    list.get(i).getRid(),list.get(i).getVid(),list.get(i).getDecoration(),list.get(i).getPurpose(),list.get(i).getUid(),list.get(i).getDetailedAdd(),list.get(i).getRentalPrice(),list.get(i).getRentalExplain()
                    ,list.get(i).getSellPrice(),list.get(i).getSellExplain(),list.get(i).getInfrastructure(),list.get(i).getFacilities(),list.get(i).getDetailed(),list.get(i).getOwner(),list.get(i).getTelephone(),list.get(i).getMobilePhone(),list.get(i).getSpecificAddress());
        }
        return "sucess";
    }
}
