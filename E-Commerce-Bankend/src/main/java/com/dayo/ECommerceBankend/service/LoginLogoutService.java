package com.dayo.ECommerceBankend.service;

import com.dayo.ECommerceBankend.model.UserSession;
import com.dayo.ECommerceBankend.model.CustomerDTO;
import com.dayo.ECommerceBankend.model.SellerDTO;
import com.dayo.ECommerceBankend.model.SessionDTO;


public interface LoginLogoutService {
	
	public UserSession loginCustomer(CustomerDTO customer);

	public SessionDTO logoutCustomer(SessionDTO session);

	public void checkTokenStatus(String token);

	public void deleteExpiredTokens();

	public UserSession loginSeller(SellerDTO seller);

	public SessionDTO logoutSeller(SessionDTO session);



}
