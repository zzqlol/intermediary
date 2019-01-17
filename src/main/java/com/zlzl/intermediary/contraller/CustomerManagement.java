package com.zlzl.intermediary.contraller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 对于客户管理子页面的所有请求都进入这个页面
 * 客户管理请求都以customer开头
 * 所属页面放在custimer包下
 */
@Controller
@RequestMapping("customer")
public class CustomerManagement {

}
