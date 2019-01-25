package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.HouseBasics;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

//jpa对于房屋信息表的操作
public interface HouseBasicsRepository extends JpaRepository<HouseBasics,Integer> {
    @Query("select new map(h.hbId as hdId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities ) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid ")
    Page<Map<String,Object>> selectAll(Pageable pageable);

    @Query("select new map(h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities ) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where h.hbId=:hbId")
    List<Map<String,Object>> selectAll1(int hbId);

    HouseBasics findByHbId(int hbId);
    @Transactional
    @Modifying
    @Query(value = "update HouseBasics set state='已出租' where hbId=:hbId")
    int updateStateByBbid(int hbId);
    @Query(value = "update HouseBasics set state='已出售' where hbId=:hbId")
    int updateStateByBbid1(int hbId);

   @Query("select new map(h.hbId as hdId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities ) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where h.state like :state and r.rid = :rid and h.structure like :structure and h.rentalPrice <:rentalPricehigh and h.rentalPrice >:rentalPricelow")
    Page<Map<String,Object>> selectAllBy(Pageable pageable,String state,int rid,String structure,int rentalPricelow,int rentalPricehigh);

    @Query("select new map(h.hbId as hdId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities ) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where h.state like :state and r.rid =:rid and h.structure like :structure and h.rentalPrice <:rentalPricehigh and h.rentalPrice >:rentalPricelow")
    List<Map<String,Object>> selectAllBy1(String state,int rid,String structure,int rentalPricelow,int rentalPricehigh);
    @Query("select detailedAdd from HouseBasics")
    String[] findDetailedAdd();
    @Query("select hbId as hdId from HouseBasics where detailedAdd=:detailedAdd")
    String findhdIdByDetailedAdd(String detailedAdd);

}
