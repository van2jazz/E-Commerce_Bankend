package com.dayo.ECommerceBankend.service;

import com.dayo.ECommerceBankend.exception.ProductNotFoundException;
import com.dayo.ECommerceBankend.model.CartDTO;
import com.dayo.ECommerceBankend.model.CartItem;
import com.dayo.ECommerceBankend.model.Product;
import com.dayo.ECommerceBankend.model.ProductStatus;
import com.dayo.ECommerceBankend.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService{

    @Autowired
    ProductDao productDao;

    @Override
    public CartItem createItemforCart(CartDTO cartdto) {

        Product existingProduct = productDao.findById(cartdto.getProductId()).orElseThrow( () -> new ProductNotFoundException("Product Not found"));

        if(existingProduct.getStatus().equals(ProductStatus.OUTOFSTOCK) || existingProduct.getQuantity() == 0) {
            throw new ProductNotFoundException("Product OUT OF STOCK");
        }

        CartItem newItem = new CartItem();

        newItem.setCartItemQuantity(1);

        newItem.setCartProduct(existingProduct);

        return newItem;
    }


}
