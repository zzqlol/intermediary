package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.HouseBasics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

//jpa对于房屋信息表的操作
public interface HouseBasicsRepository extends JpaRepository<HouseBasics,Integer>{
    //查询所有
    @Query("select new map(h.hbId as hdId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid")
    Page<Map<String,Object>> selectAllhouse(Pageable pageable);
    @Query("select new map(h.hbId as hdId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where  h.registerDate > :time and h.state like :state and (r.rname like :name or v.vname like :name)")
    Page<Map<String,Object>> selectAllhouse(String name,String state,String time,Pageable pageable);
    //查询sell所有
    @Query("select new map(h.hbId as hdId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where  h.sellPrice is not null and h.state like :state and h.registerDate >:time and (r.rname like :name or v.vname like :name)")
    Page<Map<String,Object>> selectAllhouseBySell(String name,String state,String time,Pageable pageable);
    //查询rental所有
    @Query("select new map(h.hbId as hdId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities ) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where   h.rentalPrice is not null and h.state like :state and h.registerDate >:time and (r.rname like :name or v.vname like :name)")
    Page<Map<String,Object>> selectAllhouseByrental(String name,String state,String time,Pageable pageable);

    //查询ID对应数据
    @Query("select new map(h.hbId as hdId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where h.hbId=:hdid")
    List<Map<String,Object>> selectAllhouse(int hdid);

    //保存
    @Transactional
    @Modifying
    @Query(value = "insert into house_basics(register_date,state,structure,area,floor,floor_height,rid,vid,decoration,purpose,uid,detailed_add,rental_price,rental_explain,sell_price,sell_explain,infrastructure,facilities" +
            ",detailed,owner,telephone,mobile_phone,specific_address) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",nativeQuery = true)
    int savea(String registerdate,String state,String structure,int area,int floor,int floor_height,int rid,int vid,String decoration,
              String purpose,int uid,String detailed_add,int rental_price,String rental_explain,double sell_price,String sell_explain,String infrastructure,
              String facilities,String detailed,String owner, String telephone,String mobile_phone,String specific_address);




    //查询所有房屋数据量
    @Query("select count(h.hbId)" +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where  h.registerDate > :time and h.state like :state and (r.rname like :name or v.vname like :name)")
    int selectAllhouse(String name,String state,String time);
    //查询sell所有
    @Query("select count(h.hbId)" +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where  h.sellPrice is not null and h.state like :state and h.registerDate >:time and (r.rname like :name or v.vname like :name)")
    int selectAllhouseBySell(String name,String state,String time);
    //查询rental所有
    @Query("select count(h.hbId)" +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where   h.rentalPrice is not null and h.state like :state and h.registerDate >:time and (r.rname like :name or v.vname like :name)")
    int selectAllhouseByrental(String name,String state,String time);

    @Query("select new map(r.rname as rname,v.vname as vname,s.uname as uname,h.hbId as hbId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.decoration as decoration,h.infrastructure as infrastructure,h.detailedAdd as detailedAdd,h.facilities as facilities,h.owner as owner,h.telephone as telephone,h.specificAddress as specificAddress) " +
        "from HouseBasics h inner join Region r on h.rid=r.rid inner join Village  v on h.vid=v.vid inner join Staff s on h.uid=s.uid where  r.rname like CONCAT(:rname,'%') or h.rentalPrice <=:rentalPrice or h.sellPrice <=:sellPrice or h.decoration =:decoration")
    List<Map<String,Object>>selectAllByMOre(@Param("rname") String rname, int rentalPrice, double sellPrice, String decoration);
}
