package com.dayo.ECommerceBankend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embedded;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class OrderDTO {

    @NotNull
    @Embedded
    private CreditCard cardNumber;

    @NotNull
    private String addressType;
}
