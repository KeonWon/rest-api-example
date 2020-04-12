package com.example.lkw_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.lkw_test.dto.MostAmtByYear;
import com.example.lkw_test.dto.NoTransExceptThisYear;
import com.example.lkw_test.dto.SumAmtByBranch;
import com.example.lkw_test.dto.SumAmtByYearBranchConvertList;
import com.example.lkw_test.exception.NotFoundException;
import com.example.lkw_test.model.Branch;
import com.example.lkw_test.service.BranchMarketingService;

@RestController
public class BranchMarketingController {

	@Autowired
	BranchMarketingService branchMarketingService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home.jsp");
		return mv;
	}
	
	//1. 2018년, 2019년 각 연도별 합계 금액이 가장 많은 고객을 추출하는 API 개발.(단, 취소여부가 ‘Y’ 거래는 취소된 거래임, 합계 금액은 거래금액에서 수수료를 차감한 금액임)
	@GetMapping("/search/history/most-amt-by-year")
	public List<MostAmtByYear> getMostAmtByYear() {
		return branchMarketingService.getMostAmtByYear();
	}

	//2. 2018년 또는 2019년에 거래가 없는 고객을 추출하는 API 개발. (취소여부가 ‘Y’ 거래는 취소된 거래임)
	@GetMapping("/search/history/no-trans-except-this-year")
	public List<NoTransExceptThisYear> getNoTransExceptThisYear() {
		return branchMarketingService.getNoTransExceptThisYear();
	}
	
	//3. 연도별 관리점별 거래금액 합계를 구하고 합계금액이 큰 순서로 출력하는 API 개발.( 취소여부가 ‘Y’ 거래는 취소된 거래임)
	@GetMapping("/search/history/sum-amt-by-year-branch")
	public List<SumAmtByYearBranchConvertList> getSumAmtByYearBranch() {
		return branchMarketingService.getSumAmtByYearBranch();
	}
	
	//4. 분당점과 판교점을 통폐합하여 판교점으로 관리점 이관을 하였습니다. 지점명을 입력하면 해당지점의 거래금액 합계를 출력하는 API 개발( 취소여부가 ‘Y’ 거래는 취소된 거래임,)
	@PostMapping("/search/history/sum-amt")
	public List<SumAmtByBranch> getSumAmtByBranch(@RequestBody Branch branch) {
		String brName = branch.getBrName();
		if("분당점".equals(brName)) { //분당점 입력하는 경우, 404 Exception 처리
			throw new NotFoundException(); 
		}
		
		return branchMarketingService.getSumAmtByBranch(brName);
	}
}
	