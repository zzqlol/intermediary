package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
//Jpa对于客户表的所有操作
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
