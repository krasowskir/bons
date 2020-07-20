package com.example.bons.service;

import com.example.bons.controller.dto.AddressDTO;
import com.example.bons.entity.Address;
import com.example.bons.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressService() { }

    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Address storeAddres(@Validated AddressDTO tmpAddress){
        Address addressToStore = new Address(tmpAddress.getFirstName(),tmpAddress.getLastName(),tmpAddress.getStreet(),
                tmpAddress.getPostCode(),tmpAddress.getCity(),tmpAddress.getTelephoneNumber());
        return addressRepository.save(addressToStore);
    }
}
