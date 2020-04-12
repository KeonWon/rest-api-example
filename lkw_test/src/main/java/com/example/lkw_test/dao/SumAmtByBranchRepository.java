package com.example.lkw_test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lkw_test.dto.SumAmtByBranch;

public interface SumAmtByBranchRepository extends JpaRepository<SumAmtByBranch, String>{
	
	/*
	SELECT
		B2.BR_NAME AS BR_NAME
		, B2.BR_CODE AS BR_CODE
		, SUM(H.AMT) AS SUM_AMT
	FROM (
		SELECT
			C.ACCT_NO AS ACCT_NO
			, B1.BR_CODE AS BR_CODE
			, B1.BR_NAME AS BR_NAME
		FROM BRANCH B1
		INNER JOIN CUSTOMER C
		ON B1.BR_CODE = C.BR_CODE
		WHERE B1.BR_NAME=:brName
	) B2
	INNER JOIN (
		SELECT 
			H.ACCT_NO AS ACCT_NO
			, H.AMT AS AMT
		FROM CUSTOMER_TRANSACTION_HISTORY H
		WHERE H.CANCEL_YN = 'N'
	) H
	ON B2.ACCT_NO =  H.ACCT_NO
	GROUP BY B2.BR_NAME, B2.BR_CODE
	*/
	
	@Query(value="SELECT B2.BR_NAME AS BR_NAME, B2.BR_CODE AS BR_CODE, SUM(H.AMT) AS SUM_AMT FROM (SELECT C.ACCT_NO AS ACCT_NO, B1.BR_CODE AS BR_CODE, B1.BR_NAME AS BR_NAME FROM BRANCH B1 INNER JOIN CUSTOMER C ON B1.BR_CODE = C.BR_CODE WHERE B1.BR_NAME=:brName) B2 INNER JOIN (SELECT H.ACCT_NO AS ACCT_NO, H.AMT AS AMT FROM CUSTOMER_TRANSACTION_HISTORY H WHERE H.CANCEL_YN = 'N') H ON B2.ACCT_NO =  H.ACCT_NO GROUP BY B2.BR_NAME, B2.BR_CODE", nativeQuery=true)
	List<SumAmtByBranch> getSumAmtByBranch(@Param("brName")String brName);

}
