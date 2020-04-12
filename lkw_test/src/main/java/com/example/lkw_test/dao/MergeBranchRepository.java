package com.example.lkw_test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.lkw_test.dto.MergeBranch;

public interface MergeBranchRepository extends JpaRepository<MergeBranch, String>{
	
	/*
	UPDATE CUSTOMER C
	SET C.BR_CODE = (SELECT B.BR_CODE FROM BRANCH B WHERE B.BR_NAME=:toBrName)
	WHERE C.BR_CODE = (SELECT B.BR_CODE FROM BRANCH B WHERE B.BR_NAME=:fromBrName)
	AND 0 < (SELECT COUNT(1) FROM BRANCH B WHERE B.BR_NAME=:fromBrName)
	*/
	@Transactional
	@Modifying
	@Query(value="UPDATE CUSTOMER C SET C.BR_CODE = (SELECT B.BR_CODE FROM BRANCH B WHERE B.BR_NAME=:toBrName) WHERE C.BR_CODE = (SELECT B.BR_CODE FROM BRANCH B WHERE B.BR_NAME=:fromBrName) AND 0 < (SELECT COUNT(1) FROM BRANCH B WHERE B.BR_NAME=:fromBrName)", nativeQuery=true)
	void updateCustomerInfo(@Param("fromBrName")String fromBrName, @Param("toBrName")String toBrName);
	
	/*
	DELETE FROM BRANCH B
	WHERE B.BR_NAME = :fromBrName
	AND 0 < (SELECT COUNT(1) FROM BRANCH B WHERE B.BR_NAME=:fromBrName)
	*/
	@Transactional
	@Modifying
	@Query(value="DELETE FROM BRANCH B WHERE B.BR_NAME = :fromBrName AND 0 < (SELECT COUNT(1) FROM BRANCH B WHERE B.BR_NAME=:fromBrName)", nativeQuery=true)
	void deleteBranchInfo(@Param("fromBrName")String fromBrName);
	
}
