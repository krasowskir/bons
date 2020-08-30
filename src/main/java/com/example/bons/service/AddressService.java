package com.example.bons.service;

import com.example.bons.controller.dto.AddressDTO;
import com.example.bons.entity.Address;
import com.example.bons.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

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

    @Transactional(isolation = Isolation.READ_UNCOMMITTED,propagation = Propagation.REQUIRED)
    public Address storeAddress(@Validated AddressDTO tmpAddress) throws InterruptedException {
        Address addressToStore = new Address(tmpAddress.getFirstName(),tmpAddress.getLastName(),tmpAddress.getStreet(),
                tmpAddress.getPostCode(),tmpAddress.getCity(),tmpAddress.getTelephoneNumber());
        Address storedAddress = addressRepository.save(addressToStore);
        Thread.sleep(2000);
        return storedAddress;
    }

    public Address findAddress(UUID id){
        if (addressRepository.findById(id).isPresent()){
            throw new NoResultException();
        }
        return addressRepository.findById(id).get();
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED,propagation = Propagation.REQUIRES_NEW)
    public List<Address> showAllAddresses() throws InterruptedException {
        List<Address> addressen = addressRepository.findAll();
        Thread.sleep(3000);
        return addressen;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Address> showExclusiveAddresses(String name) throws InterruptedException {
        List<Address> addressen = addressRepository.findByLastNameLike(name);
        Thread.sleep(2000);
        return addressen;
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Address> adjustAddresses(String name) throws InterruptedException {
        List<Address> addresses = this.showExclusiveAddresses(name);
        for (Address elem : addresses){
            if (elem.getFirstName().equals("richard")){
                elem.setFirstName("otto");
            }
        }
        Thread.sleep(5000);
        return this.showExclusiveAddresses(name);
    }
}
