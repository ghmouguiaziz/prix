package com.sofrecom.prix.repositories;


import com.sofrecom.prix.entities.ServerType;
import com.sofrecom.prix.entities.ServersAndDevicesPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServersAndDevicesPriceRepo extends JpaRepository<ServersAndDevicesPrice,Integer> {

    List<ServersAndDevicesPrice> findByType(ServerType s);
    ServersAndDevicesPrice findByName(String name);
}
