package com.example.bons.service;

import com.example.bons.controller.dto.AddressDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerExportService {

    @Autowired
    private AddressService addressService;

    @Autowired
    private RestTemplate template;

    Logger LOGGER = LoggerFactory.getLogger(CustomerExportService.class);

    @Transactional
    public boolean exportAddress(AddressDTO addressToStore) {
        LOGGER.debug("enter exportAddress");
        addressService.storeAddres(addressToStore);
        LOGGER.debug("stored addressToStore {}", addressToStore);
        ResponseEntity<String> response = template.postForEntity("http://localhost:8080/order-place/finishOrders", addressToStore, String.class);
        return response.getStatusCode().is2xxSuccessful();
    }
}
