package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
//jpa对于员工表的操作
public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
