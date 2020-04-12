package com.example.lkw_test.dto;

public class SumAmtByYearBranchConvert {
	private String brName;		//관리점명
	
	private String brCode;		//관리점코드
	
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
