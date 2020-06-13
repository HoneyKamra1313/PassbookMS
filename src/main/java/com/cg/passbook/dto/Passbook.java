package com.cg.passbook.dto;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;






@Entity
@Table(name="transaction")
public class Passbook {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="transactionid",length=10)
	private int transactionId;
	@Column(name="accountno",length=12)
	private long accountNo;
	@Column(name="transactiondate",length=20)
	private Date transactionDate;
	@Column(name="transactionamount",length=10)
	private Integer transactionAmount;
	@Column(name="transactiontype",length=10)
	private String transactionType;
	@Column(name="status",length=10)
	private String status;
	@Column(name="print",length=10)
	private String print;
	
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Integer getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrint() {
		return print;
	}
	public void setPrint(String print) {
		this.print = print;
	}
	
	public Passbook() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Passbook(int transactionId,long accountNo, Date transactionDate, Integer transactionAmount,
			String transactionType, String status, String print) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.status = status;
		this.print = print;
	}
	@Override
	public String toString() {
		return "Passbook [transactionId=" + transactionId + ", accountNo=" + accountNo + ", transactionDate="
				+ transactionDate + ", transactionAmount=" + transactionAmount + ", transactionType=" + transactionType
				+ ", status=" + status + ", print=" + print + "]";
	}
	
	
	
	

}
