package com.example.lkw_test.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MergeBranch {
	@Id
	@Column(name = "FROM_BR_NAME")
	private String fromBrName;	//인수지점명
	
	@Column(name = "TO_BR_NAME")
	private String toBrName;	//인계지점명

	public String getFromBrName() {
		return fromBrName;
	}

	public void setFromBrName(String fromBrName) {
		this.fromBrName = fromBrName;
	}

	public String getToBrName() {
		return toBrName;
	}

	public void setToBrName(String toBrName) {
		this.toBrName = toBrName;
	}
	
}	
