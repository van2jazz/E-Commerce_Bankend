package com.dayo.ECommerceBankend.service;

import com.dayo.ECommerceBankend.model.CategoryEnum;
import com.dayo.ECommerceBankend.model.Product;
import com.dayo.ECommerceBankend.model.ProductDTO;
import com.dayo.ECommerceBankend.model.ProductStatus;

import java.util.List;

public interface ProductService {

    public Product addProductToCatalog(String token, Product product);

    public Product  getProductFromCatalogId(Integer id);

    public String deleteProductFromCatalog(Integer id);

    public Product updateProductInCatalog(Product product);

    public List<Product> getAllProductInCatalog();

    public List<ProductDTO> getAllProductsOfSeller(Integer id);

    public List<ProductDTO> getProductsOfCategory(CategoryEnum cateEnum);

    public List<ProductDTO> getProductsOfStatus(ProductStatus status);

    public Product updateProductQuantityWithId(Integer id, ProductDTO prodDTO);




}
