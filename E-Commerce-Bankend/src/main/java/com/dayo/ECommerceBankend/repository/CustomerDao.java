package com.dayo.ECommerceBankend.repository;

import com.dayo.ECommerceBankend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByMobileNo(String mobileNumber);

    Optional<Customer> findByEmailId(String emailId);

    Optional<Customer> findByMobileNumberOrEmailid(String mobileNumber, String emailId);
}
