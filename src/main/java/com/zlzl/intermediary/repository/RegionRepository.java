package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//jpa对于区域表的操作
public interface RegionRepository extends JpaRepository<Region,Integer> {
    Region findByRname(String rname);

    @Query("select rid from Region where rname=:rname")
    int findByRnamejie(String rname);
}
