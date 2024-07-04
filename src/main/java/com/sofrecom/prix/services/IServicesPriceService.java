package com.sofrecom.prix.services;



import com.sofrecom.prix.entities.Services;
import com.sofrecom.prix.entities.ServicesPrice;

import java.util.List;

public interface IServicesPriceService {
    public String addServicesPrice(ServicesPrice z ) ;
    public String updateServicesPrice(ServicesPrice z ,int id);
    public String deleteServicesPrice(int id);
    public List<ServicesPrice> getAllServicesPrice(Services s);
    public ServicesPrice getServicesPriceByName(String name);
    public List<ServicesPrice> getServicesPriceByProvider(String p);

}
