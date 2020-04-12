package com.example.lkw_test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lkw_test.dao.MergeBranchRepository;
import com.example.lkw_test.dao.MostAmtByYearRepository;
import com.example.lkw_test.dao.NoTransExceptThisYearRepository;
import com.example.lkw_test.dao.SumAmtByBranchRepository;
import com.example.lkw_test.dao.SumAmtByYearBranchRepository;
import com.example.lkw_test.dto.MostAmtByYear;
import com.example.lkw_test.dto.NoTransExceptThisYear;
import com.example.lkw_test.dto.SumAmtByBranch;
import com.example.lkw_test.dto.SumAmtByYearBranch;
import com.example.lkw_test.dto.SumAmtByYearBranchConvert;
import com.example.lkw_test.dto.SumAmtByYearBranchConvertList;

@Service
public class BranchMarketingService {
	
	@Autowired
	MostAmtByYearRepository mostAmtByYearRepo;
	
	@Autowired
	NoTransExceptThisYearRepository noTransExceptThisYearRepo;
	
	@Autowired
	SumAmtByYearBranchRepository sumAmtByYearBranchRepo;
	
	@Autowired
	SumAmtByBranchRepository sumAmtByBranchRepo;
	
	@Autowired
	MergeBranchRepository mergeBranchRepo;
	
	public List<MostAmtByYear> getMostAmtByYear() {
		return mostAmtByYearRepo.getMostAmtByYear();
	}
	
	public List<NoTransExceptThisYear> getNoTransExceptThisYear() {
		return noTransExceptThisYearRepo.getNoTransExceptThisYear();
	}
	
	public List<SumAmtByYearBranchConvertList> getSumAmtByYearBranch() {
		List<SumAmtByYearBranchConvertList> resultList = new ArrayList<SumAmtByYearBranchConvertList>();
		
		List<SumAmtByYearBranch> sumAmtByYearBranchArrList = new ArrayList<SumAmtByYearBranch>();
		sumAmtByYearBranchArrList = sumAmtByYearBranchRepo.getSumAmtByYearBranch();
		
		//json data 연도별로 세팅하기 위한 로직
		/*
		ex)
		[                                      [                            
		{“year”:2018,                          {“year”: 2018,               
		 “brName”:”관리점명”,                     “dataList”:[                
		 “brCode”:”관리점코드”,                    {                        
		 “sumAmt”:0000}                        	“brName”: “관리점명”,        
		{“year”:2019,                -->       	“brCode”: “관리점코드”,       
		 “brName”:”관리점명”,                  	“sumAmt”: 0000           
		 “brCode”:”관리점코드”,                	}                        
		 “sumAmt”:0000}                          ]                          
		]                                      },                           
				                               {“year”: 2019,               
										       	 “dataList”:[            
										       	    {                    
										       		“brName”: “관리점명”,    
										       		“brCode”: “관리점코드”,   
										       		“sumAmt”: 0000       
										       		}                    
										       	  ]                      
										       	}                        
										       ]                            
		*/								
		int fromIndex = 0;
		int toIndex = 0;
		String year = "";
		boolean fromToFlag = true;
		for (int currIndex = 0; currIndex < sumAmtByYearBranchArrList.size(); currIndex++) {
			
			if(!sumAmtByYearBranchArrList.get(currIndex).getYear().equals(year) && fromToFlag) { //fromIndex
				if(currIndex == 0)	fromIndex = currIndex;
				else	fromIndex = currIndex-1;

				fromToFlag = false;
				
				year = sumAmtByYearBranchArrList.get(fromIndex).getYear();
				continue;
			}
			
			if(!sumAmtByYearBranchArrList.get(currIndex).getYear().equals(year)) { //toIndex
				toIndex = currIndex;
				fromToFlag = true;
				
				System.out.println("-------------------------------------");
				System.out.println("[sublist - fromIndex : "+fromIndex+", toIndex : "+toIndex+"]");
				System.out.println("-------------------------------------");
				
				List<SumAmtByYearBranch> subList = sumAmtByYearBranchArrList.subList(fromIndex, toIndex);
				List<SumAmtByYearBranchConvert> sumAmtByYearBranchConvertList = new ArrayList<SumAmtByYearBranchConvert>();
				for(SumAmtByYearBranch sub : subList) {
					SumAmtByYearBranchConvert sumAmtByYearBranchConvert = new SumAmtByYearBranchConvert();
					sumAmtByYearBranchConvert.setBrCode(sub.getBrCode());
					sumAmtByYearBranchConvert.setBrName(sub.getBrName());
					sumAmtByYearBranchConvert.setSumAmt(sub.getSumAmt());
					sumAmtByYearBranchConvertList.add(sumAmtByYearBranchConvert);
				}
				SumAmtByYearBranchConvertList sumAmtByYearBranchList = new SumAmtByYearBranchConvertList();
				sumAmtByYearBranchList.setYear(year);
				sumAmtByYearBranchList.setDataList((ArrayList<SumAmtByYearBranchConvert>) sumAmtByYearBranchConvertList);
				
				resultList.add(sumAmtByYearBranchList);
			}
			
			if(currIndex == sumAmtByYearBranchArrList.size()-1) { // 마지막 Index 처리
				fromIndex = currIndex;
				toIndex = currIndex+1;
				year = sumAmtByYearBranchArrList.get(fromIndex).getYear();
				
				System.out.println("-------------------------------------");
				System.out.println("[sublist(last) - fromIndex : "+fromIndex+", toIndex : "+toIndex+"]");
				System.out.println("-------------------------------------");
				
				List<SumAmtByYearBranch> subList = sumAmtByYearBranchArrList.subList(fromIndex, toIndex);
				List<SumAmtByYearBranchConvert> sumAmtByYearBranchConvertList = new ArrayList<SumAmtByYearBranchConvert>();
				for(SumAmtByYearBranch sub : subList) {
					SumAmtByYearBranchConvert sumAmtByYearBranchConvert = new SumAmtByYearBranchConvert();
					sumAmtByYearBranchConvert.setBrCode(sub.getBrCode());
					sumAmtByYearBranchConvert.setBrName(sub.getBrName());
					sumAmtByYearBranchConvert.setSumAmt(sub.getSumAmt());
					sumAmtByYearBranchConvertList.add(sumAmtByYearBranchConvert);
				}
				SumAmtByYearBranchConvertList sumAmtByYearBranchList = new SumAmtByYearBranchConvertList();
				sumAmtByYearBranchList.setYear(year);
				sumAmtByYearBranchList.setDataList((ArrayList<SumAmtByYearBranchConvert>) sumAmtByYearBranchConvertList);
				
				resultList.add(sumAmtByYearBranchList);
				break;
			}
		}
		
		return resultList;
	}
	
	public List<SumAmtByBranch> getSumAmtByBranch(String brName) {
		//기초데이터가 판교점, 분당점이 개별로 존재하기 떄문에, 판교점 입력의 경우 customer, branch 테이블 patch 후 결과 조회
		if("판교점".equals(brName)) { 
			String fromBrName = "분당점";
			String toBrName = brName;
			System.out.println("-------------------------------------");
			System.out.println("[mergeBranch - fromBrName : "+fromBrName+", toBrName : "+toBrName+"]");
			System.out.println("-------------------------------------");
			mergeBranchRepo.updateCustomerInfo(fromBrName, toBrName);
			mergeBranchRepo.deleteBranchInfo(fromBrName);
		}
		
		return sumAmtByBranchRepo.getSumAmtByBranch(brName);
	}
}
