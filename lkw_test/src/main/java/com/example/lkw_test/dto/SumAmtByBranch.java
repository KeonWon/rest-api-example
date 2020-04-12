package com.example.lkw_test.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SumAmtByBranch {
	@Column(name = "BR_NAME")
	private String brName;		//관리점명

	@Id
	@Column(name = "BR_CODE")
	private String brCode;		//관리점코드
	
	@Column(name = "SUM_AMT")
	private long sumAmt;		//금액

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	public long getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(long sumAmt) {
		this.sumAmt = sumAmt;
	}
	
}	
