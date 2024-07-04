package com.sofrecom.prix.Entities;

import com.sofrecom.prix.entities.Services;
import com.sofrecom.prix.entities.ServicesPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicesPriceTest {

    ServicesPrice price;
    @BeforeEach
    void setup(){
        price = new ServicesPrice();
    }
    @Test
    void getId() {
        int id =1;
        price.setId(id);
        assertEquals(id,price.getId());
    }

    @Test
    void getName() {
        String name = "name";
        price.setName(name);
        assertEquals(name,price.getName());
    }

    @Test
    void getProvider() {
        String provider = "provider1";
        price.setProvider(provider);
        assertEquals(provider,price.getProvider());
    }

    @Test
    void getPrice() {
        int usd =23;
        price.setPrice(usd);
        assertEquals(usd,price.getPrice());
    }

    @Test
    void getServiceType() {
        Services type = Services.BUILD;
        price.setServiceType(type);
        assertEquals(type,price.getServiceType());

    }
}
