package com.api.OnlineRestaurantBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.OnlineRestaurantBackend.Entities.BebidaEntity;

@Repository
public interface BebidaRepository extends JpaRepository<BebidaEntity, Long>{

}
