package com.example.lkw_test.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.lkw_test.dto.MostAmtByYear;
import com.example.lkw_test.service.BranchMarketingService;

@SpringBootTest
public class MostAmtByYearTest {
	@Autowired
	BranchMarketingService branchMarketingService;
	
	@Test
	public void 연도별_최대_거래고객_건수_확인() {
		List<MostAmtByYear> mostAmtByYear = branchMarketingService.getMostAmtByYear();
		assertNotNull(mostAmtByYear);
		assertEquals(2, mostAmtByYear.size());
	}
}
