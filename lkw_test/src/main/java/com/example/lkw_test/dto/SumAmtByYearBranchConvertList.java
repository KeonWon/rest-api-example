package com.example.lkw_test.dto;

import java.util.ArrayList;

public class SumAmtByYearBranchConvertList {
	private String year;		//거래년도
	
	private ArrayList<SumAmtByYearBranchConvert> dataList; //연도별 지점별 거래금액 합계 (sumAmtByYearBranchConvert)

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public ArrayList<SumAmtByYearBranchConvert> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<SumAmtByYearBranchConvert> dataList) {
		this.dataList = dataList;
	}
	
}
