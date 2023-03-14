package com.dayo.ECommerceBankend.repository;

import com.dayo.ECommerceBankend.model.Address;
import com.dayo.ECommerceBankend.model.Cart;
import com.dayo.ECommerceBankend.model.CreditCard;
import com.dayo.ECommerceBankend.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDaoTest;

//    @AfterEach
//    void tearDown() {
//        customerDaoTest.deleteAll();
//    }

    @Test
    public void testCustomer() {
        Address address = new Address(1, "123", "Main St", "Locality", "City", "State", "123456", null);
        CreditCard creditCard = new CreditCard("1234567812345678", "11/2024", "123");
        Customer customer = new Customer(1, "John", "Doe", "1234567890", "john.doe@example.com", "password", LocalDateTime.now(), creditCard, new HashMap<>(), new ArrayList<>(), new Cart());

        customer.getAddress().put("home", address);

        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("1234567890", customer.getMobileNo());
        assertEquals("john.doe@example.com", customer.getEmailId());
        assertEquals("password", customer.getPassword());
        assertEquals(LocalDateTime.now().getYear(), customer.getCreatedOn().getYear());
        assertEquals(creditCard, customer.getCreditCard());
        assertEquals(1, customer.getAddress().size());
        assertEquals(address, customer.getAddress().get("home"));
    }

}


