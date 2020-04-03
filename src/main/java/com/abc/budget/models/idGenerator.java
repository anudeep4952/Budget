package com.abc.budget.models;


import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class idGenerator implements IdentifierGenerator  {


	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
       try{
		return "REC"+(System.currentTimeMillis()/1000);
	}
       catch(Exception e){
    	   e.printStackTrace();
       }
	return null;
       }



}