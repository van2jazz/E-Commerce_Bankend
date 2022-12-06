package com.dayo.ECommerceBankend.service;

import com.dayo.ECommerceBankend.exception.CartItemNotFound;
import com.dayo.ECommerceBankend.exception.ProductNotFound;
import com.dayo.ECommerceBankend.model.Cart;
import com.dayo.ECommerceBankend.model.CartDTO;

public interface CartService {

    public Cart addProductToCart(CartDTO cart, String token) throws CartItemNotFound;
    public Cart getCartProduct(String token);
    public Cart removeProductFromCart(CartDTO cartDto,String token) throws ProductNotFound;
//	public Cart changeQuantity(Product product,Customer customer,Integer quantity);

    public Cart clearCart(String token);

}
