package com.dayo.ECommerceBankend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDTO {

    @NotNull
    private Integer productId;

    private String productName;

    private Double price;

    @Min(1)
    private Integer quantity;


}
