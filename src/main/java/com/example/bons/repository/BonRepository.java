package com.example.bons.repository;

import com.example.bons.entity.Bon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "bons", collectionResourceRel = "myBons")
public interface BonRepository extends JpaRepository<Bon, UUID> {

}
