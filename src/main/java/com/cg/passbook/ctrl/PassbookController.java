package com.cg.passbook.ctrl;

import java.util.Date;
import java.util.HashSet;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.passbook.service.PassbookService;
import com.cg.passbook.dto.Passbook;
import com.cg.passbook.exceptions.AccNotFoundException;



@RestController
@RequestMapping("/passCtrl")
@Validated
public class PassbookController {
	
@Autowired
PassbookService passbookService;




@RequestMapping("/fetchBankTransaction/{accountNo}")
public HashSet<Passbook> getBankTransactions(@PathVariable("accountNo")long accountNo) throws AccNotFoundException 
{
	return (HashSet)passbookService.getPassbookUpdate(accountNo);
}

@RequestMapping("/fetchBankTransactionByDate/{accountNo}/{date}/{enddate}")
public HashSet<Passbook> getBankTransactionsDate(@PathVariable("accountNo")long accountNo,@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd")Date date,@PathVariable("enddate") @DateTimeFormat(pattern="yyyy-MM-dd")Date enddate) throws AccNotFoundException 
{
	return (HashSet)passbookService.getAccountSummary(accountNo,date,enddate);
}


@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
ResponseEntity<String> handleConstraintViolation(Exception e) {
  return new ResponseEntity<>(":" + e.getMessage(), HttpStatus.BAD_REQUEST);
	
}




}
