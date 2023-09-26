package com.api.OnlineRestaurantBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.OnlineRestaurantBackend.Entities.PratoEntity;

@Repository
public interface PratoRepository extends JpaRepository<PratoEntity, Long>{

}
