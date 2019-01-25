package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.HousePhoto;
import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

//jpa中对于房源照片表的操作
public interface HousePhotoRepository extends JpaRepository<HousePhoto,Integer> {

    @Query("select p.photoAdd as photo from HousePhoto p where p.hbId=:hbId")
    String[] selectphotoAdd(int hbId);

    @Query("select p.photoAdd as photo from HousePhoto p inner join HouseBasics h on p.hbId=h.hbId where h.detailedAdd=:detailAdd")
    String[] selectphotoAddBydetailadd(String detailAdd);

    @Transactional
    @Modifying
    @Query(value = "insert house_photo (hb_id,photo_add) values (?,?)",nativeQuery = true)
    int insertdata(int hbId,String detailAdd);

}

