package com.dayo.ECommerceBankend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
