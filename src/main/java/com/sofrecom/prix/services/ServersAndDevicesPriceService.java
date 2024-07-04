package com.sofrecom.prix.services;


import com.sofrecom.prix.entities.ServerType;
import com.sofrecom.prix.entities.ServersAndDevicesPrice;
import com.sofrecom.prix.repositories.ServersAndDevicesPriceRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServersAndDevicesPriceService implements IServersAndDevicesPriceService{

    private final ServersAndDevicesPriceRepo serversAndDevicesPricerepo;

    public ServersAndDevicesPriceService(ServersAndDevicesPriceRepo serversAndDevicesPricerepo) {
        this.serversAndDevicesPricerepo = serversAndDevicesPricerepo;
    }

    @Override
    public String addServersAndDevicesPrice(ServersAndDevicesPrice z) {
        serversAndDevicesPricerepo.save(z);
        return "Added";
    }
    @Override
    public String updateServersAndDevicesPrice(ServersAndDevicesPrice z ,int id) {

        ServersAndDevicesPrice z1 = serversAndDevicesPricerepo.findById(id).get();
        z1.setEuroPrice(z.getEuroPrice());
        z1.setUsdPrice(z.getUsdPrice());
        z1.setName(z.getName());
        z1.setDescr(z.getDescr());


        serversAndDevicesPricerepo.saveAndFlush(z1);
        return "updated";
    }
    @Override
    public String deleteServersAndDevicesPrice(int id) {

        serversAndDevicesPricerepo.deleteById(id);
        return "deleted";
    }
    @Override
    public List<ServersAndDevicesPrice> getAllServersAndDevicesPrice() {

        return serversAndDevicesPricerepo.findAll();
    }
    @Override
    public ServersAndDevicesPrice getServersAndDevicesPriceById(int id) {

        return serversAndDevicesPricerepo.findById(id).orElse(null);
    }
    @Override
    public  List<ServersAndDevicesPrice> findByTypeServer(ServerType s){
        return serversAndDevicesPricerepo.findByType(s);
    }
    @Override
    public  ServersAndDevicesPrice findByName(String s){
        return serversAndDevicesPricerepo.findByName(s);
    }
}
