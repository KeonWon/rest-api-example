package com.example.lkw_test.exception;

public class ApiErrorResponse {
    private String code;
    private String 메세지;

    public ApiErrorResponse(String code, String 메세지) {
        super();
        this.code = code;
        this.메세지 = 메세지;
    }
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String get메세지() {
		return 메세지;
	}

	public void set메세지(String 메세지) {
		this.메세지 = 메세지;
	}

    
}