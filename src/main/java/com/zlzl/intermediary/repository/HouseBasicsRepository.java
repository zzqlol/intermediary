package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.HouseBasics;
import org.springframework.data.jpa.repository.JpaRepository;
//jpa对于房屋信息表的操作
public interface HouseBasicsRepository extends JpaRepository<HouseBasics,Integer> {
}
