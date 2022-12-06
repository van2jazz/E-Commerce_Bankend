package com.dayo.ECommerceBankend.model;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;

public class OrderDTO {
    @NotNull
    @Embedded
    private CreditCard cardNumber;

    @NotNull
    private String addressType;
}
