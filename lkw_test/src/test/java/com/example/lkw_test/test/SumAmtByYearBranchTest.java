package com.example.lkw_test.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.lkw_test.dto.SumAmtByYearBranchConvertList;
import com.example.lkw_test.service.BranchMarketingService;

@SpringBootTest
public class SumAmtByYearBranchTest {
	@Autowired
	BranchMarketingService branchMarketingService;
	
	@Test
	public void 지점별_연도별_합계금액_조회() {
		List<SumAmtByYearBranchConvertList> sumAmtByYearBranchConvertList = branchMarketingService.getSumAmtByYearBranch();
		assertNotNull(sumAmtByYearBranchConvertList);
		assertEquals(3, sumAmtByYearBranchConvertList.size());
	}
}
