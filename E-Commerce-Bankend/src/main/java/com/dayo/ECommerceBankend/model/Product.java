package com.dayo.ECommerceBankend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    @NotNull
    @Size(min = 3, max = 30, message = "Length of product name should be between 3-30")
    private String productName;

    @NotNull
    @DecimalMin(value = "0.00")
    private Double price;

    private String description;

    @NotNull
    private String manufacturer;

    @NotNull
    @Min(value = 0)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private Enum category;

    @Enumerated(EnumType.STRING)
    private Enum status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Seller seller;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private OrderDao order;
//
//    @ManyToMany
//    @JsonIgnore
//    private List<Cart> productCarts = new ArrayList<>();


}
