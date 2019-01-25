package com.zlzl.intermediary.contraller;

import com.zlzl.intermediary.entity.History;
import com.zlzl.intermediary.repository.HistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 对于成交管理子页面的所有请求都进入这个页面
 * 成交管理请求都以transaction开头
 * 所属页面放在transaction下
 */
@Controller
@RequestMapping("transaction")
public class TransactionManagement {

    @Resource
    private HistoryRepository historyRepository;
    @RequestMapping("start")
    public String test(Model model){
        //分页数据
        int page=0;
        int pageSize=3;
        Sort sort=new Sort(Sort.Direction.DESC,"registerDate");
        Pageable pageable= PageRequest.of(page,pageSize,sort);
        //分页及查询
        Page<Map<String,Object>> page1=historyRepository.selectAllhouse(pageable);
        //返回前台的数据
        Long pagesize=historyRepository.count();
        List<Map<String,Object>> list=new LinkedList<Map<String, Object>>();
        for (Map<String,Object> k:page1
        ) {
            list.add(k);
        }
        model.addAttribute("list",list);
        model.addAttribute("pagesize",pagesize);
        Long pagelength=pagesize/3;
        if(pagesize%3!=0){
            pagelength+=1;
        }
        model.addAttribute("pagelength",pagelength);
        model.addAttribute("pagenum",1);

        return "transaction/housetra";
    }
    //分页及更新页面数据
    @RequestMapping(value = "pushdata.do")
    public String pushdata( String like,String sell,String lease,String time,String timedata,String page,Model model) {
        //计算当前时间偏移x后的值
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-Integer.parseInt(timedata));
        Date date = calendar.getTime();
        //数据总量
        int pagesize =0;
        //分页
        int page1 = Integer.parseInt(page)-1;
        int pageSize = 3;
        Sort sort = new Sort(Sort.Direction.DESC, "registerDate");
        Pageable pageable = PageRequest.of(page1, pageSize, sort);
        if (like != "" && like != null) {
            like = "%" + like + "%";
        } else {
            like = "%%";
        }
        if ("true".equals(time)) {
            timedata = new SimpleDateFormat("yyyyMMdd").format(date);
            System.out.println(timedata);
        } else {
            timedata = "0";
        }
        Page<Map<String, Object>> pagelist = null;
        if ("true".equals(sell)) {
            pagelist = historyRepository.selectAllhouseBySell(like,timedata, pageable);
            pagesize=historyRepository.selectAllhouseBySell(like,timedata);
        } else if ("true".equals(lease)) {
            pagelist = historyRepository.selectAllhouseByrental(like, timedata, pageable);
            pagesize=historyRepository.selectAllhouseByrental(like, timedata);
        } else {
            pagelist = historyRepository.selectAllhouse(like, timedata, pageable);
            pagesize=historyRepository.selectAllhouse(like, timedata);
        }

        List<Map<String, Object>> list = new LinkedList<Map<String, Object>>();
        for (Map<String, Object> k : pagelist
        ) {
            list.add(k);
        }
        //返回数据为空防止报错
        if(list.size()==0){
            Map<String,Object> map=new HashMap<String,Object>(){{
                put("hisId",1);put("area","空"); put("rentalPrice","空"); put("owner","空");
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
        int pagelength = pagesize / 3;
        if (pagesize % 3 != 0) {
            pagelength += 1;
        }
        model.addAttribute("pagelength", pagelength);
        model.addAttribute("pagenum", page);

        return "transaction/housetra::div1";
    }
    //更新下方数据
    @RequestMapping("updataId.do")
    public String updatePage(Model model,String num){
        int hdid=Integer.parseInt(num);
        List<Map<String,Object>> list=historyRepository.selectAllhouse(hdid);
        model.addAttribute("list",list);
        return "transaction/housetra::div2";
    }
    //跳转页面
    @RequestMapping("updata")
    public String updatetransaction(Model model,String num){
        int hdid=Integer.parseInt(num);
        List<Map<String,Object>> list=historyRepository.updatehouse(hdid);
        System.out.println(list);
        String lease_date=(String)list.get(0).get("leaseDate");
        String date=(String)list.get(0).get("nowDate");
        date=date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6);
        list.get(0).put("nowDate",date);
        double price=(double)list.get(0).get("price");
        if(lease_date==null||lease_date==""){
            list.get(0).put("state","出售");
            model.addAttribute("money","万元");
            model.addAttribute("royalty",price*300);
            model.addAttribute("royaltys",price*30);
        }
        else {
            list.get(0).put("state","出租");
            model.addAttribute("money","元");
            model.addAttribute("royalty",price);
            model.addAttribute("royaltys",price/10);
        }
        model.addAttribute("list",list);
        return "transaction/tranDetailed";
    }
    @RequestMapping("updateforHistory.do")
    public String updateHistory(Model model, History history){
        String[] date1=history.getNowDate().split("-");
        history.setNowDate(date1[0]+date1[1]+date1[2]);
        historyRepository.save(history);
        int hdid=history.getHisId();
        List<Map<String,Object>> list=historyRepository.updatehouse(hdid);
        String lease_date=(String)list.get(0).get("leaseDate");
        String date=(String)list.get(0).get("nowDate");
        date=date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6);
        list.get(0).put("nowDate",date);
        double price=(double)list.get(0).get("price");
        if(lease_date==null||lease_date==""){
            list.get(0).put("state","出售");
            model.addAttribute("money","万元");
            model.addAttribute("royalty",price*300);
            model.addAttribute("royaltys",price*30);
        }
        else {
            list.get(0).put("state","出租");
            model.addAttribute("money","元");
            model.addAttribute("royalty",price);
            model.addAttribute("royaltys",price/10);
        }
        model.addAttribute("list",list);
        model.addAttribute("success","success");
        return "transaction/tranDetailed";
    }
}
