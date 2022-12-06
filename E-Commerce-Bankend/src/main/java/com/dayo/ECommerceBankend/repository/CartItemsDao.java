package com.dayo.ECommerceBankend.repository;

import com.dayo.ECommerceBankend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsDao extends JpaRepository <CartItem, Integer>{
}
