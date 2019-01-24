package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;
//JPA中对于管理员表的操作
public interface AdministratorsRepository  extends JpaRepository<Administrators,Integer> {

}
