package com.java.apiservices.repository;

import com.java.apiservices.entity.MasterMenu;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MasterMenuRepository extends JpaRepository<MasterMenu, String> {

    @Query("select m from MasterMenu m where (m.menuName LIKE %:search% OR m.menuDescription LIKE %:search%) ")
    List<MasterMenu> findAll(String search, Pageable pageable);

}
