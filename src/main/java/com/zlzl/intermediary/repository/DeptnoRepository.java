package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Deptno;
import org.springframework.data.jpa.repository.JpaRepository;
//jpa中对于部门表的操作
public interface DeptnoRepository extends JpaRepository<Deptno,Integer> {
}
