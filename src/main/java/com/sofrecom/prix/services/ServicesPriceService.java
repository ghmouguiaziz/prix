package com.sofrecom.prix.services;


import com.sofrecom.prix.entities.Services;
import com.sofrecom.prix.entities.ServicesPrice;
import com.sofrecom.prix.repositories.ServicesPriceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesPriceService implements IServicesPriceService{

    private final ServicesPriceRepo servicesPricerepo;

    public ServicesPriceService(ServicesPriceRepo servicesPricerepo) {
        this.servicesPricerepo = servicesPricerepo;
    }


    @Override
    public String addServicesPrice(ServicesPrice z) {
        servicesPricerepo.save(z);
        return "Added";
    }
    @Override
    public String updateServicesPrice(ServicesPrice z ,int id) {

        ServicesPrice z1 = servicesPricerepo.findById(id).get();
        z1.setName(z.getName());
        z1.setPrice(z.getPrice());
        z1.setProvider(z.getProvider());
        servicesPricerepo.saveAndFlush(z1);
        return "updated";
    }
    @Override
    public String deleteServicesPrice(int id) {

        servicesPricerepo.deleteById(id);
        return "deleted";
    }
    @Override
    public List<ServicesPrice> getAllServicesPrice(Services s) {

        return servicesPricerepo.findByServiceType(s);
    }
    @Override
    public ServicesPrice getServicesPriceByName(String name) {

        return servicesPricerepo.findByName(name);
    }
    @Override
    public List<ServicesPrice> getServicesPriceByProvider(String p) {

        return servicesPricerepo.findByProvider(p);
    }
}
