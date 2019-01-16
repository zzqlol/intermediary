package com.zlzl.intermediary.contraller;

import com.zlzl.intermediary.entity.Administrators;
import com.zlzl.intermediary.repository.AdministratorsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class Testth {
    @Resource
    private AdministratorsRepository administratorsRepository;
    @RequestMapping
    public String testCon(Model model) {
       List<Administrators> list=administratorsRepository.findAll();
       model.addAttribute("list",list);
       return "test";
    }
}
