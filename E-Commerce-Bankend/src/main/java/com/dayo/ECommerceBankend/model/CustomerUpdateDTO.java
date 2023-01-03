package com.dayo.ECommerceBankend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerUpdateDTO  {

    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter valid characters for first name")
    private String firstName;

    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter valid characters for last name")
    private String lastName;

    @NotNull(message = "Please enter the mobile Number")
    @Pattern(regexp = "[234]{1}[0-9]{10}", message = "Enter valid mobile number")
    private String mobileNo;

    @Column(unique = true)
    @Email
    private String emailId;

    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include A-Z, a-z, 0-9, or special characters !@#$%^&*_")
    private String password;

    private Map<String, Address> address = new HashMap<>();
}
