package com.example.bons.repository;

import com.example.bons.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;


@RepositoryRestResource(path = "addresses")
public interface AddressRepository extends JpaRepository<Address, UUID> {

    List<Address> findByLastNameLike(@Param("name") String name);
}
