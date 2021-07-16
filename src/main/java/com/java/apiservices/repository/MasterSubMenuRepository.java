package com.java.apiservices.repository;

import com.java.apiservices.entity.MasterMenu;
import com.java.apiservices.entity.MasterSubMenu;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasterSubMenuRepository extends JpaRepository<MasterSubMenu, String> {

    @Query("select m from MasterSubMenu m where (m.subMenuName LIKE %:search% OR m.subMenuDescription LIKE %:search%) ")
    List<MasterSubMenu> findAll(String search, Pageable pageable);

    @Query("select m from MasterSubMenu m where m.masterMenu =:masterMenu AND (m.subMenuName LIKE %:search% OR m.subMenuDescription LIKE %:search%) ")
    List<MasterSubMenu> findByMasterMenu(MasterMenu masterMenu, String search, Pageable pageable);

}
