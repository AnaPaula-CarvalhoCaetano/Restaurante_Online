package com.api.OnlineRestaurantBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.OnlineRestaurantBackend.Entities.SobremesaEntity;

@Repository
public interface SobremesaRepository extends JpaRepository<SobremesaEntity, Long>{

}
