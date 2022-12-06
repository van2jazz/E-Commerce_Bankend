package com.dayo.ECommerceBankend.service;

import com.dayo.ECommerceBankend.exception.CustomerException;
import com.dayo.ECommerceBankend.exception.CustomerNotFoundException;
import com.dayo.ECommerceBankend.model.*;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer) throws CustomerException;

    public Customer getLoggedInCustomerDetails(String token) throws CustomerNotFoundException;

    public List<Customer> getAllCustomer(String token) throws CustomerNotFoundException;

    public Customer updateCustomer(CustomerUpdateDTO customer, String token) throws CustomerNotFoundException;

    public Customer updateCustomerMobileNoOrEmailId(CustomerUpdateDTO customerUpdateDTO, String token) throws CustomerNotFoundException;

    public Customer updateCreditCardDetails(String token, CreditCard card) throws CustomerException;

    public SessionDTO updateCustomerPassword(CustomerDTO customerDTO, String token) throws CustomerNotFoundException;

    public SessionDTO deleteCustomer(CustomerDTO customerDTO, String token) throws CustomerNotFoundException;

    public Customer updateAddress(Address address, String type, String token) throws CustomerException;

    public Customer deleteAddress(String type, String token) throws CustomerException, CustomerNotFoundException;

    public List<Order> getCustomerOrders(String token) throws CustomerException;

}
