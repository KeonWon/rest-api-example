package com.example.lkw_test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CustomerTransactionHistoryPK.class)
public class CustomerTransactionHistory {
	@Id
	@Column(name = "TRANS_DT")
	private String transDt;		//거래일자
	
	@Id
	@Column(name = "ACCT_NO")
	private String acctNo;		//계좌번호
	
	@Id
	@Column(name = "TRANS_SEQ")
	private int transSeq;		//거래번호
	
	@Column(name = "AMT")
	private long amt;		//금액
	
	@Column(name = "COMMISSTION")
	private int commission;		//수수료
	
	@Column(name = "CANCEL_YN")
	private char cancelYn;		//취소여부

	public String getTransDt() {
		return transDt;
	}

	public void setTransDt(String transDt) {
		this.transDt = transDt;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public int getTransSeq() {
		return transSeq;
	}

	public void setTransSeq(int transSeq) {
		this.transSeq = transSeq;
	}

	public long getAmt() {
		return amt;
	}

	public void setAmt(long amt) {
		this.amt = amt;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public char getCancelYn() {
		return cancelYn;
	}

	public void setCancelYn(char cancelYn) {
		this.cancelYn = cancelYn;
	}
	
	
}	
