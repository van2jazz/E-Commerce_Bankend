package com.dayo.ECommerceBankend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity

public class CartItem {

    private Integer cartItemId;

    @OneToOne
    @JsonIgnoreProperties(value = {
            "productId",
            "seller",
            "quality"
    })
    private Product cartProduct;

    private Integer cartItemQuantity;
}
