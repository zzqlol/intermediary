package com.zlzl.intermediary.repository;

import com.zlzl.intermediary.entity.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

//JPA中对于管理员表的操作
public interface AdministratorsRepository  extends JpaRepository<Administrators,Integer> {
    Administrators findAdministratorsByDmUsernameAndAdmPassword(String dmUsername,String admPassword);

    @Transactional
    @Modifying
    @Query(value = "update administrators set adm_password=?1 where adm_id=?2",nativeQuery = true)
    int xiugaimama(String pwd,int id);
    @Query(value = "select adm_password from administrators where adm_id=?",nativeQuery = true)
    String findpwdbyid(int id);
    @Transactional
    @Modifying
    @Query(value = "insert into administrators(dm_username, adm_password, adm_name) values (?1,?2,?3)",nativeQuery = true)
    int addadm(String username,String pwd,String name);

}
