package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
//jpa中对于历史订单表的操作
public interface HistoryRepository extends JpaRepository<History,Integer> {
}
