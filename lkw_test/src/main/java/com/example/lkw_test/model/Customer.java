package com.example.lkw_test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@Column(name = "ACCT_NO")
	private String acctNo;	//계좌번호
	
	@Column(name = "NAME")
	private String name;	//계좌명
	
	@Column(name = "BR_CODE")
	private String brCode;	//관리점코드

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}
	
	
}
