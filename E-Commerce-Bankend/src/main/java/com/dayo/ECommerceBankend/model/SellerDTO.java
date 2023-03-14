package com.dayo.ECommerceBankend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SellerDTO {

    @NotNull(message="Please enter your mobile Number")
    @Pattern(regexp="[234]{3}[0-9]{10}", message="Enter a valid Mobile Number")
    private String mobile;

    @Pattern(regexp="[A-Za-z0-9!@#$%^&*_]{8,15}", message="Please Enter a valid Password")
    private String password;
}
