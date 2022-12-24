package com.optimised.cylonbackup.repository;

import com.optimised.cylonbackup.model.Site;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SiteRepo extends CrudRepository<Site,Long> {

    Site findFirstByNameOrDirectory(String name, String director);

    @Transactional
    @Modifying
    @Query("UPDATE Site SET existing=false")
     int existingToFalse();

    @Transactional
    @Modifying
    @Query("DELETE FROM Site WHERE existing=false ")
     void deleteByExistingFalse();

 }
