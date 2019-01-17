package com.zlzl.intermediary.contraller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 对于房源管理子页面的所有请求都进入这个页面
 * 房源管理请求都以housing开头
 * 所属页面放在housing下
 */
@Controller
@RequestMapping("housing")
public class HousingManagement {
}
