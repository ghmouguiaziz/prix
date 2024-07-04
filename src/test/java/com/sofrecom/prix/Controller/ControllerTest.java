package com.sofrecom.prix.Controller;

import com.sofrecom.prix.entities.ServerType;
import com.sofrecom.prix.entities.ServersAndDevicesPrice;
import com.sofrecom.prix.entities.Services;
import com.sofrecom.prix.entities.ServicesPrice;
import com.sofrecom.prix.services.IServersAndDevicesPriceService;
import com.sofrecom.prix.services.IServicesPriceService;
import com.sofrecom.prix.controller.Controller;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ControllerTest {

    @Mock
    IServersAndDevicesPriceService serversAndDevicesPriceService;

    @Mock
    IServicesPriceService servicesPriceService;

    @InjectMocks
    Controller controller;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addServersAndDevicesPrice() {
        ServersAndDevicesPrice serversAndDevicesPrice = new ServersAndDevicesPrice();
        when(serversAndDevicesPriceService.addServersAndDevicesPrice(any(ServersAndDevicesPrice.class))).thenReturn("Servers and devices price added successfully");
        assertEquals("Servers and devices price added successfully", controller.addServersAndDevicesPrice(serversAndDevicesPrice));
    }

    @Test
    void updateServersAndDevicesPrice() {
        ServersAndDevicesPrice serversAndDevicesPrice = new ServersAndDevicesPrice();
        serversAndDevicesPrice.setId(1);


        int id = 1;
        when(serversAndDevicesPriceService.updateServersAndDevicesPrice(any(ServersAndDevicesPrice.class), eq(id))).thenReturn("Servers and devices price updated successfully");
        assertEquals("Servers and devices price updated successfully", controller.updateServersAndDevicesPrice(serversAndDevicesPrice, id));
    }

    @Test
    void deleteServersAndDevicesPrice() {
        int id = 1;
        when(serversAndDevicesPriceService.deleteServersAndDevicesPrice(id)).thenReturn("Servers and devices price deleted successfully");
        assertEquals("Servers and devices price deleted successfully", controller.deleteServersAndDevicesPrice(id));
    }

    @Test
    void getAllServersAndDevicesPrice() {
        List<ServersAndDevicesPrice> serversAndDevicesPriceList = Collections.singletonList(new ServersAndDevicesPrice());
        when(serversAndDevicesPriceService.getAllServersAndDevicesPrice()).thenReturn(serversAndDevicesPriceList);
        assertEquals(serversAndDevicesPriceList, controller.getAllServersAndDevicesPrice());
    }

    @Test
    void getServersAndDevicesPriceById() {
        int id = 1;
        ServersAndDevicesPrice serversAndDevicesPrice = new ServersAndDevicesPrice();
        when(serversAndDevicesPriceService.getServersAndDevicesPriceById(id)).thenReturn(serversAndDevicesPrice);
        assertEquals(serversAndDevicesPrice, controller.getServersAndDevicesPriceById(id));
    }

    @Test
    void findByTypeServer() {
        ServerType type = ServerType.SERVER;
        List<ServersAndDevicesPrice> serversAndDevicesPriceList = Collections.singletonList(new ServersAndDevicesPrice());
        when(serversAndDevicesPriceService.findByTypeServer(type)).thenReturn(serversAndDevicesPriceList);
        assertEquals(serversAndDevicesPriceList, controller.findByTypeServer(type));
    }

    @Test
    void findByName() {
        String name = "ServerName";
        ServersAndDevicesPrice serversAndDevicesPrice = new ServersAndDevicesPrice();
        when(serversAndDevicesPriceService.findByName(name)).thenReturn(serversAndDevicesPrice);
        assertEquals(serversAndDevicesPrice, controller.findByName(name));
    }


    @Test
    void addServicesPrice() {
        ServicesPrice servicesPrice = new ServicesPrice();
        when(servicesPriceService.addServicesPrice(any(ServicesPrice.class))).thenReturn("Services price added successfully");
        assertEquals("Services price added successfully", controller.addServicesPrice(servicesPrice));
    }

    @Test
    void updateServicesPrice() {
        ServicesPrice servicesPrice = new ServicesPrice();
        servicesPrice.setId(1);
        // Set other properties...

        int id = 1;
        when(servicesPriceService.updateServicesPrice(any(ServicesPrice.class), eq(id))).thenReturn("Services price updated successfully");
        assertEquals("Services price updated successfully", controller.updateServicesPrice(servicesPrice, id));
    }

    @Test
    void deleteServicesPrice() {
        int id = 1;
        when(servicesPriceService.deleteServicesPrice(id)).thenReturn("Services price deleted successfully");
        assertEquals("Services price deleted successfully", controller.deleteServicesPrice(id));
    }

    @Test
    void getAllServicesPrice() {
        Services service = Services.RUN;
        List<ServicesPrice> servicesPriceList = Collections.singletonList(new ServicesPrice());
        when(servicesPriceService.getAllServicesPrice(service)).thenReturn(servicesPriceList);
        assertEquals(servicesPriceList, controller.getAllServicesPrice(service));
    }

    @Test
    void getServicesPriceByName() {
        String name = "ServiceName";
        ServicesPrice servicesPrice = new ServicesPrice();
        when(servicesPriceService.getServicesPriceByName(name)).thenReturn(servicesPrice);
        assertEquals(servicesPrice, controller.getServicesPriceByName(name));
    }

    @Test
    void getServicesPriceByProvider() {
        String provider = "ServiceProvider";
        List<ServicesPrice> servicesPriceList = Collections.singletonList(new ServicesPrice());
        when(servicesPriceService.getServicesPriceByProvider(provider)).thenReturn(servicesPriceList);
        assertEquals(servicesPriceList, controller.getServicesPriceByProvider(provider));
    }



}
