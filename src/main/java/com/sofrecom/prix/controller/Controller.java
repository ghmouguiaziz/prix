package com.sofrecom.prix.controller;

import com.sofrecom.prix.entities.ServerType;
import com.sofrecom.prix.entities.ServersAndDevicesPrice;
import com.sofrecom.prix.entities.Services;
import com.sofrecom.prix.entities.ServicesPrice;
import com.sofrecom.prix.services.IServersAndDevicesPriceService;
import com.sofrecom.prix.services.IServicesPriceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "http://localhost:4200/")
public class Controller {


//////////////////////////////////ServersAndDevicesPrice///////////////////////////////////////////////

    private final IServersAndDevicesPriceService iServersAndDevicesPriceservice;

    public Controller(IServersAndDevicesPriceService iServersAndDevicesPriceservice, IServicesPriceService iServicesPriceservice) {
        this.iServersAndDevicesPriceservice = iServersAndDevicesPriceservice;
        this.iServicesPriceservice = iServicesPriceservice;
    }

    @PostMapping("/addServersAndDevicesPrice")
    public String addServersAndDevicesPrice(@RequestBody ServersAndDevicesPrice z) {

        return  iServersAndDevicesPriceservice.addServersAndDevicesPrice(z);
    }
    @PutMapping("/updateServersAndDevicesPrice/{id}")
    public String updateServersAndDevicesPrice(@RequestBody ServersAndDevicesPrice z,@PathVariable int id){
        return iServersAndDevicesPriceservice.updateServersAndDevicesPrice(z,id);
    }
    @DeleteMapping("/deleteServersAndDevicesPrice/{id}")
    public String deleteServersAndDevicesPrice(@PathVariable int id) {

        return  iServersAndDevicesPriceservice.deleteServersAndDevicesPrice(id);
    }
    @GetMapping("/getAllServersAndDevicesPrice")
    public List<ServersAndDevicesPrice> getAllServersAndDevicesPrice(){

        return iServersAndDevicesPriceservice.getAllServersAndDevicesPrice();
    }
    @GetMapping("/getServersAndDevicesPriceById/{id}")
    public ServersAndDevicesPrice getServersAndDevicesPriceById(@PathVariable int id){

        return iServersAndDevicesPriceservice.getServersAndDevicesPriceById(id);
    }
    @GetMapping("/findByTypeServer/{type}")
    public  List<ServersAndDevicesPrice> findByTypeServer(@PathVariable ServerType type){
        return iServersAndDevicesPriceservice.findByTypeServer(type);
    }
    @GetMapping("/findServersAndDevicesPriceByName/{name}")
    public  ServersAndDevicesPrice findByName(@PathVariable String name){
        return iServersAndDevicesPriceservice.findByName(name);
    }

    //////////////////////////////////ServicesPrice///////////////////////////////////////////////


    private final IServicesPriceService iServicesPriceservice;

    @PostMapping("/addServicesPrice")
    public String addServicesPrice(@RequestBody ServicesPrice z) {

        return  iServicesPriceservice.addServicesPrice(z);
    }
    @PutMapping("/updateServicesPrice/{id}")
    public String updateServicesPrice(@RequestBody ServicesPrice z,@PathVariable int id){
        return iServicesPriceservice.updateServicesPrice(z,id);
    }
    @DeleteMapping("/deleteServicesPrice/{id}")
    public String deleteServicesPrice(@PathVariable int id) {

        return  iServicesPriceservice.deleteServicesPrice(id);
    }
    @GetMapping("/getAllServicesPrice/{s}")
    public List<ServicesPrice> getAllServicesPrice(@PathVariable Services s){

        return iServicesPriceservice.getAllServicesPrice(s);
    }
    @GetMapping("/getServicesPriceByName/{name}")
    public ServicesPrice getServicesPriceByName(@PathVariable String name){

        return iServicesPriceservice.getServicesPriceByName(name);
    }

    @GetMapping("/getServicesPriceByProvider/{p}")
    public List<ServicesPrice> getServicesPriceByProvider(@PathVariable String p){

        return iServicesPriceservice.getServicesPriceByProvider(p);
    }


}

