//package com.example.bons.controller;
//
//import com.example.bons.controller.dto.AddressDTO;
//import com.example.bons.entity.Address;
//import com.example.bons.service.AddressService;
//import com.example.bons.service.CustomerExportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class AddressController {
//
//    @Autowired
//    private AddressService addressService;
//
//    @Autowired
//    private CustomerExportService customerExportService;
//
//    @PostMapping(value = "/address")
//    public Address createAddress(@RequestBody AddressDTO addressDTO) throws InterruptedException {
//        return addressService.storeAddress(addressDTO);
//    }
//
//    @PostMapping(value = "/exportAddress")
//    public boolean exportAddress(@RequestBody AddressDTO addressDTO) throws InterruptedException {
//        return customerExportService.exportAddress(addressDTO);
//    }
//
//    @GetMapping("/addresses")
//    public List<Address> showAllAddresses() throws InterruptedException {
//        return addressService.showAllAddresses();
//    }
//
//    @GetMapping("/addressesLike")
//    public List<Address> showAllAddressesLike(@RequestParam(name = "name")String name) throws InterruptedException {
//        return addressService.showExclusiveAddresses(name);
//    }
//
//    @PostMapping("/adjustAddressesLike")
//    public List<Address> adjustAddresses(@RequestParam(name = "name")String name) throws InterruptedException {
//        return addressService.adjustAddresses(name);
//    }
//}
