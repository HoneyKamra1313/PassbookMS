package com.cg.passbook.service;

import java.util.Date;

import java.util.Set;

import org.springframework.data.repository.query.Param;


import com.cg.passbook.dto.Passbook;
import com.cg.passbook.exceptions.AccNotFoundException;


public interface PassbookService {

	
	public Set<Passbook> getPassbookUpdate(@Param("tra")long accountNo) throws AccNotFoundException;
	public Set<Passbook> getAccountSummary(@Param("ara")long accountNo,@Param("hra")Date date,@Param("era")Date enddate) throws AccNotFoundException;


	
	
}
