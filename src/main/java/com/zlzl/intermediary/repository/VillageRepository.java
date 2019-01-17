package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Village;
import org.springframework.data.jpa.repository.JpaRepository;
//jpa对于小区表的操作
public interface VillageRepository extends JpaRepository<Village,Integer> {
}
