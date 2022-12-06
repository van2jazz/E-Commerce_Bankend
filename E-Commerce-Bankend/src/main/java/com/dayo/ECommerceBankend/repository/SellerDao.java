package com.dayo.ECommerceBankend.repository;

import com.dayo.ECommerceBankend.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SellerDao extends JpaRepository<Seller, Integer> {

    Optional<Seller> findByMobile(String mobile);

//    Optional<Seller> findByUserId(Integer userId);

}
