package com.sofrecom.prix.Services;

import com.sofrecom.prix.entities.Services;
import com.sofrecom.prix.entities.ServicesPrice;
import com.sofrecom.prix.repositories.ServicesPriceRepo;
import com.sofrecom.prix.services.ServicesPriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ServicesPriceServiceTest {

    @Mock
    ServicesPriceRepo servicesPriceRepo;

    @InjectMocks
    ServicesPriceService servicesPriceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addServicesPrice() {
        ServicesPrice servicesPrice = new ServicesPrice();
        when(servicesPriceRepo.save(servicesPrice)).thenReturn(servicesPrice);

        String result = servicesPriceService.addServicesPrice(servicesPrice);
        assertEquals("Added", result);
        verify(servicesPriceRepo, times(1)).save(servicesPrice);
    }

    @Test
    void updateServicesPrice() {
        ServicesPrice existingServicesPrice = new ServicesPrice();
        existingServicesPrice.setId(1);

        ServicesPrice updatedServicesPrice = new ServicesPrice();
        updatedServicesPrice.setName("Updated Service");
        updatedServicesPrice.setPrice(100);
        updatedServicesPrice.setProvider("Updated Provider");

        when(servicesPriceRepo.findById(existingServicesPrice.getId())).thenReturn(Optional.of(existingServicesPrice));
        when(servicesPriceRepo.saveAndFlush(existingServicesPrice)).thenReturn(updatedServicesPrice);

        String result = servicesPriceService.updateServicesPrice(updatedServicesPrice, existingServicesPrice.getId());
        assertEquals("updated", result);
        assertEquals(updatedServicesPrice.getName(), existingServicesPrice.getName());
        assertEquals(updatedServicesPrice.getPrice(), existingServicesPrice.getPrice());
        assertEquals(updatedServicesPrice.getProvider(), existingServicesPrice.getProvider());
    }

    @Test
    void deleteServicesPrice() {
        int id = 1;
        servicesPriceService.deleteServicesPrice(id);
        verify(servicesPriceRepo, times(1)).deleteById(id);
    }

    @Test
    void getAllServicesPrice() {
        Services service = Services.RUN;


        ServicesPrice servicePrice1 = new ServicesPrice();
        servicePrice1.setName("Service 1");
        servicePrice1.setServiceType(service);

        ServicesPrice servicePrice2 = new ServicesPrice();
        servicePrice2.setName("Service 2");
        servicePrice2.setServiceType(service);

        List<ServicesPrice> servicesPrices = new ArrayList<>();
        servicesPrices.add(servicePrice1);
        servicesPrices.add(servicePrice2);

        when(servicesPriceRepo.findByServiceType(service)).thenReturn(servicesPrices);

        List<ServicesPrice> result = servicesPriceService.getAllServicesPrice(service);
        assertEquals(2, result.size());
    }

    @Test
    void getServicesPriceByName() {
        String serviceName = "Service Name";
        ServicesPrice servicesPrice = new ServicesPrice();
        servicesPrice.setName(serviceName);

        when(servicesPriceRepo.findByName(serviceName)).thenReturn(servicesPrice);

        ServicesPrice result = servicesPriceService.getServicesPriceByName(serviceName);
        assertEquals(serviceName, result.getName());
    }

    @Test
    void getServicesPriceByProvider() {
        String provider = "Provider Name";
        ServicesPrice servicesPrice1 = new ServicesPrice();
        servicesPrice1.setProvider(provider);

        ServicesPrice servicesPrice2 = new ServicesPrice();
        servicesPrice2.setProvider(provider);

        List<ServicesPrice> servicesPrices = new ArrayList<>();
        servicesPrices.add(servicesPrice1);
        servicesPrices.add(servicesPrice2);

        when(servicesPriceRepo.findByProvider(provider)).thenReturn(servicesPrices);

        List<ServicesPrice> result = servicesPriceService.getServicesPriceByProvider(provider);
        assertEquals(2, result.size());
    }
}
