package com.cg.passbook.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.cg.passbook.dao.PassbookRepository;
import com.cg.passbook.dto.Passbook;
import com.cg.passbook.exceptions.AccNotFoundException;



@Service
public class PassbookServiceImpl implements PassbookService {

	@Autowired
	PassbookRepository passbookDao;
	
	
	public Set<Passbook> getPassbookUpdate(@Param("tra")long accountNo) throws AccNotFoundException
	{
		ArrayList<Passbook> transList=(ArrayList)passbookDao.findAll();
		
		
		Set<Passbook> transactions = passbookDao.getPassbookUpdate(accountNo);
		passbookDao.updatePassbook(accountNo);
		if(transactions.isEmpty())
		{
			throw new AccNotFoundException("Transactions not found for the given id");
		}
		
		else
			return transactions;
		
		
	
	}
	
	
	public Set<Passbook> getAccountSummary(@Param("ara")long accountNo,@Param("hra")Date date,@Param("era")Date enddate) throws AccNotFoundException 
	{
		ArrayList<Passbook> dateList=(ArrayList)passbookDao.findAll();
		Set<Passbook> transactions = passbookDao.getAccountSummary(accountNo,date,enddate);
		
		
		if(transactions.isEmpty())
		{
			throw new AccNotFoundException("Transactions not found for the given id");
		}
		else
		return transactions;
		
		
	}
	
	
	
	
}
