package com.zlzl.intermediary.contraller;

import com.zlzl.intermediary.repository.ContractRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 对于成交管理子页面的所有请求都进入这个页面
 * 成交管理请求都以transaction开头
 * 所属页面放在transaction下
 */
@Controller
@RequestMapping("transaction")
public class TransactionManagement {
    private ContractRepository contractRepository;


}
