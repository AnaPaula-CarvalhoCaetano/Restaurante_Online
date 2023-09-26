package com.api.OnlineRestaurantBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.OnlineRestaurantBackend.Entities.PagamentoEntity;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {

}
