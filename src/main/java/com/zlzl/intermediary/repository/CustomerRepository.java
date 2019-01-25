package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//Jpa对于客户表的所有操作
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,c.area as area,c.structure as structure,c.decoration as decoration,r.rname as rname,s.uname as uname)" +
            "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid=r.rid order by c.inputDate ")
    List<Map<String,Object>> selectAllcustomer();
    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,r.rname as rname,c.structure as structure,s.uname as uname,c.decoration as decoration,c.infrastructure as infrastructure,c.area as area,c.mobilePhone as mobilePhone,c.purpose as purpose,c.facilities as facilities,c.seekExplain as seekExplain,c.buyExplain as buyExplain,c.buyPrice as buyPrice,c.seekPrice as seekPrice) " +
          "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid = r.rid where  s.uname like :uname")
    Page<Map<String,Object>> selectAll(String uname, Pageable pageable);
    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,r.rname as rname,c.structure as structure,s.uname as uname,c.decoration as decoration,c.infrastructure as infrastructure,c.area as area,c.mobilePhone as mobilePhone,c.purpose as purpose,c.facilities as facilities,c.seekExplain as seekExplain,c.buyExplain as buyExplain,c.buyPrice as buyPrice,c.seekPrice as seekPrice) " +
          "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid = r.rid where c.seekPrice is not  null and s.uname like  CONCAT(:uname,'%')")
    Page<Map<String,Object>> selectAllBySeek_price(@Param("uname") String uname, Pageable pageable);
    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,r.rname as rname,c.structure as structure,s.uname as uname,c.decoration as decoration,c.infrastructure as infrastructure,c.area as area,c.mobilePhone as mobilePhone,c.purpose as purpose,c.facilities as facilities,c.seekExplain as seekExplain,c.buyExplain as buyExplain,c.buyPrice as buyPrice,c.seekPrice as seekPrice) " +
          "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid = r.rid where  c.buyPrice is not null and s.uname like  CONCAT(:uname,'%')")
    Page<Map<String,Object>> selectAllByBuy_price(@Param("uname") String uname, Pageable pageable);
    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,r.rname as rname,c.structure as structure,s.uname as uname,c.decoration as decoration,c.infrastructure as infrastructure,c.area as area,c.mobilePhone as mobilePhone,c.purpose as purpose,c.facilities as facilities,c.seekExplain as seekExplain,c.buyExplain as buyExplain,c.buyPrice as buyPrice,c.seekPrice as seekPrice) " +
          "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid = r.rid where  s.uname like  CONCAT(:uname,'%')")
    Page<Map<String,Object>> selectAllByUname(@Param("uname") String uname, Pageable pageable);
    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,r.rname as rname,c.structure as structure,s.uname as uname,c.decoration as decoration,c.infrastructure as infrastructure,c.area as area,c.mobilePhone as mobilePhone,c.purpose as purpose,c.facilities as facilities,c.seekExplain as seekExplain,c.buyExplain as buyExplain,c.buyPrice as buyPrice,c.seekPrice as seekPrice) " +
            "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid = r.rid where  c.cid =:cid")
    List<Map<String,Object>> selectAllByUid(int cid);
    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,r.rname as rname,c.structure as structure,s.uname as uname,c.decoration as decoration,c.infrastructure as infrastructure,c.area as area,c.mobilePhone as mobilePhone,c.purpose as purpose,c.facilities as facilities,c.seekExplain as seekExplain,c.buyExplain as buyExplain,c.buyPrice as buyPrice,c.seekPrice as seekPrice) " +
            "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid = r.rid where c.seekPrice is not  null and s.uname like  CONCAT(:uname,'%') and c.inputDate >=:time")
    Page<Map<String,Object>> selectAllBySeek_priceAndTime(@Param("uname") String uname,String time, Pageable pageable);
    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,r.rname as rname,c.structure as structure,s.uname as uname,c.decoration as decoration,c.infrastructure as infrastructure,c.area as area,c.mobilePhone as mobilePhone,c.purpose as purpose,c.facilities as facilities,c.seekExplain as seekExplain,c.buyExplain as buyExplain,c.buyPrice as buyPrice,c.seekPrice as seekPrice) " +
            "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid = r.rid where  c.buyPrice is not null and s.uname like  CONCAT(:uname,'%') and c.inputDate >=:time")
    Page<Map<String,Object>> selectAllByBuy_priceAndTime(@Param("uname") String uname,String time, Pageable pageable);
    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,r.rname as rname,c.structure as structure,s.uname as uname,c.decoration as decoration,c.infrastructure as infrastructure,c.area as area,c.mobilePhone as mobilePhone,c.purpose as purpose,c.facilities as facilities,c.seekExplain as seekExplain,c.buyExplain as buyExplain,c.buyPrice as buyPrice,c.seekPrice as seekPrice) " +
            "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid = r.rid where  s.uname like  CONCAT(:uname,'%') and c.inputDate >=:time")
    Page<Map<String,Object>> selectAllBytime(@Param("uname") String uname,String time, Pageable pageable);
    @Query("select new map(c.cid as cid,c.cname as cname,c.cusState as cusState,c.inputDate as inputDate,r.rname as rname,c.structure as structure,s.uname as uname,c.decoration as decoration,c.infrastructure as infrastructure,c.area as area,c.mobilePhone as mobilePhone,c.purpose as purpose,c.facilities as facilities,c.seekExplain as seekExplain,c.buyExplain as buyExplain,c.buyPrice as buyPrice,c.seekPrice as seekPrice)" +
            "from Customer c inner join Staff s on c.uid=s.uid inner join Region r on c.rid = r.rid  where c.cid like  CONCAT(:cid,'%') and c.cusState like  CONCAT(:cusState,'%')  and c.purpose like  CONCAT(:purpose,'%') and c.decoration like  CONCAT(:decoration,'%') and c.rid like  CONCAT(:rid,'%') and c.structure like  CONCAT(:structure,'%') and c.mobilePhone like CONCAT(:mobilePhone,'%') and c.cname like CONCAT(:cname,'%')")
    List<Map<String,Object>>selectAllByThose(@Param("mobilePhone") String telephone,@Param("cid") String cid,@Param("cusState") String state,@Param("purpose") String purpose,@Param("decoration") String decoration,@Param("rid") String rid,@Param("structure") String structure,@Param("cname")String cname);
    long count();
    @Modifying
    @Transactional
    @Query(value = "update Customer set cus_State ='已失效' where cid =:cid ", nativeQuery = true)
    int deleteByCid(int cid);
    @Modifying
    @Transactional
    @Query(value = "update Customer set cname=:cname,seek_Price=:seekPrice,buy_Price=:buyPrice,buy_Explain=:buyExplain,seek_Explain=:seekExplain,cus_State=:cusState,uid=:uid,purpose=:purpose,decoration=:decoration,rid=:rid,structure=:structure,area=:area,infrastructure=:infrastructure,facilities=:facilities,mobile_Phone=:mobilePhone where cid=:cid ", nativeQuery = true)
    int updateByCid(String cname,String seekPrice,String buyPrice,String buyExplain,String seekExplain,String cusState,int uid,String purpose,String decoration,int rid,String structure,String area,String infrastructure,String facilities,String mobilePhone,int cid);
}
