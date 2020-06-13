package com.cg.passbook.dao;

import java.util.Date;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.passbook.dto.Passbook;

public interface PassbookRepository extends JpaRepository<Passbook, Integer> {

	
	@Query("select tr from Passbook tr where tr.accountNo = :tra and tr.print is null")
	public Set<Passbook> getPassbookUpdate(@Param("tra")long accountNo);
	
	
	
	@Query("select tr from Passbook tr where tr.accountNo = :ara AND tr.transactionDate >= :hra AND tr.transactionDate <= :era")
	public Set<Passbook> getAccountSummary(@Param("ara")long accountNo,@Param("hra")Date date,@Param("era")Date enddate);
	
	@Modifying
	@Transactional
	@Query("update Passbook tr set tr.print = 'true' where tr.accountNo = :tra")
	public void updatePassbook(@Param("tra")long accountNo);
	
	
}
