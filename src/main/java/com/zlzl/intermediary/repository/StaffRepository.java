package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//jpa对于员工表的操作
public interface StaffRepository extends JpaRepository<Staff,Integer> {
    @Modifying
    @Transactional
    @Query(value = "delete from Staff where uid=:uid",nativeQuery = true)
    int deleteByUid(int uid);
    @Query("select uid from Staff where uname=:uname")
    int findAllByUname(String uname);
    @Query("select new map(s.uid as uid,s.uname as uname,s.telephone as telephone,s.sex as sex,s.staffDate as staffDate,d.dname as dname) from Staff s inner  join Deptno d on s.did = d.did")
    Page<Map<String,Object>> selectAll(Pageable pageable);
    @Query("select new map(s.uid as uid,s.uname as uname,s.telephone as telephone,s.sex as sex,s.staffDate as staffDate,d.dname as dname) " +
            "from Staff s inner  join Deptno d on s.did = d.did where s.uid=:uid")
    List<Map<String,Object>> selectAllByUid(int uid);
    @Modifying
    @Transactional
    @Query(value = "update staff set uname=:uname,sex=:sex,telephone=:telephone,did=:did,staff_date=:staff_date where uid=:uid",nativeQuery = true)
    int updateByThose(String uname,String sex,String telephone,int did,String staff_date,int uid);
}
