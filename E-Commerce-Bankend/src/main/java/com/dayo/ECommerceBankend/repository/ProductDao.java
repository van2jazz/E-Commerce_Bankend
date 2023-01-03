package com.dayo.ECommerceBankend.repository;

import com.dayo.ECommerceBankend.model.CategoryEnum;
import com.dayo.ECommerceBankend.model.Product;
import com.dayo.ECommerceBankend.model.ProductDTO;
import com.dayo.ECommerceBankend.model.ProductStatus;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query("select new com.dayo.ECommerceBankend.model.ProductDTO(p.productName,p.manufacturer,p.price,p.quantity)"
            + "from Product p where p.category=:catenum")
    public List<ProductDTO> getAllProductsInACategory(@Param("catenum") CategoryEnum catenum);


    @Query("select new com.dayo.ECommerceBankend.model.ProductDTO(p.productName,p.manufacturer, p.price, p.quantity)"
            + "from Product p where p.status=:status")
    public List<ProductDTO> getProductsWithStatus(@Param("status")ProductStatus status);

    @Query("select new com.dayo.ECommerceBankend.model.ProductDTO(p.productName,p.manufacturer,p.price,p.quantity)"
    + "from Product p where p.seller.sellerId=:id")
    public List<ProductDTO> getProductsOfASeller(@Param("id")Integer id);




}
