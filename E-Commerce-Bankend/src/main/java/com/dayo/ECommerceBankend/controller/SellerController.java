package com.dayo.ECommerceBankend.controller;

import com.dayo.ECommerceBankend.model.Seller;
import com.dayo.ECommerceBankend.model.SellerDTO;
import com.dayo.ECommerceBankend.model.SessionDTO;
import com.dayo.ECommerceBankend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SellerController {

    @Autowired
    private SellerService sService;

    //To add Seller

    @PostMapping("/addseller")
    public ResponseEntity<Seller> addSellerHandler(@Valid @ResponseBody Seller seller) {

        Seller addseller = sService.addSeller(seller);

        System.out.println("Seller" + seller);

        return new ResponseEntity<Seller>(addseller, HttpStatus.CREATED);
    }

    //Get the list of seller-----------------------
    @GetMapping("/sellers")
    public ResponseEntity<List<Seller>> getAllSellerHandler(){

        List<Seller> sellers= sService.getAllSellers(){
            return new ResponseEntity<List<Seller>>(sellers, HttpStatus.OK);
        }
    }

    //Get seller by id
    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<Seller> getSellerByIdHandler(@PathVariable("sellerId") Integer Id){

        Seller getSeller = sService.getSellerById(Id);

        return new ResponseEntity<Seller>(getSeller, HttpStatus.OK);
    }


    // Get Seller by mobile Number

    @GetMapping("/seller")
    public ResponseEntity<Seller> getSellerByMobileNumber(@RequestParam("mobile")String mobile, @RequestHeader("token") String token){

        Seller getSeller = sService.getSellerByMobileNumber(mobile, token);

        return new ResponseEntity<Seller>(getSeller, HttpStatus.OK);
    }

    //Get currently logged in seller
    @GetMapping("/seller/current")
    public ResponseEntity<Seller> getLoggedInSellerHandler(@RequestHeader("token")String token){

        Seller getSeller = sService.getCurrentlyLoggedSeller(token);

        return new ResponseEntity<Seller>(getSeller, HttpStatus.OK);
    }

    //update the seller
    @GetMapping("/seller")
    public ResponseEntity<Seller> updateSellerHandler(@RequestBody Seller seller, @RequestHeader("token") String token){

        Seller updatedseller = sService.updateSeller(seller, token);

        return new ResponseEntity<Seller>(updatedseller, HttpStatus.ACCEPTED);
    }

    //update seller mobile
    public ResponseEntity<Seller> updateSellerMobileHandler(@Valid @RequestBody SellerDTO sellerDTO, @RequestHeader("token") String token){
        Seller updatedseller = sService.updateSellerMobile(sellerDTO, token);

        return new ResponseEntity<Seller>(updatedseller, HttpStatus.ACCEPTED)
    }

    //update seller password
    @PutMapping("/seller/update/password")
    public ResponseEntity<SessionDTO> updateSellerPasswordHandler(@Valid @RequestBody SellerDTO sellerDTO, @RequestHeader("token") String token){
        return new ResponseEntity<>(sService.updateSellerPassword(sellerDTO, token), HttpStatus.ACCEPTED)
    }

    public ResponseEntity<Seller> deleteSellerByIdHandler(@PathVariable("sellerID")Integer Id, @RequestHeader("token") String token){
        Seller deletedSeller = sService.deleteSellerById(Id, token);

        return new ResponseEntity<Seller>(deletedSeller, HttpStatus.OK);
    }


}
