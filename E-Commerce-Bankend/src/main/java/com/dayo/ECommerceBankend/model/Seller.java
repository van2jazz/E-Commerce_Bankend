package com.dayo.ECommerceBankend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer SellerId;

    @NotNull(message = "Enter your firstName")
    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter your first name")
    private String firstName;

    @NotNull(message = "Enter your lastName")
    @Pattern(regexp = "[A-Za-z.\\s] +", message = "Enter your last name")
    private String lastName;

    @NotNull(message = "Enter Mobile Number")
    @Column(unique = true)
    @Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter a valid 10 digits mobile number")
    private String mobile;

    @NotNull
    @Column(unique = true)
    @Email
    private String emailId;

    @NotNull(message = "Enter your password")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include A-Z, a-z, 0-9, or special characters !@#$%^&*_")
    private String password;

    @OneToMany
    @JsonIgnore
    private List<Product> products;
}
