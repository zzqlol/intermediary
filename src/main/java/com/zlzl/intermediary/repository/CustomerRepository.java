package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

//Jpa对于客户表的所有操作
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,c.area as area,c.structure as structure,c.decoration as decoration,r.rname as rname,s.uname as uname)" +
            "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid=r.rid order by c.inputDate ")
    List<Map<String,Object>> selectAllcustomer();
}
