package com.example.bons.controller;

import com.example.bons.controller.dto.AddressDTO;
import com.example.bons.entity.Address;
import com.example.bons.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/address")
    public Address createAddress(@RequestBody AddressDTO addressDTO){
        return addressService.storeAddres(addressDTO);
    }
}
