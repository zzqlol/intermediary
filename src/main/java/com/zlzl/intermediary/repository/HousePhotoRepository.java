package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.HousePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
//jpa中对于房源照片表的操作
public interface HousePhotoRepository extends JpaRepository<HousePhoto,Integer> {
}
