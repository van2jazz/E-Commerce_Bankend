package com.dayo.ECommerceBankend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerUpdateDTO  {

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String emailId;

    private String password;

    private Map<String, Address> address = new HashMap<>();
}
