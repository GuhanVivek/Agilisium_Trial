package com.app.spring.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;



@Repository
public class LoginDaoImpl implements LoginDao {
	
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean validateLogin(String userName, String password) {
		//http://gurugubellitech.blogspot.com/2017/01/jsp-servlet-hibernate-mysql-example.html
		Session session  = sessionFactory.openSession();
		try{
			List lstChurchList = session.createSQLQuery("select * from parish_church_info").list();
			Query query = session.createSQLQuery("select * from parish_church_info");
			
			
			System.out.println(lstChurchList);
		//session.saveOrUpdate(parishChurchInfoEntity);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Exception in save church info,due to "+e);
			return false;
		}
		finally{
			session.close();
		}
		
		
	}

}
