package com.api.OnlineRestaurantBackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.OnlineRestaurantBackend.Entities.ItemCarrinhoEntity;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinhoEntity, Long> {

}
