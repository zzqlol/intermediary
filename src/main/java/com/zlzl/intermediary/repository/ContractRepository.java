package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
//JPA中对于合同表的操作
public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
