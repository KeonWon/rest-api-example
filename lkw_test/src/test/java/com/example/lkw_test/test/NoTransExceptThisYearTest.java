package com.example.lkw_test.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.lkw_test.dto.NoTransExceptThisYear;
import com.example.lkw_test.service.BranchMarketingService;

@SpringBootTest
public class NoTransExceptThisYearTest {
	@Autowired
	BranchMarketingService branchMarketingService;
	
	@Test
	public void 연도별_미거래_고객_조회() {
		List<NoTransExceptThisYear> noTransExceptThisYear = branchMarketingService.getNoTransExceptThisYear();
		assertNotNull(noTransExceptThisYear);
		assertEquals(6, noTransExceptThisYear.size());
	}
}
