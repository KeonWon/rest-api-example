package com.example.lkw_test.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(NoTransExceptThisYearPK.class)
public class NoTransExceptThisYear {
	@Id
	@Column(name = "YEAR")
	private String year;		//거래년도
	
	@Column(name = "NAME")
	private String name;	//계좌명
	
	@Id
	@Column(name = "ACCT_NO")
	private String acctNo;		//계좌번호

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
	
}	
	