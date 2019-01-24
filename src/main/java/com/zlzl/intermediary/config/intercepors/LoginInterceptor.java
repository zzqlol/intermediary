package com.zlzl.intermediary.config.intercepors;

import com.zlzl.intermediary.entity.Administrators;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Administrators administrators=(Administrators)session.getAttribute("user");
        if(administrators==null){
            return false;
        }
        else {
            return true;
        }
    }
}
