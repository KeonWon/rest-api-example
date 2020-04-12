package com.example.lkw_test.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(SumAmtByYearBranchPK.class)
public class SumAmtByYearBranch {
	@Id
	@Column(name = "YEAR")
	private String year;		//거래년도
	
	@Column(name = "BR_NAME")
	private String brName;		//관리점명
	
	@Id
	@Column(name = "BR_CODE")
	private String brCode;		//관리점코드
	
	@Column(name = "SUM_AMT")
	private long sumAmt;		//금액

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

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
