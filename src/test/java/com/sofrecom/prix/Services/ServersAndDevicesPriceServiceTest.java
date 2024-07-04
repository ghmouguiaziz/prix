package com.sofrecom.prix.Services;

import com.sofrecom.prix.entities.ServerType;
import com.sofrecom.prix.entities.ServersAndDevicesPrice;
import com.sofrecom.prix.repositories.ServersAndDevicesPriceRepo;
import com.sofrecom.prix.services.ServersAndDevicesPriceService;
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

class ServersAndDevicesPriceServiceTest {

    @Mock
    ServersAndDevicesPriceRepo serversAndDevicesPriceRepo;

    @InjectMocks
    ServersAndDevicesPriceService serversAndDevicesPriceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addServersAndDevicesPrice() {
        ServersAndDevicesPrice price = new ServersAndDevicesPrice();
        when(serversAndDevicesPriceRepo.save(price)).thenReturn(price);

        String result = serversAndDevicesPriceService.addServersAndDevicesPrice(price);

        assertEquals("Added", result);
        verify(serversAndDevicesPriceRepo, times(1)).save(price);
    }

    @Test
    void updateServersAndDevicesPrice() {
        int id = 1;
        ServersAndDevicesPrice priceToUpdate = new ServersAndDevicesPrice();
        priceToUpdate.setId(id);

        when(serversAndDevicesPriceRepo.findById(id)).thenReturn(Optional.of(priceToUpdate));
        when(serversAndDevicesPriceRepo.saveAndFlush(priceToUpdate)).thenReturn(priceToUpdate);

        ServersAndDevicesPrice updatedPrice = new ServersAndDevicesPrice();
        updatedPrice.setEuroPrice(100);
        updatedPrice.setUsdPrice(90);
        updatedPrice.setName("Updated Name");
        updatedPrice.setDescr("Updated Description");

        String result = serversAndDevicesPriceService.updateServersAndDevicesPrice(updatedPrice, id);

        assertEquals("updated", result);
        assertEquals(updatedPrice.getEuroPrice(), priceToUpdate.getEuroPrice());
        assertEquals(updatedPrice.getUsdPrice(), priceToUpdate.getUsdPrice());
        assertEquals(updatedPrice.getName(), priceToUpdate.getName());
        assertEquals(updatedPrice.getDescr(), priceToUpdate.getDescr());

        verify(serversAndDevicesPriceRepo, times(1)).findById(id);
        verify(serversAndDevicesPriceRepo, times(1)).saveAndFlush(priceToUpdate);
    }

    @Test
    void deleteServersAndDevicesPrice() {
        int id = 1;

        String result = serversAndDevicesPriceService.deleteServersAndDevicesPrice(id);

        assertEquals("deleted", result);
        verify(serversAndDevicesPriceRepo, times(1)).deleteById(id);
    }

    @Test
    void getAllServersAndDevicesPrice() {
        List<ServersAndDevicesPrice> priceList = new ArrayList<>();
        when(serversAndDevicesPriceRepo.findAll()).thenReturn(priceList);

        List<ServersAndDevicesPrice> result = serversAndDevicesPriceService.getAllServersAndDevicesPrice();

        assertEquals(priceList, result);
        verify(serversAndDevicesPriceRepo, times(1)).findAll();
    }

    @Test
    void getServersAndDevicesPriceById() {
        int id = 1;
        ServersAndDevicesPrice price = new ServersAndDevicesPrice();
        when(serversAndDevicesPriceRepo.findById(id)).thenReturn(Optional.of(price));

        ServersAndDevicesPrice result = serversAndDevicesPriceService.getServersAndDevicesPriceById(id);

        assertEquals(price, result);
        verify(serversAndDevicesPriceRepo, times(1)).findById(id);
    }

    @Test
    void findByTypeServer() {
        ServerType serverType = ServerType.SERVER;
        List<ServersAndDevicesPrice> priceList = new ArrayList<>();
        when(serversAndDevicesPriceRepo.findByType(serverType)).thenReturn(priceList);

        List<ServersAndDevicesPrice> result = serversAndDevicesPriceService.findByTypeServer(serverType);

        assertEquals(priceList, result);
        verify(serversAndDevicesPriceRepo, times(1)).findByType(serverType);
    }

    @Test
    void findByName() {
        String name = "ServerName";
        ServersAndDevicesPrice price = new ServersAndDevicesPrice();
        when(serversAndDevicesPriceRepo.findByName(name)).thenReturn(price);

        ServersAndDevicesPrice result = serversAndDevicesPriceService.findByName(name);

        assertEquals(price, result);
        verify(serversAndDevicesPriceRepo, times(1)).findByName(name);
    }
}
