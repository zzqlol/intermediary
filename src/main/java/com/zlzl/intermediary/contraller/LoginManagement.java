package com.zlzl.intermediary.contraller;

import com.zlzl.intermediary.entity.Administrators;
import com.zlzl.intermediary.repository.AdministratorsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录请求
 */
@Controller
public class LoginManagement {
    @Resource
   private AdministratorsRepository administratorsRepository;
    @RequestMapping("login")
    public String logindemo(){
        return "login";
    }

   @RequestMapping("login.do")
    public String login(String username, String password, Model model, HttpServletRequest request){
        Administrators administrators=administratorsRepository.findAdministratorsByDmUsernameAndAdmPassword(username,password);
        if(administrators==null){
            model.addAttribute("error","error");
            return "login";
        }
       HttpSession session=request.getSession();
        session.setAttribute("user",administrators);
       return "index";
    }
}
