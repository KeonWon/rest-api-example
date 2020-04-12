package com.example.lkw_test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Branch {
	@Id
	@Column(name = "BR_CODE")
	private String brCode;	//관리점코드
	
	@Column(name = "BR_NAME")
	private String brName;	//관리점명

	public String getBrCode() {
		return brCode;
	}

	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}
	
	
}
