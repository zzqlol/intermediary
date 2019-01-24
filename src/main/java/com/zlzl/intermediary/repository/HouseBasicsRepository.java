package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.HouseBasics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

//jpa对于房屋信息表的操作
public interface HouseBasicsRepository extends JpaRepository<HouseBasics,Integer> {
    @Query("select new map(r.rname as rname,v.vname as vname,s.uname as uname,h.hbId as hbId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.decoration as decoration,h.infrastructure as infrastructure,h.detailedAdd as detailedAdd,h.facilities as facilities,h.owner as owner,h.telephone as telephone,h.specificAddress as specificAddress) " +
        "from HouseBasics h inner join Region r on h.rid=r.rid inner join Village  v on h.vid=v.vid inner join Staff s on h.uid=s.uid where  r.rname like CONCAT(:rname,'%') or h.rentalPrice <=:rentalPrice or h.sellPrice <=:sellPrice or h.decoration =:decoration")
    List<Map<String,Object>>selectAllByMOre(@Param("rname") String rname, int rentalPrice, double sellPrice, String decoration);
}
