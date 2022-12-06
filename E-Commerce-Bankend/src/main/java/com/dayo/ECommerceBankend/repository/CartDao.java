package com.dayo.ECommerceBankend.repository;

import com.dayo.ECommerceBankend.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
}
