package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

//jpa中对于历史订单表的操作
public interface HistoryRepository extends JpaRepository<History,Integer> {

    //查询所有订单表中的房屋信息
    @Query("select new map(hi.hisId as hisId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities, hi.nowDate as nowDate) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid inner join History hi on hi.hbId=h.hbId ")
    Page<Map<String,Object>> selectAllhouse(Pageable pageable);
    //模糊查询及时间所有房屋
    @Query("select new map(hi.hisId as hisId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities,hi.nowDate as nowDate) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid inner join History hi on hi.hbId=h.hbId where  hi.nowDate > :time  and (r.rname like :name or v.vname like :name)")
    Page<Map<String,Object>> selectAllhouse(String name,String time,Pageable pageable);
    //查询sell所有
    @Query("select new map(hi.hisId as hisId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities,hi.nowDate as nowDate) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid  inner join History hi on hi.hbId=h.hbId where  hi.nowDate >:time and hi.leaseDate is null and(r.rname like :name or v.vname like :name)")
    Page<Map<String,Object>> selectAllhouseBySell(String name,String time,Pageable pageable);
    //查询rental所有
    @Query("select new map(hi.hisId as hisId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities,hi.nowDate as nowDate) " +
            "from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid inner join History hi on hi.hbId=h.hbId where hi.leaseDate is not null  and hi.nowDate >:time and (r.rname like :name or v.vname like :name)")
    Page<Map<String,Object>> selectAllhouseByrental(String name,String time,Pageable pageable);

    //查询ID对应的修改订单数据
    @Query("select new map(hi.hisId as hisId,h.hbId as hdId,h.uid as uid,h.owner as owner,h.state as state,v.vname as vname,hi.customerName as customerName,hi.customerPhone as customerPhone,hi.price as price,hi.leaseDate as leaseDate,s.uname as uname,hi.nowDate as nowDate)" +
            "from History hi inner join Staff s on hi.uid=s.uid inner join HouseBasics h on hi.hbId=h.hbId inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid  where hi.hisId=:hisId")
    List<Map<String,Object>> updatehouse(int hisId);

    @Query("select new map(h.hbId as hdId,h.registerDate as registerDate,h.state as state,h.structure as structure,h.area as area,h.floor as floor,h.floorHeight as floorHeight,r.rname as rname,v.vname as vname," +
            "h.decoration as decoration,h.purpose as purpose,s.uname as uname,h.detailedAdd as detailedAdd,h.rentalPrice as rentalPrice,h.rentalExplain as rentalExplain,h.sellPrice as sellPrice,h.sellExplain as sellExplain," +
            "h.infrastructure as infrastructure,h.detailed as detailed,h.owner as owner,h.telephone as telephone,h.mobilePhone as mobilePhone,h.specificAddress as specificAddress,h.facilities as facilities) " +
            "from HouseBasics h inner join History hi on hi.hbId=h.hbId inner join Staff s on h.uid=s.uid inner join Region r on h.rid=r.rid inner join Village v on v.vid=h.vid where hi.hisId=:hisId")
    List<Map<String,Object>> selectAllhouse(int hisId);


    //模糊查询及时间所有房屋
    @Query("select count(hi.hisId) from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid= r.rid inner join Village v on v.vid= h.vid inner join History hi on hi.hbId=h.hbId where  hi.nowDate > :time  and (r.rname like :name or v.vname like :name)")
    int selectAllhouse(String name,String time);
    //查询sell所有
    @Query("select count(hi.hisId) from HouseBasics h inner join Staff s on h.uid=s.uid inner join Region r on h.rid= r.rid inner join Village v on v.vid= h.vid  inner join History hi on hi.hbId=h.hbId where  hi.nowDate >:time and hi.leaseDate is null and(r.rname like :name or v.vname like :name)")
    int selectAllhouseBySell(String name,String time);
    //查询rental所有
    @Query("select count(hi.hisId) from HouseBasics h inner join History hi on hi.hbId=h.hbId inner join Staff s on h.uid=s.uid inner join Region r on h.rid= r.rid inner join Village v on v.vid= h.vid  where hi.leaseDate is not null  and hi.nowDate >:time and (r.rname like :name or v.vname like :name)")
    int selectAllhouseByrental(String name,String time);

    //查询员工在对应月份的交易量
    @Query("select count(hi) from History hi  where hi.uid=:uid and hi.nowDate>:starttime and hi.nowDate<:endtime")
    int findbysatff(String starttime,String endtime,int uid);
    //查询员工在对应月份的交易额
    @Query("select case WHEN sum(hi.price) is null then 0 else sum(hi.price) end from History hi  where hi.uid=:uid and hi.nowDate>:starttime and hi.nowDate<:endtime")
    double findbyprice(String starttime,String endtime,int uid);
}
