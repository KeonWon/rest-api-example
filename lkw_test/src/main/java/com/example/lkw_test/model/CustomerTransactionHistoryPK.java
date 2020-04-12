package com.example.lkw_test.model;

import java.io.Serializable;

public class CustomerTransactionHistoryPK implements Serializable{
	private String transDt;		//거래일자
	private String acctNo;		//계좌번호
	private int transSeq;		//거래번호
}
