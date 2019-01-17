package com.zlzl.intermediary.contraller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 对于统计报表子页面的所有请求都进入这个页面
 * 统计报表请求都以statist开头
 * 所属页面放在statist下
 */
@Controller
@RequestMapping("statist")
public class StatisticalReport {
}
