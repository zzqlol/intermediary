package com.zlzl.intermediary.contraller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 对于系统设置子页面的所有请求都进入这个页面
 * 系统设置请求都以system开头
 * 所属页面放在system下
 */
@Controller
@RequestMapping("system")
public class SystemSetup {

}
