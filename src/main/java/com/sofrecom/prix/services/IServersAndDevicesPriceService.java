package com.sofrecom.prix.services;



import com.sofrecom.prix.entities.ServerType;
import com.sofrecom.prix.entities.ServersAndDevicesPrice;

import java.util.List;

public interface IServersAndDevicesPriceService {
    public String addServersAndDevicesPrice(ServersAndDevicesPrice z ) ;
    public String updateServersAndDevicesPrice(ServersAndDevicesPrice z ,int id);
    public String deleteServersAndDevicesPrice(int id);
    public List<ServersAndDevicesPrice> getAllServersAndDevicesPrice();
    public ServersAndDevicesPrice getServersAndDevicesPriceById(int id);
    List<ServersAndDevicesPrice> findByTypeServer(ServerType s);
    public  ServersAndDevicesPrice findByName(String s);
}
