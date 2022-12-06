package com.dayo.ECommerceBankend.service;

import com.dayo.ECommerceBankend.exception.SellerException;
import com.dayo.ECommerceBankend.model.Seller;
import com.dayo.ECommerceBankend.model.SellerDTO;
import com.dayo.ECommerceBankend.model.SessionDTO;

import java.util.List;

public interface SellerService {

    public Seller addSeller(Seller seller);

    public List<Seller> getAllSellers() throws SellerException;

    public Seller getSellerById(Integer sellerId)throws SellerException;

    public Seller getSellerByMobile(String mobile, String token) throws SellerException;

    public Seller getCurrentlyLoggedInSeller(String token) throws SellerException;

    public SessionDTO updateSellerPassword(SellerDTO sellerDTO, String token) throws SellerException;

    public Seller updateSeller(Seller seller, String token)throws SellerException;

    public Seller updateSellerMobile(SellerDTO sellerdto, String token)throws SellerException;

    public Seller deleteSellerById(Integer sellerId, String token)throws SellerException;

}
