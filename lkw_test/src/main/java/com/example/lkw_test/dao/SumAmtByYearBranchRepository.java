package com.example.lkw_test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.lkw_test.dto.SumAmtByYearBranch;

public interface SumAmtByYearBranchRepository extends JpaRepository<SumAmtByYearBranch, String>{
	
	/*
	SELECT
		TO_CHAR(TO_DATE(H.TRANS_DT, 'YYYY'),'YYYY') AS YEAR
		, B2.BR_NAME AS BR_NAME
		, B2.BR_CODE AS BR_CODE
		, SUM(H.AMT) AS SUM_AMT
	FROM (
		SELECT 
			B1.BR_NAME AS BR_NAME
			, B1.BR_CODE AS BR_CODE
			, C.ACCT_NO AS ACCT_NO
		FROM BRANCH B1
		INNER JOIN CUSTOMER C
		ON B1.BR_CODE = C.BR_CODE
	) B2
	INNER JOIN CUSTOMER_TRANSACTION_HISTORY H
	ON B2.ACCT_NO = H.ACCT_NO
	GROUP BY TO_CHAR(TO_DATE(H.TRANS_DT, 'YYYY'),'YYYY'), B2.BR_NAME, B2.BR_CODE
	ORDER BY TO_CHAR(TO_DATE(H.TRANS_DT, 'YYYY'),'YYYY'), SUM(H.AMT) DESC
	 */
	
	@Query(value="SELECT TO_CHAR(TO_DATE(H.TRANS_DT, 'YYYY'),'YYYY') AS YEAR, B2.BR_NAME AS BR_NAME, B2.BR_CODE AS BR_CODE, SUM(H.AMT) AS SUM_AMT FROM (SELECT B1.BR_NAME AS BR_NAME, B1.BR_CODE AS BR_CODE, C.ACCT_NO AS ACCT_NO FROM BRANCH B1 INNER JOIN CUSTOMER C ON B1.BR_CODE = C.BR_CODE ) B2 INNER JOIN CUSTOMER_TRANSACTION_HISTORY H ON B2.ACCT_NO = H.ACCT_NO GROUP BY TO_CHAR(TO_DATE(H.TRANS_DT, 'YYYY'),'YYYY'), B2.BR_NAME, B2.BR_CODE ORDER BY TO_CHAR(TO_DATE(H.TRANS_DT, 'YYYY'),'YYYY'), SUM(H.AMT) DESC", nativeQuery=true)
	List<SumAmtByYearBranch> getSumAmtByYearBranch();
}
