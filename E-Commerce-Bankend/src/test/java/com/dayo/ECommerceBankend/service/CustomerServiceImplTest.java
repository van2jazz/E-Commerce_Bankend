package com.dayo.ECommerceBankend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.dayo.ECommerceBankend.exception.CustomerNotFoundException;
import com.dayo.ECommerceBankend.model.*;
import com.dayo.ECommerceBankend.repository.CustomerDao;
import com.dayo.ECommerceBankend.repository.SessionDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dayo.ECommerceBankend.repository.CustomerDao;
import com.dayo.ECommerceBankend.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    CustomerDao customerDao;

    @Mock
    SessionDao sessionDao;

    @Mock
    LoginLogoutServiceImpl loginService;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    void testAddCustomer() {
        // Given
        Address address = new Address(1, "123", "Main St", "Locality", "City", "State", "123456", null);
        CreditCard creditCard = new CreditCard("1234567812345678", "11/2024", "123");
        Customer customer = new Customer(1, "John", "Doe", "1234567890", "john.doe@example.com", "password", LocalDateTime.now(), creditCard, new HashMap<>(), new ArrayList<>(), new Cart());


        when(customerDao.findByMobileNo(customer.getMobileNo())).thenReturn(Optional.empty());

        // When
        Customer result = customerService.addCustomer(customer);

        // Then
        assertNotNull(result);
        assertNotNull(result.getCustomerId());
        assertEquals(customer, result);
        assertNotNull(customer.getCreatedOn());
        assertNotNull(customer.getCustomerCart()); //*************************************************************
        assertTrue(customer.getOrders().isEmpty());

        verify(customerDao).findByMobileNo(customer.getMobileNo());
        verify(customerDao).save(customer);
    }

    @Test
    public void testGetLoggedInCustomerDetails() {
        String token = "customer-token";
        UserSession userSession = new UserSession();
        userSession.setUserId(1);
        Optional<Customer> customerOpt = Optional.of(new Customer());

        when(sessionDao.findByToken(token)).thenReturn(Optional.of(userSession));
        when(customerDao.findById(userSession.getUserId())).thenReturn(customerOpt);

        Customer result = customerService.getLoggedInCustomerDetails(token);

        assertNotNull(result);
        assertEquals(customerOpt.get(), result);

        verify(sessionDao).findByToken(token);
        verify(loginService).checkTokenStatus(token);
        verify(customerDao).findById(userSession.getUserId());
    }

    @Test
    void testGetAllCustomers() throws CustomerNotFoundException {
        // Arrange
        String token = "seller_token";
        UserSession userSession = new UserSession();
        userSession.setToken(token);
        userSession.setUserType("seller");
        when(sessionDao.findByToken(token)).thenReturn(Optional.of(userSession));

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        when(customerDao.findAll()).thenReturn(customers);

        // Act
        List<Customer> result = customerService.getAllCustomers(token);

        // Assert
        assertEquals(customers, result);
        verify(loginService, times(1)).checkTokenStatus(token);
        verify(sessionDao, times(1)).findByToken(token);
        verify(customerDao, times(1)).findAll();
    }


}
