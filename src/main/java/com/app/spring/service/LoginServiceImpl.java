package com.app.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.spring.DAO.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean validateLogin(String userName, String password) {
		// TODO Auto-generated method stub
		return loginDao.validateLogin(userName, password);
	}

}
