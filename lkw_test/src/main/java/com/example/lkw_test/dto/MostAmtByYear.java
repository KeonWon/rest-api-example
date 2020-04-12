package com.example.lkw_test.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MostAmtByYear {
	@Id
	@Column(name = "YEAR")
	private String year;		//거래년도
	
	@Column(name = "NAME")
	private String name;	//계좌명
	
	@Column(name = "ACCT_NO")
	private String acctNo;		//계좌번호
	
	@Column(name = "SUM_AMT")
	private long sumAmt;		//금액

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public long getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(long sumAmt) {
		this.sumAmt = sumAmt;
	}
	
}	
