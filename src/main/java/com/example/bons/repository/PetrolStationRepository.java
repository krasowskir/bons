package com.example.bons.repository;

import com.example.bons.entity.PetrolStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface PetrolStationRepository extends JpaRepository<PetrolStation, UUID> {

}
