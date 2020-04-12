package com.example.lkw_test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.lkw_test.dto.MostAmtByYear;

public interface MostAmtByYearRepository extends JpaRepository<MostAmtByYear, String>{
	
	/*
	SELECT 
	  H3.YEAR
	  , H3.NAME
	  , H3.ACCT_NO
	  , H3.SUM_AMT 
	FROM (
	  SELECT 
	    H2.YEAR
	    , H2.NAME
	    , H2.ACCT_NO
	    , H2.SUM_AMT
	    , ROW_NUMBER() OVER(PARTITION BY H2.YEAR ORDER BY H2.YEAR, H2.SUM_AMT DESC) AS IDX 
	  FROM (
	    SELECT 
	      TO_CHAR(TO_DATE(H1.TRANS_DT, 'YYYY'), 'YYYY') AS YEAR
	      , C.NAME AS NAME
	      , H1.ACCT_NO AS ACCT_NO
	      , SUM(H1.AMT-H1.COMMISSTION) AS SUM_AMT 
	    FROM CUSTOMER_TRANSACTION_HISTORY H1 
	    INNER JOIN CUSTOMER C 
	    ON H1.ACCT_NO = C.ACCT_NO 
	    WHERE H1.TRANS_DT NOT LIKE '2020%' 
	    AND H1.CANCEL_YN = 'N' 
	    GROUP BY TO_CHAR(TO_DATE(H1.TRANS_DT, 'YYYY'), 'YYYY'), H1.ACCT_NO 
	  ) H2 
	) H3 
	WHERE H3.IDX = 1
	*/

	@Query(value="SELECT H3.YEAR, H3.NAME, H3.ACCT_NO, H3.SUM_AMT FROM (SELECT H2.YEAR, H2.NAME, H2.ACCT_NO, H2.SUM_AMT, ROW_NUMBER() OVER(PARTITION BY H2.YEAR ORDER BY H2.YEAR, H2.SUM_AMT DESC) AS IDX FROM (SELECT TO_CHAR(TO_DATE(H1.TRANS_DT, 'YYYY'), 'YYYY') AS YEAR, C.NAME AS NAME, H1.ACCT_NO AS ACCT_NO, SUM(H1.AMT-H1.COMMISSTION) AS SUM_AMT FROM CUSTOMER_TRANSACTION_HISTORY H1 INNER JOIN CUSTOMER C ON H1.ACCT_NO = C.ACCT_NO WHERE H1.TRANS_DT NOT LIKE '2020%' AND H1.CANCEL_YN = 'N' GROUP BY TO_CHAR(TO_DATE(H1.TRANS_DT, 'YYYY'), 'YYYY'), H1.ACCT_NO ) H2 ) H3 WHERE H3.IDX = 1", nativeQuery=true)
	List<MostAmtByYear> getMostAmtByYear();
	
}
