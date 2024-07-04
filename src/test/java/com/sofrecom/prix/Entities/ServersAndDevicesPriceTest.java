package com.sofrecom.prix.Entities;

import com.sofrecom.prix.entities.ServerType;
import com.sofrecom.prix.entities.ServersAndDevicesPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServersAndDevicesPriceTest {

    ServersAndDevicesPrice price;
    @BeforeEach
    void setup(){
        price = new ServersAndDevicesPrice();
    }
    @Test
    void getId() {
        int id = 1;
        price.setId(id);
        assertEquals(id,price.getId());
    }

    @Test
    void getEuroPrice() {
        int euro = 3;
        price.setEuroPrice(euro);
        assertEquals(euro,price.getEuroPrice());
    }

    @Test
    void getUsdPrice() {
        int usd = 6;
        price.setUsdPrice(usd);
        assertEquals(usd,price.getUsdPrice());
    }

    @Test
    void getName() {
        String name = "name";
        price.setName(name);
        assertEquals(name,price.getName());
    }

    @Test
    void getDescr() {
        String desc= "desc";
        price.setDescr(desc);
        assertEquals(desc,price.getDescr());
    }

    @Test
    void getType() {
        ServerType type=ServerType.SERVER;
        price.setType(type);
        assertEquals(type,price.getType());

    }
}
