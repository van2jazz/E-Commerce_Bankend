package com.dayo.ECommerceBankend.service;

import com.dayo.ECommerceBankend.model.CartDTO;
import com.dayo.ECommerceBankend.model.CartItem;

public interface CartItemService {

    public CartItem createItemForCart(CartDTO cartdto);
}
