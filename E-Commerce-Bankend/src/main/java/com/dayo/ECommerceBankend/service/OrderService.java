package com.dayo.ECommerceBankend.service;

import com.dayo.ECommerceBankend.exception.LoginException;
import com.dayo.ECommerceBankend.exception.CustomerNotFoundException;
import com.dayo.ECommerceBankend.exception.OrderException;
import com.dayo.ECommerceBankend.model.Customer;
import com.dayo.ECommerceBankend.model.Order;
import com.dayo.ECommerceBankend.model.OrderDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    public Order saveOrder(OrderDTO odto, String token) throws LoginException, OrderException;

    public Order getOrderByOrderId(Integer OrderId) throws OrderException;

    public List<Order> getAllOrders() throws OrderException;

    public Order cancelOrderByOrderId(Integer OrderId,String token) throws OrderException;

    public Order updateOrderByOrder(OrderDTO order,Integer OrderId,String token) throws OrderException,LoginException;

    public List<Order> getAllOrdersByDate(LocalDate date) throws OrderException;

    public Customer getCustomerByOrderid(Integer orderId) throws OrderException;

//    public Customer getCustomerIdByToken(String token) throws CustomerNotFoundException;
}
