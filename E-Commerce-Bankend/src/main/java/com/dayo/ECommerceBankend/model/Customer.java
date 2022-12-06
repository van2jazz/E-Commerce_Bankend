package com.dayo.ECommerceBankend.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer CustomerId;

    @NotNull(message = "Cannot be blanked")
    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter your first name")
    private String firstName;

    @NotNull(message = "Cannot be blanked")
    @Pattern(regexp = "[A-Za-z.\\s]+", message = "Enter your first name")
    private String lastName;

    @NotNull(message = "Enter Mobile Number")
    @Pattern(regexp = "[2345]{1}[0-9]{9}", message = "Enter a valid 10 digits mobile number")
    private String mobileNo;

    @NotNull(message = "Enter your email id")
    @Column(unique = true)
    @Email
    private String emailId;

    @NotNull(message = "Enter the password")
    @Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Use 8 characters or more for your password")
    private String password;


    private LocalDateTime createdOn;

    @Embedded
    private CreditCard creditCard;

    @OneToMany
    @JoinTable(name = "customer_address_mapping",
            joinColumns = {
                     @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
             },
            inverseJoinColumns = {
                     @JoinColumn(name = "address_id", referencedColumnName = "addressId")
            })
    private Map<String, Address> address = new HashMap<>();


    //OrderDao Relationship
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    //Customer - Cart Relationship
    @OneToOne(cascade = CascadeType.ALL)
    private Cart customerCart;
}
