package com.api.OnlineRestaurantBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.OnlineRestaurantBackend.Entities.CarrinhoEntity;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {

}
