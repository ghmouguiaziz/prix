package com.sofrecom.prix.repositories;


import com.sofrecom.prix.entities.Services;
import com.sofrecom.prix.entities.ServicesPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicesPriceRepo extends JpaRepository<ServicesPrice,Integer> {

    List<ServicesPrice> findByServiceType(Services s);
    ServicesPrice findByName(String name);
    List<ServicesPrice> findByProvider(String p);

}
