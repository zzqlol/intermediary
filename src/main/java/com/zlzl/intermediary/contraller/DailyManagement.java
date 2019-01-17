package com.zlzl.intermediary.contraller;

import com.zlzl.intermediary.entity.Administrators;
import com.zlzl.intermediary.repository.AdministratorsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 对于日常管理子页面的所有请求都进入这个页面
 * 日常管理请求都以daily开头
 * 所属页面放在daily下
 */
@Controller
@RequestMapping("daily")
public class DailyManagement {

}
