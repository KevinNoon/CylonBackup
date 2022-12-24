package com.optimised.cylonbackup.service;

import com.optimised.cylonbackup.model.Site;
import com.optimised.cylonbackup.repository.SiteRepo;
import lombok.extern.log4j.Log4j2;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class SiteService {
    @Autowired
    SiteRepo siteRepo;

    public void AddUpdate(Site siteEntity) {

        try {
            Site WNini = siteRepo.findFirstByNameOrDirectory(siteEntity.getName(),siteEntity.getDirectory());
            if (!(WNini == null)){
                siteEntity.setId(WNini.getId());
            }
            siteRepo.save(siteEntity);
        } catch (
                ConstraintViolationException e) {
            log.error(e.getMessage());
        }
    }

    public List<Site> list(){
        return (List<Site>) siteRepo.findAll();

    }

    public void delete(Site site){
        siteRepo.delete(site);
    }

    public void deleteNoExisting(){
        siteRepo.deleteByExistingFalse();
    }

    public void setExisting(){
        siteRepo.existingToFalse();
    }
}
